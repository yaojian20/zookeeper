package com.yao.zookeeper.designPattern.observer;

/**
 * Created by yaojian on 2021/11/2 17:30
 *
 * @author
 */
public class NBAObserver extends Observer {

    @Override
    void update() {
        System.out.println(subject.subjectState + name + "正在关闭NBA并开始工作!");
    }


}
