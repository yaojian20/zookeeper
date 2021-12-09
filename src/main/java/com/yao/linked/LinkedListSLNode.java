package com.yao.linked;

import javafx.scene.control.Slider;

import java.util.*;

/**
 * Created by yaojian on 2021/9/26 11:18
 *单向链表
 * @author
 */
public class LinkedListSLNode<E> implements List<E> {

    //首节点
    private SLNode head;

    //链表长度
    private int size;

    public LinkedListSLNode() {
        this.head = new SLNode();
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null || this.size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        SLNode slNode = this.head;
        if (slNode == null || o == null){
            return false;
        }
        for (int i=0;i<size;i++){
            boolean contain = Strategy.equal(slNode.getData(),o);
            if (contain){
                return true;
            }
            slNode = slNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == 0){
            head = new SLNode(e);
            head.setData(e);
            this.size++;
            return true;
        }
        SLNode<E> slNode = this.head;
        for (int i = 0;i < size;i++){
            if (i == size-1){
                slNode.setNext(new SLNode(e));
                this.size++;
                return true;
            }
            slNode = slNode.getNext();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (index<0 || index >= size){
            throw  new IndexOutOfBoundsException("下标越界!");
        }
        SLNode<E> slNode = this.head;
        for (int i=0;i<=index;i++){
            if (i == index){
                break;
            }
            slNode = slNode.getNext();
        }
        return slNode.getData();
    }

    @Override
    public E set(int index, E element) {
        if (index<0 || index >= size){
            throw  new IndexOutOfBoundsException("下标越界!");
        }
        //获得当前下标的节点,重置数据即可
        SLNode curNode = getCurNode(index);
        curNode.setData(element);
        return element;
    }

    @Override
    public void add(int index, E element) {
        if (index<0 || index >= size){
            throw  new IndexOutOfBoundsException("下标越界!");
        }
        SLNode slNode = new SLNode(element);
        SLNode curNode = null;
        //如果是头结点
        if (index == 0){
            curNode = this.head;
            slNode.setNext(curNode);
            //重新设置head
            this.head=slNode;
        } else {
            SLNode preNode  = getPreNode(index);
            curNode = preNode.getNext();
            slNode.setNext(curNode);
            preNode.setNext(slNode);
        }
        //长度+1
        this.size++;
    }

    private SLNode getPreNode(int index){
        if (index<0 || index > size){
            throw  new IndexOutOfBoundsException("下标越界!");
        }
        SLNode<E> slNode = this.head;
        for (int i=0;i<index;i++){
            if (i == index-1){
                //获得前一个节点
                break;
            }
            slNode = slNode.getNext();
        }
        return slNode;
    }

    private SLNode getCurNode(int index){
        if (index<0 || index > size){
            throw  new IndexOutOfBoundsException("下标越界!");
        }
        SLNode<E> slNode = this.head;
        for (int i=0;i<index+1;i++){
            if (i == index){
                //获得前一个节点
                break;
            }
            slNode = slNode.getNext();
        }
        return slNode;
    }

    @Override
    public E remove(int index) {
        if (index<0 || index >= size){
            throw  new IndexOutOfBoundsException("下标越界!");
        }
        SLNode curNode = null;
        if (index == 0 ){
            curNode = this.head;
            this.head = curNode.getNext();
            this.size--;
            return (E)curNode.getData();
        }
        //取得前一个节点,获得前一个节点重新设置他的下一个节点
        SLNode preNode = getPreNode(index);
        //获得当前节点
        curNode = preNode.getNext();
        //获得下一个节点
        SLNode nextNode = curNode.getNext();
        //重新关联节点
        //此时set改变了preNode.next的地址指向,所以不会影响到curNode的值
        preNode.setNext(nextNode);
        //长度-1
        this.size--;
        return (E)curNode.getData();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        if (size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i =0;i<size;i++){
            if (i==size-1){
                sb.append(this.get(i).toString());
            } else {
                sb.append(this.get(i).toString());
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
