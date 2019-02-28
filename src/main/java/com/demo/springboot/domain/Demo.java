package com.demo.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体类 与 数据库表一一对应
 * 
 * 所有的实体通过 Lombok 的注解形式书写。
 * 由于 Lombok 采取的注解形式的，在编译后，自动生成相应的方法，为了不让 ide 疯了，需要下载插件了支持它。
 * 
 * @author zhangjiamei
 *
 */
//@Getter // getter 方法
//@Setter // setter 方法
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor	// 会生成一个包含所有变量，同时如果变量使用了NotNull annotation ， 会进行是否为空的校验， 全部参数的构造函数的自动生成，该注解的作用域也是只有在实体类上，参数的顺序与属性定义的顺序一致。  
//@NoArgsConstructor   // 无参构造函数
//@RequiredArgsConstructor 	//会生成一个包含常量（final），和标识了@NotNull的变量 的构造方法。
public class Demo {
	private Long id;

    private String name;

    private String info;

    
    
    public Demo() {
		super();
	}
    public Demo(Long id) {
		super();
		this.id = id;
	}
	public Demo(Long id, String name, String info) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}
