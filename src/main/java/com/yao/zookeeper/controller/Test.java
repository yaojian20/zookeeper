package com.yao.zookeeper.controller;

import com.yao.zookeeper.config.ZookeeperConfig;
import com.yao.zookeeper.service.impl.ZKcClientServiceImpl;

/**
 * Created by yaojian on 2021/9/17 10:46
 *
 * @author
 */
public class Test {

    public static void main(String[] args) {
        ZKcClientServiceImpl zKcClientService = new ZKcClientServiceImpl();
        for (int i=0;i<30;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String lockName = zKcClientService.getLock();
                        System.out.println(Thread.currentThread().getName() + ":lockName is :" + lockName);
                        zKcClientService.unLock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-" + i);
            thread.start();
        }
    }

}
