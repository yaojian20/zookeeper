package com.yao.zookeeper.designPattern.template;

/**
 * Created by yaojian on 2021/10/26 15:28
 *
 * @author
 */
public class BasketballGame extends Game{

    @Override
    void beforeGame() {
        System.out.println("开始打开篮球游戏!");
    }

    @Override
    void gameing() {
        System.out.println("篮球游戏开始!红队蓝队上场!");
    }

    @Override
    void afterGame() {
        System.out.println("篮球游戏结束!红队获得56分,蓝队获得47分,红队获胜!");
    }

}
