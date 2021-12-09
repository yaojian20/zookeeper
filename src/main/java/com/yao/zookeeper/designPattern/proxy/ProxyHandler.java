package com.yao.zookeeper.designPattern.proxy;

import javax.xml.transform.Source;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yaojian on 2021/10/22 15:22
 *
 * @author
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前");
        method.invoke(object,args);
        System.out.println("执行方法后");
        return null;
    }
}
