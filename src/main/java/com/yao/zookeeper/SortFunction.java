package com.yao.zookeeper;

import org.springframework.util.CollectionUtils;

/**
 * Created by yaojian on 2021/10/21 15:35
 *
 * @author
 */
public class SortFunction {

    public static void main(String[] args) {
        int[] array = {23,1,4,5,6,256,78,13,15,90,66,43,67,120,30};
        insertSort(array);
    }


    /**
     * 冒泡排序
     * 原理,将数组里相邻的两个数进行比较,大的数往后移,然后最大的数处于数组最后面,以此类推
     */
    public static void bubbleSort(int[] array){
        if (array.length < 2){
            return;
        }
        int length = array.length;
        //开始进行多轮循环
        for (int i = 0;i<length;i++){
            System.out.println(CollectionUtils.arrayToList(array).toString());
            //第一轮要比较所有的数,最大的数会移到最后面
            //第二轮最后一个数不需要比较,因为他已经是最大数了,所以以此类推只要比较length-i个数
            for (int j=0;j<length-i-1;j++){
                if (array[j] > array[j+1]){
                    int data = array[j];
                    array[j] = array[j+1];
                    array[j+1] = data;
                }
            }
        }
        System.out.println(CollectionUtils.arrayToList(array).toString());
    }

    /**
     * 选择排序
     * 原理:跟冒泡排序类似,但是只要最小数或者最大数的下标,等到比较完之后再做一次交换
     */
    public static void selectSort(int[] array){
        if (array.length < 2){
            return;
        }
        int length = array.length;
        //开始进行多轮循环
        for (int i = 0;i<length;i++){
            System.out.println(CollectionUtils.arrayToList(array).toString());
            int max = 0;
            for (int j=1;j<length-i;j++){
                if (array[j] > array[max]){
                    max = j;
                }
            }
            if (max != length-i-1){
                int data = array[length-i-1];
                array[length-i-1] = array[max];
                array[max] = data;
            }
        }
        System.out.println(CollectionUtils.arrayToList(array).toString());
    }

    /**
     * 插入排序
     * 原理:将前面的数组看成有序数组,那么后面的数只需要根据他的大小在该有序数组中找到他对应的位置就行了
     */
    public static void insertSort(int[] array){
        if (array.length < 2){
            return;
        }
        int length = array.length;
        //头一个数只有一个数字肯定是有序数组,不需要操作,所以从下标为1的位置开始
        for (int i = 1;i < length; i++){
            System.out.println(CollectionUtils.arrayToList(array).toString());
            for (int j = i;j > 0;j--){
                //有序数组的长度为i,所以最大下标为i-1,所以最新要插入的数下标为i
                if (array[j] < array[j-1]){
                    //如果要插入的数小于该数,那么要插入的数需要在有序数组的位置里前移
                    int data = array[j];
                    array[j] = array[j-1];
                    array[j-1] = data;
                } else {
                    //如果要插入的数大于有序序列的最后一位数,那么就不需要移动,直接放在有序数组的末尾即可
                    break;
                }
            }
        }
        System.out.println(CollectionUtils.arrayToList(array).toString());
    }


}
