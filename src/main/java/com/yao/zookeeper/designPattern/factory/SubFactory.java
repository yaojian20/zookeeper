package com.yao.zookeeper.designPattern.factory;

/**
 * Created by yaojian on 2021/10/22 15:48
 *
 * @author
 */
public class SubFactory implements Factory {
    @Override
    public BaseComputer getComputer() {
        return new SubComputer();
    }
}
