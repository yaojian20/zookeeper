package com.yao.tree;

/**
 * Created by yaojian on 2021/10/12 16:09
 *
 * @author
 */
//赫夫曼树,他也是一种热茶树,所以可以继承二叉树的节点
//带权路径长度最小的二叉树称为赫夫曼树
public class HuffmanTreeNode<E> extends BinTreeNode<E> {

    //权重
    private int weight;

    //编码
    private String coding = "";

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    @Override
    public HuffmanTreeNode<E> getLeftChildren(){
        return (HuffmanTreeNode<E>)super.getLeftChildren();
    }

    @Override
    public HuffmanTreeNode<E> getRightChildren(){
        return (HuffmanTreeNode<E>)super.getRightChildren();
    }
}
