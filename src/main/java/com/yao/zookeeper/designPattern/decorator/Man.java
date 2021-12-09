package com.yao.zookeeper.designPattern.decorator;

/**
 * Created by yaojian on 2021/10/22 10:40
 * 被装饰的具体类
 * @author
 */
public class Man implements  Person{

    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(this.name + "开始穿衣服");
    }

}
