package com.yao.zookeeper.designPattern.prototype;

/**
 * Created by yaojian on 2021/10/22 16:05
 *
 * @author
 */
public class Student implements Cloneable{

    //姓名
    private String name;

    //年龄
    private int age;

    public Student() {
    }

    public Student(String name, int age, Grade grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    //成绩
    private Grade grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //clone方法只能拷贝对象本身(包括里面的基本类型的变量),但是他不会拷贝对象里的拷贝类型变量,所以拷贝之后的对象跟拷贝之前的对象的引用对象指向同一个变量,所以这种克隆只能叫做浅克隆
        //解决办法:手动再克隆一次引用对象
        //因为student里含有grade这个引用对象
        Student student = (Student) super.clone();
        student.setGrade((Grade) student.getGrade().clone());
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
