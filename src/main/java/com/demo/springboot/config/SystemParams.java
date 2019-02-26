package com.demo.springboot.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 这种写法等价于 AppConfigure.getPgSystemSettings方法的写法
 * 使用 SystemParams 类中的 @Component 和 @ConfigurationProperties 时，注释 @Component 、@ConfigurationProperties
 * 请注释 AppConfigure 类中的 @Configuration 、@Bean、@ConfigurationProperties(prefix="customing.params")
 * 
 * @author zhangjiamei
 *
 */
@Component
@ConfigurationProperties(prefix="customing.params") //接收application.yml中的前缀为『customing.params』后的属性
public class SystemParams {
	
    private String userName;
    
    private String bookTitle;
    
    private List<Map<String, String>> listProp1 = new ArrayList<Map<String, String>>(); //接收prop1里面的属性值
    
    private List<String> listProp2 = new ArrayList<>(); //接收prop2里面的属性值
    
    private Map<String, String> mapProps = new HashMap<String, String>(); //接收prop1里面的属性值


	public List<Map<String, String>> getListProp1() {
		return listProp1;
	}

	public void setListProp1(List<Map<String, String>> listProp1) {
		this.listProp1 = listProp1;
	}

	public List<String> getListProp2() {
		return listProp2;
	}

	public void setListProp2(List<String> listProp2) {
		this.listProp2 = listProp2;
	}

	public Map<String, String> getMapProps() {
		return mapProps;
	}

	public void setMapProps(Map<String, String> mapProps) {
		this.mapProps = mapProps;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
}
