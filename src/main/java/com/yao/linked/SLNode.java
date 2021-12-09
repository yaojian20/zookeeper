package com.yao.linked;

/**
 * Created by yaojian on 2021/9/26 11:06
 * 单链表节点
 * @author
 */
public class SLNode<E> implements Node<E>{
    //当前节点数据
    private E element;

    //下一个节点
    private SLNode next;

    public SLNode() {
    }

    public SLNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    @Override
    public E getData() {
        return this.element;
    }

    @Override
    public void setData(E object) {
        this.element = object;
    }
}
