package com.yao.zookeeper.designPattern.template;

/**
 * Created by yaojian on 2021/10/22 17:15
 * 模版类
 * @author
 */
public abstract class Game {

    abstract void beforeGame();

    abstract void gameing();

    abstract void afterGame();

    //模版方法,不能修改->(final修饰)
    public final void initGame(){
        beforeGame();
        gameing();
        afterGame();

    }



}
