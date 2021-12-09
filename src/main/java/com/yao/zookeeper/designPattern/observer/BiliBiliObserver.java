package com.yao.zookeeper.designPattern.observer;

/**
 * Created by yaojian on 2021/11/3 9:27
 *
 * @author
 */
public class BiliBiliObserver extends Observer {


    @Override
    void update() {
        System.out.println(subject.subjectState + name + "正在关闭BiliBili并开始工作!");
    }
}
