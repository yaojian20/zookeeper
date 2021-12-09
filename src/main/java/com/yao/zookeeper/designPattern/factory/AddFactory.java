package com.yao.zookeeper.designPattern.factory;

/**
 * Created by yaojian on 2021/10/22 15:47
 * 加法工厂
 * @author
 */
public class AddFactory implements Factory {
    @Override
    public BaseComputer getComputer() {
        return new AddComputer();
    }
}
