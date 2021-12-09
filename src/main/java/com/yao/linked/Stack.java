package com.yao.linked;

import java.util.EmptyStackException;

/**
 * Created by yaojian on 2021/9/26 15:27
 *
 * @author
 */
public interface Stack<E> {

    //入栈
    public E push(E item);

    //出栈
    public E pop();

    //取栈顶元素
    public E peek();

    public int size();

    public boolean isEmpty();

}
