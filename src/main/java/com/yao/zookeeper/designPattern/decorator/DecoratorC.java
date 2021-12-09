package com.yao.zookeeper.designPattern.decorator;

/**
 * Created by yaojian on 2021/10/22 10:58
 *
 * @author
 */
public class DecoratorC extends Decorator {

    @Override
    public void show() {
        super.show();
        System.out.println("开始穿鞋子");
    }
}
