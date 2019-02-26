package com.demo.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 这种写法等价于 SystemParams 类的注解写法
 * 使用 AppConfigure 类中的 getPgSystemSettings方法时，释放 @Configuration、@Bean/@ConfigurationProperties
 * 请注释SystemParams类的  @Component 和 @ConfigurationProperties(prefix="customing.params")
 * @author zhangjiamei
 *
 */
//@Configuration
public class AppConfigure {
//	@Bean
//	@ConfigurationProperties(prefix="customing.params") //接收application.yml中的前缀为『customing.params』后的属性
	public SystemParams getPgSystemSettings(){
		SystemParams systemParams = new SystemParams();
		return systemParams;
	}
}
