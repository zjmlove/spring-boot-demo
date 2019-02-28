package com.demo.springboot.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.springboot.dao.DemoDao;
import com.demo.springboot.domain.Demo;


@Repository(DemoDaoImpl.DAO_NAME)
public class DemoDaoImpl implements DemoDao {
	public static final String DAO_NAME = "demoDao";
	
	@Override
	public Demo getDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDemo(Demo demo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDemo(Demo demo) {
		// TODO Auto-generated method stub
		
	}

}
