package com.demo.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot 建议：
 *  1、Application.java 建议放到跟目录下面,主要用于做一些框架配置
	2、domain目录主要用于实体（Entity）与数据访问层（Repository）
	3、service 层主要是业务类代码定义及实现
	4、controller 负责页面访问控制
 * @author zhangjiamei
 *
 */
@SpringBootApplication
@EnableAutoConfiguration //启用自动配置
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class) //启用自动配置，排除数据库自动配置，适用于数据库配置自己写的方式。
@ComponentScan(basePackages={"com.demo.springboot.config",
							"com.demo.springboot.controller",
							"com.demo.springboot.service"}) //扫描包下的所有组件，包括启动类、servlet等
@MapperScan("com.demo.springboot.mapper") //或者直接在Mapper类上面添加注解@Mapper,建议使用上面前者，不然每个mapper加个注解也挺麻烦的
public class Application {
	public static void main(String[] args) {
		/**
		 * 如果没有在 application.properties 或 application.yml 中配置 server port ，
		 * 则默认 web 访问端口为：8080。
		 */
		SpringApplication.run(Application.class, args);
		
	}
}
