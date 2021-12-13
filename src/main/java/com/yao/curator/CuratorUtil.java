package com.yao.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created by yaojian on 2021/12/13 9:20
 *
 * @author
 */
public class CuratorUtil {

    private final static String CONNECT_URL = "127.0.0.1:2181";

    public static CuratorFramework getInstance(){
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString(CONNECT_URL).connectionTimeoutMs(10000).sessionTimeoutMs(50000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        curatorFramework.start();
        System.out.println("connected zookeeper successful!");
        return  curatorFramework;
    }




}
