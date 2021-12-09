package com.yao.zookeeper.config;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yaojian on 2021/9/16 11:18
 *
 * @author
 */
//@Configuration
public class ZookeeperConfig {

    private final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);

    //zk地址和端口号
    @Value("${zookeeper.address}")
    private String address;

    //超时时间
    @Value("${zookeeper.timeout}")
    private int timeout;


    @Bean
    public ZkClient zkClient(){
        ZkClient zkClient = new ZkClient(address,timeout);
        return  zkClient;
    }




}
