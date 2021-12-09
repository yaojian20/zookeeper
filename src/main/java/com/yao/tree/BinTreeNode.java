package com.yao.tree;

import com.yao.linked.Node;

import java.util.function.BinaryOperator;

/**
 * Created by yaojian on 2021/9/29 16:14
 *Description:二叉树节点类
 * @author
 */

public class BinTreeNode<E> implements Node<E> {

    //数据域
    private E data;

    //左子节点
    private BinTreeNode<E> leftChildren;

    //右子节点
    private BinTreeNode<E> rightChildren;

    //父节点
    private BinTreeNode<E> parent;

    //子树的高度
    private int height;

    //该节点及子孙节点数量
    private int size;

    public BinTreeNode(E data) {
        //初始化数据
        this.data = data;
        this.height = 0;
        this.size = 1;
        this.leftChildren = null;
        this.rightChildren = null;
        this.parent = null;
    }

    public BinTreeNode() {
        this(null);
    }

    @Override
    public E getData() {
        return this.data;
    }

    @Override
    public void setData(E e) {
        this.data = e;
    }

    /***********************判断节点信息*****************************/
    //判断是否有左孩子节点
    public boolean haveLeftChild(){
        return this.leftChildren != null;
    }

    //判断是否有右孩子节点
    public boolean haveRightChild(){
        return this.rightChildren != null;
    }

    //判断是否有父亲节点
    public boolean haveParent(){
        return this.parent != null;
    }

    //判断是否是某节点的左节点
    public boolean isLeftChild(){
        if (!haveParent()){
            return false;
        }
        return this == this.parent.leftChildren;
    }

    //判断是否是某节点的右节点
    public boolean isRightChild(){
        if (!haveParent()){
            return false;
        }
        return this == this.parent.rightChildren;
    }

    //判断是否为叶子结点
    public boolean isLeaf(){
        //左右子节点都没有则为叶节点
        return !haveLeftChild()&&!haveRightChild();
    }

    /***********************判断节点信息*****************************/


    /***********************节点子节点高度信息*****************************/
    private int getHeight(){
        return this.height;
    }

    //更新该节点高度及祖节点的高度
    private void  updateHeight(){
        int newHeight = 0;
        //取最大高度
        if (haveLeftChild()){
            //子节点,所有高度+1
            newHeight = Math.max(newHeight,this.leftChildren.height+1);
        }
        if (haveRightChild()){
            //子节点,所有高度+1
            newHeight = Math.max(newHeight,this.rightChildren.height+1);
        }
        if (newHeight == this.height){
            //如果高度没有变化,则无需继续更新
            return;
        }
        //更新节点高度
        this.height = newHeight;
        if (haveParent()){
            //递归更新祖节点高度
            this.parent.updateHeight();
        }
    }

    /***********************节点高度信息*****************************/


    /***********************节点节点数信息*****************************/
    public int getSize(){
        return this.size;
    }

    //更新当前节点和祖节点的节点数量
    public void updateSize(){
        //初始化
        int newSize = 1;
        if (haveLeftChild()){
            newSize += this.leftChildren.getSize();
        }
        if (haveRightChild()){
            newSize += this.rightChildren.getSize();
        }
        //更新节点数
        this.size = newSize;
        if (haveParent()){
            //递归更新祖节点数
            this.parent.updateSize();
        }
    }
    /***********************节点节点数信息*****************************/


    /***********************父节点信息*****************************/
    //获得父节点
    public BinTreeNode<E> getParentNode(){
        return this.parent;
    }

    //断开与父节点的关系
    public void server(){
        //如果没有父节点直接结束
        if (!haveParent()){
            return;
        }
        if (isLeftChild()){
            //如果是左孩子,那么左孩子断开,否则断开右孩子
            this.parent.leftChildren = null;
        } else {
            this.rightChildren = null;
        }
        this.parent.updateHeight();
        this.parent.updateSize();
        this.parent = null;
    }

    /***********************父节点信息*****************************/

    /***********************左孩子节点信息*****************************/

