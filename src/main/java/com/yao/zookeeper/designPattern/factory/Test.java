package com.yao.zookeeper.designPattern.factory;

/**
 * Created by yaojian on 2021/10/21 17:09
 *
 * @author
 */
public class Test {

    public static void main(String[] args) {
        int a = 100;
        int b = 50;

        //简单工厂模式
        BaseComputer baseComputer = ComputerSimpleFactory.getComputer("+");
        int result = baseComputer.getResult(a,b);
        System.out.println(result);

        //工厂模式
        Factory factory = new SubFactory();
        BaseComputer baseComputer1 = factory.getComputer();
        int result2 = baseComputer1.getResult(a,b);
        System.out.println(result2);


    }
}
