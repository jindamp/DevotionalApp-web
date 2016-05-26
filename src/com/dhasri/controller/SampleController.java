package com.dhasri.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhasri.model.SampleModel;
import com.dhasri.service.SampleService;

@RestController
public class SampleController {
	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping(value = "/test")
	public void addImages() {
		
		try {
			sampleService.addData();
			System.out.println("sucess");
			
		
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Fail");
		}
	}
	
	@RequestMapping(value = "/telugu", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody
	List<SampleModel> getAllImages() {

		List<SampleModel> employeeList = null;
		try {
			employeeList = sampleService.fetchData();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}
	
}
