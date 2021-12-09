package com.yao.zookeeper.designPattern.factory;

/**
 * Created by yaojian on 2021/10/21 17:03
 * 计算类的工厂类
 * @author
 */
public class ComputerSimpleFactory {

    public static BaseComputer getComputer(String operation){
        switch (operation){
            case "+":
                return new AddComputer();
            case "-":
                return new SubComputer();
            default:
                return new BaseComputer();
        }
    }


}
