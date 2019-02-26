package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.config.SystemParams;

/**
 * @RestController 注解优点：  
 * 	1.默认类中的方法都会以json的格式返回
 * 	2.不需要增加pom对jackson等包的依赖
 * 	3.无需扫描包
 * 	4.对接方法无需使用@responsebody
 * 
 * @author zhangjiamei
 *
 */
@RestController
public class HelloWorldController {
	@Autowired
	private SystemParams systemParams;
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    
    
    @RequestMapping("/params")
    public SystemParams params() {
        return systemParams;
    }
}