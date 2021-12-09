package com.yao.linked;

/**
 * Created by yaojian on 2021/9/26 11:29
 *
 * @author
 */
public class Strategy {

    public static boolean equal(Object o1,Object o2){
        if (o1 == null || o2 == null){
            return  false;
        }
        return o1.equals(o2);
    }


}
