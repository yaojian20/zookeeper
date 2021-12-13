package com.yao.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;

/**
 * Created by yaojian on 2021/12/13 9:25
 *
 * @author
 */
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorUtil.getInstance();
        CuratorCache curatorCache = CuratorCache.builder(curatorFramework,"/node").build();
        PathChildrenCacheListener listener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                switch (pathChildrenCacheEvent.getType()){
                    case INITIALIZED:
                        System.out.println("初始化===================");
                        break;
                    case CHILD_ADDED:
                        System.out.println("增加子节点===============" + pathChildrenCacheEvent.getData());
                        break;
                    case CHILD_REMOVED:
                        System.out.println("正在移除子节点===============");
                        break;
                    case CHILD_UPDATED:
                        System.out.println("正在更新子节点================");
                }
            }
        };
        CuratorCacheListener cacheListener = CuratorCacheListener.builder().forPathChildrenCache("/node",curatorFramework,listener).build();
        curatorCache.listenable().addListener(cacheListener);
        curatorCache.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData oldData, ChildData data) {
                switch (type){
                    case NODE_CREATED:
                        System.out.println("创建节点！！！！！！！！！！！！！！！！oldData is :" + oldData + "newData is :" + data);
                        break;
                    case NODE_CHANGED:
                        System.out.println("更新节点！！！！！！！！！！！！！！！！oldData is :" + oldData + "newData is :" + data);
                        break;
                    case NODE_DELETED:
                        System.out.println("删除节点！！！！！！！！！！！！！！！！oldData is :" + oldData + "newData is :" + data);
                        break;
                }
                System.out.println("==================================================");
            }
        });
        curatorCache.start();
        curatorFramework.create().creatingParentsIfNeeded().forPath("/node","value".getBytes());
        curatorFramework.setData().forPath("/node","value2".getBytes());
        curatorFramework.create().creatingParentsIfNeeded().forPath("/node/child","123".getBytes());
        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/node");
        System.in.read();
    }

}
