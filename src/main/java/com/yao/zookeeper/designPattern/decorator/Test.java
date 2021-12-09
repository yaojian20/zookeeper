package com.yao.zookeeper.designPattern.decorator;

/**
 * Created by yaojian on 2021/10/22 10:59
 *
 * @author
 */
public class Test {

    /**
     * 装饰者实现原理:1.首先要有被装饰者的抽象接口和具体实现类
     * 2.装饰者抽象类有一个属性是被装饰者的抽象接口类,此抽象类要实现被装饰者的的被装饰方法,并调用被装饰者接口对象的被装饰方法(实现装饰者抽象类是为了等会装饰的时候能够将装饰者类注入装饰者类->也就是装饰者类可以装饰装饰者类)
     * 3.具体装饰者需要继承装饰者抽象类,并重写被装饰方法(调用父类的方法,再加上自己新加的职责操作)
     * 4.然后开始装饰(想要装饰哪个类,就在装饰类中set被装饰类)
     */

    public static void main(String[] args) {

        Man man = new Man("蔡徐坤");

        DecoratorA decoratorA = new DecoratorA();
        DecoratorB decoratorB = new DecoratorB();
        DecoratorC decoratorC = new DecoratorC();

        //开始装饰
        decoratorA.setPerson(man);
        decoratorB.setPerson(decoratorA);
        decoratorC.setPerson(decoratorB);
        decoratorC.show();

    }
}
