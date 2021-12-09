package com.yao.zookeeper.designPattern.observer;

/**
 * Created by yaojian on 2021/11/2 17:03
 *
 * 通知者接口
 * @author
 */
public abstract class Subject {

    //通知者状态
    String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }

    /**
     * 添加要通知的观察者
     * @param observer
     */
    abstract void attatch(Observer observer);


    /**
     * 去除要通知的观察者
     * @param observer
     */
    abstract void detatch(Observer observer);

    /**
     * 通知观察者
     */
    abstract void notifyObserver();

}
