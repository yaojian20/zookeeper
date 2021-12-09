package com.yao.zookeeper.designPattern.prototype;

/**
 * Created by yaojian on 2021/10/22 16:05
 * 原型模式
 * @author
 */
public class Test {
    /**
     * 原型模式是通过拷贝原型实例得到一个新对象,这个时候操作新对象之后不会影响到之前的对象
     *
     *
     */


    public static void main(String[] args) throws CloneNotSupportedException {
        Student yuwen = new Student("小明",16,new Grade());
        yuwen.getGrade().setGrade(89);
        yuwen.getGrade().setProjectName("语文");
        System.out.println(yuwen);

        Student shuxue = (Student)yuwen.clone();
        shuxue.getGrade().setProjectName("数学");
        shuxue.getGrade().setGrade(95);
        System.out.println(shuxue);

        Student yingyu = (Student)yuwen.clone();
        yingyu.getGrade().setProjectName("英语");
        yingyu.getGrade().setGrade(93);
        System.out.println(yingyu);

    }


}
