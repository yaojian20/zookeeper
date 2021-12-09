package com.yao.linked;

/**
 * Created by yaojian on 2021/9/26 15:54
 *
 * @author
 */
public class LinkedStack<E> implements Stack<E> {

    //栈空间的长度
    private int size;

    //栈空间的栈顶节点
    private SLNode<E> top;

    public LinkedStack() {
        this.size = 0;
        top = new SLNode<>();
    }

    //入栈
    @Override
    public E push(E item) {
        if (this.size == 0){
            this.top = new SLNode<>(item);
        } else {
            //栈只能在表尾进行插入删除操作(表尾即是栈顶,表头是栈底,此表头表尾是针对栈这个线性表)
            //将进栈的数据插到单向链表的表头(把链表的表头作为栈顶),每次操作直接取到表头,时间复杂度是O[1]
            //PS:将链表的表尾做栈顶的话,那么每次操作的话都要从表头遍历到表尾取到表尾,那么它的时间复杂度就是O[n],所以最好是将单向链表的表头作为栈顶
            SLNode slNode = new SLNode(item);
            slNode.setNext(this.top);
            this.top = slNode;
        }
        //长度+1
        this.size++;
        return item;
    }

    //出栈
    @Override
    public E pop() {
        if (this.size > 0){
            //拿到栈顶元素
            E element = this.top.getData();
            //栈顶向下移动
            this.top = this.top.getNext();
            this.size--;
            return element;
        }
        return null;
    }

    //获得栈顶元素
    @Override
    public E peek() {
        if (this.size > 0){
            //拿到栈顶元素
            E element = this.top.getData();
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        }
        return false;
    }
}
