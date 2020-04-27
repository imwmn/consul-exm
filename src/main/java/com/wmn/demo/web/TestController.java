package com.wmn.demo.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wmn.demo.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wmn
 * @Date: 2020/4/3 11:29
 */
@RestController

public class TestController {

    @Value("${myName}")
    private String myName;

    @Autowired
    private StudentConfig studentConfig;

    @Autowired
    Environment environment;

    public String getPort(){
        return environment.getProperty("local.server.port");
    }


//    @RequestMapping("/myname")
//    public String testHello(){
//        System.out.println("my name is : "+myName);
//        return myName;
//    }
    @RequestMapping("/config")
    public String testConfig(){
        System.out.println(studentConfig.toString());
        System.out.println(myName);
        return studentConfig.toString();
    }

//    //获取当前端口
//    @LocalServerPort
    private String port ;

    @GetMapping("/hello")
    public String hello() {
//        String say = sayHello.say();
//        return  say;
        return "hello consul from "+getPort();
    }

    @GetMapping("/home")
    @HystrixCommand(fallbackMethod = "hystrixHello")
    public String call(){
        //throw   new RuntimeException("111");
        return "测试";
    }

    public  String hystrixHello(){
        return "当前服务故障，服务熔断已启动！";
    }

}
