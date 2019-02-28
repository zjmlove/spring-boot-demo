package com.demo.springboot.dao;

import com.demo.springboot.domain.Demo;

public interface DemoDao {
	/**
	 * 接口定义 
	 * @param id
	 * @return
	 */
	Demo getDemoById(Long id);
	
	void updateDemo(Demo demo);
	
	void removeDemo(Demo demo);
	
}
