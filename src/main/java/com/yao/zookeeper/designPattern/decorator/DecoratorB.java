package com.yao.zookeeper.designPattern.decorator;

/**
 * Created by yaojian on 2021/10/22 10:55
 * 装饰者具体类B
 * @author
 */
public class DecoratorB extends Decorator {

    @Override
    public void show() {
        super.show();
        System.out.println("开始穿牛仔裤");
    }
}
