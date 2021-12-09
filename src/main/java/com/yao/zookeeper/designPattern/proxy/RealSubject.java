package com.yao.zookeeper.designPattern.proxy;

/**
 * Created by yaojian on 2021/10/22 15:15
 *
 * @author
 */
public class RealSubject implements Subject {
    @Override
    public void play() {
        System.out.println("开始玩游戏");
    }
}
