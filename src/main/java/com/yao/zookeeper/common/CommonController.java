package com.yao.zookeeper.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaojian on 2021/10/18 11:51
 *
 * @author
 */

@RestController
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("======================hello============================");
        return "hello everyone,welcome to hello page!";
    }


}
