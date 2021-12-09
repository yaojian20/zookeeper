package com.yao.zookeeper.designPattern.decorator;

/**
 * Created by yaojian on 2021/10/22 10:42
 * 装饰者的抽象类
 * @author
 */
public abstract class Decorator implements Person{

    private Person person;

    public void setPerson(Person person){
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
    }
}
