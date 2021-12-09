package com.yao.zookeeper.designPattern.template;

/**
 * Created by yaojian on 2021/10/26 15:34
 *
 * @author
 */
public class ContraGame extends Game{
    @Override
    void beforeGame() {
        System.out.println("魂斗罗游戏开始!");
    }

    @Override
    void gameing() {
        System.out.println("魂斗罗第一关通过!");
        System.out.println("魂斗罗第二关通过!");
        System.out.println("魂斗罗第三关通过!");
        System.out.println("****************");
    }

    @Override
    void afterGame() {

        System.out.println("恭喜通过魂斗罗!");

    }
}
