package com.yao.zookeeper.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaojian on 2021/11/3 10:24
 *
 * @author
 */
public class Reception extends Subject {
    private  List<Observer> observers = new ArrayList<>();

    /**
     * 添加观察者
     * @param observer
     */
    @Override
    void attatch(Observer observer) {
        observers.add(observer);
    }

    @Override
    void detatch(Observer observer) {
        if (!observers.isEmpty()){
            observers.remove(observer);
        }
    }

    @Override
    void notifyObserver() {

        if (observers != null && observers.size() > 0){
            for (Observer observer : observers){
                observer.update();
            }
        }

    }
}
