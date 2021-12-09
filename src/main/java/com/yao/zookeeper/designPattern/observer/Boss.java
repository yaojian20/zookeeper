package com.yao.zookeeper.designPattern.observer;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yaojian on 2021/11/2 17:24
 * 具体通知者
 * @author
 */
public class Boss extends Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    void attatch(Observer observer) {

        observers.add(observer);
    }

    @Override
    void detatch(Observer observer) {
        observers.remove(observer);
    }

    @Override
    void notifyObserver() {
        if (!CollectionUtils.isEmpty(observers)){
            for (Observer observer : observers){
                observer.update();
            }

        }
    }
}
