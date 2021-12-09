package com.yao.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaojian on 2021/9/26 11:56
 *
 * @author
 */
public class Test {


    public static void main(String[] args) {

        testLinkedStack();

    }

    public static void testLinkedStack(){
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }

    public static void testArrayStack(){
        ArrayStack<String> stack = new ArrayStack<>(12);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }

    public static void testLinekListSL(){
        LinkedListSLNode<String> list = new LinkedListSLNode<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.remove(1));
        list.set(0,"0");
        System.out.println(list.toString());
        list.add(0,"1");
        System.out.println(list.toString());
        list.add(7,"2");
        System.out.println(list.toString());
    }
}
