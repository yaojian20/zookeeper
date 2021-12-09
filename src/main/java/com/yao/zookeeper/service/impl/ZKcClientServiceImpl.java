package com.yao.zookeeper.service.impl;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkLock;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yaojian on 2021/9/16 11:34
 *
 * @author
 */

//@Service
public class ZKcClientServiceImpl {

    private static final String LOCK_NODE = "/lock";
    private static final String CHILD_NODE = "/child_";

    private String lockName;

    public ZKcClientServiceImpl() {
        if (zkClient == null){
            zkClient = new ZkClient("127.0.0.1:2181",4000);
        }
    }

    @Autowired
    private ZkClient zkClient;


    /**
     * @description 创建持久化zk节点
     * @param path 节点路径
     * @param createParents 是否要自动递归创建父节点
     */
    public void createPersistant(String path,boolean createParents){
        zkClient.createPersistent(path,createParents);

    }


    //取到分布式锁
    public String getLock() throws InterruptedException {
        if (!zkClient.exists(LOCK_NODE)){
            //如果该节点不存在的话,创建该节点
            zkClient.createPersistent(LOCK_NODE);
        }
        //创建临时顺序节点  /lock/child_0000000000,/lock/child_0000000001,依此类推
        String lockName = zkClient.createEphemeralSequential(LOCK_NODE+CHILD_NODE,"lock");
        acquireLock(lockName);
        return lockName;
    }

    //关闭分布式锁
    public void unLock() throws InterruptedException {
        if (!zkClient.exists(LOCK_NODE)){
            //如果该节点不存在的话,创建该节点
            zkClient.createPersistent(LOCK_NODE);
        }
        zkClient.delete(lockName);
        lockName = null;
        zkClient.close();
    }


    //获取锁
    public boolean acquireLock(String lockName) throws InterruptedException {
        //获得lock下所有的节点
        List<String> childNodes = zkClient.getChildren(LOCK_NODE);
        childNodes.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //升序排列,第一个是最小的值
                return Integer.parseInt(o1.split("_")[1]) - Integer.parseInt(o2.split("_")[1]);
            }
        });
        // 如/lock/child_000000001那么,子节点就是child_000000001,即lockName.split("/")[lockName.split("/").length-1]
        int index = childNodes.indexOf(lockName.split("/")[lockName.split("/").length-1]);
        if (index < 0){
            //如果小于0,说明该节点在zk中不存在
            throw new ZkNoNodeException(lockName + "节点不存在");
        } else if (index == 0){
            //说明此时拿到了锁
            this.lockName = lockName;
            System.out.println(lockName+"拿到了锁!");
            return true;
        } else if (index > 0){
            //index大于0时,说明zk中有这个节点,但是有人比他更早拿到创建节点,也就是别人拿到了锁,所以他要继续等待,重新拿锁
            final  CountDownLatch countDownLatch = new CountDownLatch(1);
            //监听数据->如果当前节点的前一个节点被删除了,那么说明现在轮到当前节点了
            IZkDataListener iZkDataListener = new IZkDataListener() {
                @Override
                public void handleDataChange(String s, Object o) throws Exception {

                }

                @Override
                public void handleDataDeleted(String s) throws Exception {
                    //节点被删除
                    System.out.println(s+"节点被删除");
                    acquireLock(lockName);
                    countDownLatch.countDown();

                }
            };

            try {
                //设置监听节点
                zkClient.subscribeDataChanges(LOCK_NODE+"/"+childNodes.get(index-1),iZkDataListener);
                //countDownLatch为0之前主线程阻塞
                countDownLatch.await();
            }finally {
                //停止监听这个节点
                zkClient.unsubscribeDataChanges(LOCK_NODE+"/"+childNodes.get(index-1),iZkDataListener);
            }
        }
        return false;
    }

}
