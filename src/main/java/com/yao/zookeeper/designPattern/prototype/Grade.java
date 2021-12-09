package com.yao.zookeeper.designPattern.prototype;

/**
 * Created by yaojian on 2021/10/22 16:05
 * 需要实现cloneable
 * @author
 */
public class Grade implements Cloneable{

    //成绩
    private double grade;

    //学科名
    private String projectName;

    public Grade() {
    }

    public Grade(double grade, String projectName) {
        this.grade = grade;
        this.projectName = projectName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
