package com.yao.zookeeper.designPattern.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by yaojian on 2021/10/22 15:27
 *
 * @author
 */
public class Test {

    public static void main(String[] args) {
        //动态代理

        Subject subject = new RealSubject();
        ProxyHandler proxyHandler = new ProxyHandler(subject);

        Subject proxySubject = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),proxyHandler);

        proxySubject.play();

    }
}
