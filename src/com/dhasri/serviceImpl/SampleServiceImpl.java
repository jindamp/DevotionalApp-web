package com.dhasri.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhasri.dao.SampleDao;
import com.dhasri.model.SampleModel;
import com.dhasri.service.SampleService;

@Component
public class SampleServiceImpl implements SampleService{

	@Autowired
	SampleDao sampleDao;
	
	
	@Override
	public void addData() {
		
		sampleDao.addData();
		
	}

	@Override
	public List<SampleModel> fetchData() {
		// TODO Auto-generated method stub
		return sampleDao.fetchData();
	}

	

}
