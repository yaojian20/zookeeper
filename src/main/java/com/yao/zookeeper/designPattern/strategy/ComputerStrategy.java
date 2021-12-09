package com.yao.zookeeper.designPattern.strategy;

import com.yao.zookeeper.designPattern.factory.BaseComputer;
import com.yao.zookeeper.designPattern.factory.ComputerSimpleFactory;

/**
 * Created by yaojian on 2021/10/22 9:19
 * 策略模式
 * @author
 */
public class ComputerStrategy {

    /**
     * 策略模式 以相同的方式调用所有的算法,减少了算法类和使用方法类之间的耦合,但是算法类需要由客户端生成传入,所以可以将工厂模式和策略模式结合,将生成算法类的工作交给工厂类
     */

    private BaseComputer baseComputer;

    public ComputerStrategy(BaseComputer baseComputer) {
        this.baseComputer = baseComputer;
    }

    public ComputerStrategy(String operation) {
        //策略模式+工厂模式
        this.baseComputer = ComputerSimpleFactory.getComputer(operation);
    }

    private int getResult(int a,int b){
        return this.baseComputer.getResult(a,b);
    }

}
