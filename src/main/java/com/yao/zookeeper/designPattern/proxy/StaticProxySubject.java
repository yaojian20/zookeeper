package com.yao.zookeeper.designPattern.proxy;

/**
 * Created by yaojian on 2021/10/22 15:17
 * 静态代理-->(如果要代理不同的类,要写很多个代理类)
 * @author
 */
public class StaticProxySubject implements Subject {

    private RealSubject realSubject;

    @Override
    public void play() {
        System.out.println("开始开电脑");
        if (realSubject == null){
            realSubject = new RealSubject();
        }

        realSubject.play();

    }
}
