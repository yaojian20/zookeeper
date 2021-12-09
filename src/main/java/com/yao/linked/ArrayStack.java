package com.yao.linked;

import java.util.Objects;

/**
 * Created by yaojian on 2021/9/26 15:26
 *
 * @author
 */
public class ArrayStack<E> implements Stack<E> {

    //栈的顺序存储实现 -> 栈先进后出

    //存储数组
    private Object[] elements;
    //默认长度
    private static final int DEFAULT_LENGTH = 8;
    //数组长度
    private int size;
    //栈顶下标
    private int top;

    public ArrayStack(int size) {
        this.size = size;
        this.elements = new Object[this.size];
        //初始栈顶位置为-1
        this.top=-1;
    }

    public ArrayStack() {
        this.size = DEFAULT_LENGTH;
        this.elements = new Object[this.size];
        this.top=-1;
    }

    //入栈
    @Override
    public E push(E item) {
        elements[++top] = item;
        return item;
    }

    //出栈
    @Override
    public E pop() {
        E element = (E)elements[top];
        elements[top--] = null;
        return element;
    }

    //取栈顶元素
    @Override
    public E peek() {
        return (E)elements[top];
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        if (top == -1){
            return true;
        }
        return false;
    }
}
