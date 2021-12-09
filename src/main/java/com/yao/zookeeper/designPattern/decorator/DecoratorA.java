package com.yao.zookeeper.designPattern.decorator;

/**
 * Created by yaojian on 2021/10/22 10:46
 * 装饰者的具体类A
 * @author
 */
public class DecoratorA extends Decorator {

    @Override
    public void show() {
        //可以在这加额外的职责
        super.show();
        System.out.println("开始穿T恤");
    }
}
