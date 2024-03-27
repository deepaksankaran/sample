package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.SampleModel;
import com.sample.service.SampleService;

@RequestMapping("/sample")
@RestController
public class SampleController {

	@Autowired
	private SampleService service;
	
	@PostMapping("/save")
	public SampleModel saveSample(@RequestBody SampleModel model) {
		SampleModel models=	service.save(model);
		return models;
	}
	
	@GetMapping("/getAll")
	public List<SampleModel> getSampleAll() {
		List<SampleModel> data=service.getAllData();
		return data;
	}
	
	@GetMapping("/get/{id}")
	public SampleModel getSample(@PathVariable Long id) {
		SampleModel dataById=service.getById(id);
		return dataById;
	}
	
	@PutMapping("/update/{id}")
	public SampleModel putSample(@RequestBody SampleModel model) {
		SampleModel updated=service.updateModel(model);
		return updated;
	}
	
	@DeleteMapping("/delete")
	public SampleModel deleteSample(@PathVariable String id, @RequestBody SampleModel model) {
		return model;
	}
	
}
