package com.yao.zookeeper.designPattern.factory;

/**
 * Created by yaojian on 2021/10/21 16:58
 * 加法计算类
 * @author
 */
public class AddComputer extends BaseComputer {

    @Override
    public int getResult(int numberA,int numberB) {
        return numberA + numberB;
    }
}
