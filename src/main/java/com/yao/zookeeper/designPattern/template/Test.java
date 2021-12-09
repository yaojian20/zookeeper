package com.yao.zookeeper.designPattern.template;

/**
 * Created by yaojian on 2021/10/26 15:45
 *
 * @author
 */
public class Test {

    public static void main(String[] args) {

        Game basketballGame = new BasketballGame();
        basketballGame.initGame();

        System.out.println("~~~~~~~~~~~~~~~~~我是分割线~~~~~~~~~~~~~~~~~~");

        Game contraGame = new ContraGame();
        contraGame.initGame();


    }


}
