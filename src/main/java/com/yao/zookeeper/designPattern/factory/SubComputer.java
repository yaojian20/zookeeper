package com.yao.zookeeper.designPattern.factory;

/**
 * Created by yaojian on 2021/10/21 17:00
 * 减法计算类
 * @author
 */
public class SubComputer extends  BaseComputer {


    @Override
    public int getResult(int numberA, int numberB) {
        return numberA - numberB;

    }
}