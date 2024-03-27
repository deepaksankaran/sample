package com.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sample.entity.SampleDao;
import com.sample.model.SampleModel;

@Service
public interface SampleService{

	SampleModel save(SampleModel model);

	List<SampleModel> getAllData();

	SampleModel getById(Long id);

	SampleModel updateModel(SampleModel model);

}
