package com.yao.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * Created by yaojian on 2021/12/13 20:00
 *
 * @author
 */
public class MyThread extends Thread {

    //可重入排他锁
    private InterProcessMutex lock = new InterProcessMutex(CuratorUtil.getInstance(), "/lock");

    @Override
    public void run() {
        try {
            lock.acquire(5000, TimeUnit.SECONDS);
            System.out.println("抢到之前还剩" + LockDemo.allNum);
            System.out.println(Thread.currentThread().getName() + "抢到票了！");
            LockDemo.allNum-- ;
            System.out.println("抢到之后还剩" + LockDemo.allNum);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
