package com.yao.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaojian on 2021/10/12 16:19
 *
 * @author
 */
//赫夫曼树
public class HuffmanTree<E> {

    //根节点
    private HuffmanTreeNode<E> rootNode;

    public HuffmanTreeNode<E> getRootNode() {
        return rootNode;
    }

    public void setRootNode(HuffmanTreeNode<E> rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * 思路:赫夫曼树是将所有节点按权重从小到大排序,然后取头两个节点作为一个新节点的左右节点,较小的在左节点,大的为右节点,新节点的权重为这两个节点之和,
     * 然后再讲这个新节点按权重顺序插入之前的顺序集合(此时头两个节点已经被删除,因为头两个节点组成了新的节点,新的节点代替他们插入)
     * 这里为了方便集合或者数组操作,将节点权重从大到小排序,这样从集合的末尾开始遍历更方便(因为集合的长度在一直变小)
     * @param nodes
     * @return
     */
    public HuffmanTree<E> generateHuffmanTree(HuffmanTreeNode<E>[] nodes){
        if (nodes == null || nodes.length == 0){
            return null;
        }
        HuffmanTree<E> huffmanTree = new HuffmanTree<>();
        if (nodes.length == 1){
            huffmanTree.setRootNode(nodes[0]);
        }
        //首先将传进来的数组从大到小的方式排序
        List<HuffmanTreeNode<E>> nodeList = new ArrayList<>();
        for (int i = 0;i < nodes.length ; i++)
            insertDesc(nodeList,nodes[i]);

        //排序之后进行赫夫曼树的组装
        for (int i = nodeList.size();i >=1;i--){
            //倒序输出防止下标越界
            //取末尾两个节点组成一个新节点
            //先取左节点
            HuffmanTreeNode<E> leftNode = nodeList.remove(nodeList.size()-1);
            //再取右节点,此时集合里左节点已被删除,所以取最后一个节点即可
            HuffmanTreeNode<E> rightNode = nodeList.remove(nodeList.size()-1);
            //组装新的节点
            HuffmanTreeNode<E> newNode = new HuffmanTreeNode<>();
            newNode.setWeight(leftNode.getWeight()+rightNode.getWeight());
            newNode.setLeftChild(leftNode);
            newNode.setRightChildren(rightNode);
            //将新的节点按顺序插入之前的集合
            insertDesc(nodeList,newNode);
            //重复之前的操作,知道集合中只剩下一个节点
        }
        //剩下的最后一个节点则为根节点
        huffmanTree.setRootNode(nodeList.get(0));
        return huffmanTree;
    }

    /**
     *
     * @param rootNode 传入根节点
     */
    public void generateCoding(HuffmanTreeNode<E> rootNode){
        if (rootNode == null){
            return;
        }
        //根节点没有编码
        //向左为0,向右为1
        if (rootNode.haveParent()){
            if (rootNode.isLeftChild()){
                rootNode.setCoding("0");
            } else {
                rootNode.setCoding("1");
            }
        }
        //递归设置所有子节点的编码
        generateCoding(rootNode.getLeftChildren());
        generateCoding(rootNode.getRightChildren());
    }


    //按从大到小的顺序插入
    public void insertDesc(List<HuffmanTreeNode<E>> nodes,HuffmanTreeNode<E> newNode){
        if (nodes == null || nodes.size() == 0){
            nodes = new ArrayList<>();
            nodes.add(newNode);
            return;
        }
        for (int i=0;i<nodes.size();i++){
            if (newNode.getWeight() > nodes.get(i).getWeight()){
                //如果发现到比他小的权重,就在此处插入此节点
                nodes.add(i,newNode);
                return;
            }
        }
        //没有找到比他小的就插入到集合末尾
        nodes.add(nodes.size(),newNode);
    }

}
