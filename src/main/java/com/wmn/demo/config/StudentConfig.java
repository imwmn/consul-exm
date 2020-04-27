package com.wmn.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: wmn
 * @Date: 2020/4/3 11:23
 */
@ConfigurationProperties(prefix = "student")
@Data
public class StudentConfig {

    private  String name;
    private int age;
    private String sex;


}
