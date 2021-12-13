package com.yao.curator;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * Created by yaojian on 2021/12/13 19:59
 *
 * @author
 */
public class LockDemo {
    //本地模拟时需要修改zoo.cfg maxClientCnxns=300(这样允许一个ip最多能建立300个连接，不然zookeeper回报too many connections的错)

    public static int allNum = 100;

    public static void main(String[] args) {

        for (int i =0 ;i < 100 ; i++){
            MyThread myThread = new MyThread();
            myThread.setName("thread-" + i);
            myThread.start();
        }



    }




}
