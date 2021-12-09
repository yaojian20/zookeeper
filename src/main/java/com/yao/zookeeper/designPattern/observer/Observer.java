package com.yao.zookeeper.designPattern.observer;

/**
 * Created by yaojian on 2021/11/2 17:01
 *
 * 观察者抽象类
 * @author
 */
public abstract class Observer {

    //观察者姓名
    protected String name;

    //通知者类
    protected Subject subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    abstract void update();




}