    public BinTreeNode<E> getLeftChildren(){
        return this.leftChildren;
    }

    //设置左节点并返回原左节点
    public BinTreeNode<E> setLeftChild(BinTreeNode<E> binTreeNode){
        //拿到现有的左孩子节点
        BinTreeNode<E> oldLeft = this.leftChildren;
        if (haveLeftChild()){
            //断开左孩子的连接
            this.leftChildren.server();
        }
        if (binTreeNode != null){
            binTreeNode.server();
            this.leftChildren = binTreeNode;
            binTreeNode.parent = this;
            updateHeight();
            updateSize();
        }

        return oldLeft;
    }

    /***********************左孩子节点信息*****************************/

    /***********************右孩子节点信息*****************************/
    public BinTreeNode<E> getRightChildren(){
        return this.rightChildren;
    }


    //设置右节点并返回原右节点
    public BinTreeNode<E> setRightChildren(BinTreeNode<E> binTreeNode){
        BinTreeNode<E> oldRight = this.rightChildren;
        if (haveLeftChild()){
            //断开左孩子的连接
            this.rightChildren.server();
        }
        if (binTreeNode != null){
            binTreeNode.server();
            this.rightChildren = binTreeNode;
            binTreeNode.parent = this;
            updateHeight();
            updateSize();
        }
        return oldRight;
    }


    /***********************右孩子节点信息*****************************/


    /***********************遍历*****************************/
    //前序遍历(前序遍历如果根节点为空,返回不操作,否则的话从根节点开始前序遍历左树,然后再前序遍历右树)
    //可以用递归,先输出做节点,再输出有节点
    //对于任意一个子树都有根节点->左节点->右节点(如果没有左节点,则是根节点->右节点)
    private void preOrderTraverse(BinTreeNode<E> binTreeNode){
        if (binTreeNode == null || binTreeNode.getData() == null){
            return;
        }
        //根节点第一个输出
        System.out.println(binTreeNode.getData().toString());
        //如果有左节点就会顺着左节点一直往里面遍历,遍历完了才会从下面的右节点返回
        //左节点第二个输出
        preOrderTraverse(binTreeNode.leftChildren);
        //右节点最后输出
        preOrderTraverse(binTreeNode.rightChildren);
    }

    //中序遍历(前序遍历如果根节点为空,返回不操作,否则的话开始中序遍历左树,然后遍历根节点,最后再中序遍历右树)(从最下边的左节点开始)
    //对于任意一个子树都有左节点->根节点->右节点(如果没有左节点,则是根节点->右节点)
    private void inOrderTraverse(BinTreeNode<E> binTreeNode){
        if (binTreeNode == null || binTreeNode.getData() == null){
            return;
        }
        //如果有左节点就会顺着左节点一直往里面遍历,遍历完了才会从下面的右节点返回
        //左节点第一个输出
        inOrderTraverse(binTreeNode.leftChildren);
        //这样就会一直遍历到最后一个左节点开始第一个输出,然后输出根节点,再输出右节点
        //根节点第二个输出
        System.out.println(binTreeNode.getData().toString());
        //右节点最后输出
        inOrderTraverse(binTreeNode.rightChildren);
    }

    //序遍历(前序遍历如果根节点为空,返回不操作,否则的话先左节点再右节点再根节点(从最下边的左节点开始)
    //对于任意一个子树都有左节点->右节点->根节点(如果没有左节点,则是根节点->右节点)
    private void beforeOrderTraverse(BinTreeNode<E> binTreeNode){
        if (binTreeNode == null || binTreeNode.getData() == null){
            return;
        }
        //如果有左节点就会顺着左节点一直往里面遍历,遍历完了才会从下面的右节点返回
        //左节点第一个输出
        beforeOrderTraverse(binTreeNode.leftChildren);
        //右节点第二个输出
        beforeOrderTraverse(binTreeNode.rightChildren);
        //这样就会一直遍历到最后一个左节点开始第一个输出,然后
        //根节点最后输出
        System.out.println(binTreeNode.getData().toString());
    }

    /***********************遍历*****************************/





}
