package com.demo.springboot.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.dao.DemoDao;
import com.demo.springboot.dao.impl.DemoDaoImpl;
import com.demo.springboot.domain.Demo;
import com.demo.springboot.service.DemoService;


@Service(DemoServiceImpl.SERVICE_NAME)
public class DemoServiceImpl implements DemoService {
	public static final String SERVICE_NAME = "demoService";
	
	@Autowired
	@Resource(name=DemoDaoImpl.DAO_NAME)
	private DemoDao demoDao;

	@Override
	public Demo getDemoById(Long id) {
		return demoDao.getDemoById(id);
	}

	@Override
	public void updateDemo(Demo demo) {
		demoDao.updateDemo(demo);
	}

	@Override
	public void removeDemo(Demo demo) {
		demoDao.removeDemo(demo);
	}
}
