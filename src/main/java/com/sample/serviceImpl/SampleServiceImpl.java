package com.sample.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.SampleDao;
import com.sample.model.SampleModel;
import com.sample.repository.SampleRepository;
import com.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	@Autowired
	private SampleRepository repo;
	
	@Override
	public SampleModel save(SampleModel model) {
		SampleModel modelNew=new SampleModel();
		SampleDao dao=new SampleDao();
		dao.setCategory(model.getCategory());
		dao.setProductName(model.getProductName());
	    repo.save(dao);
	    modelNew.setCategory(dao.getCategory());
	    modelNew.setProductName(dao.getProductName());
		return modelNew;
	}

	@Override
	public List<SampleModel> getAllData() {
		List<SampleDao> data=repo.findAll();
		List<SampleModel> datamodel=new ArrayList();
		datamodel.add((SampleModel) data);
		return datamodel;
	}

	@Override
	public SampleModel getById(Long id) {
		Optional<SampleDao> byId=repo.findById(id);
		SampleModel modelNew=new SampleModel();
		return modelNew;
	}

	@Override
	public SampleModel updateModel(SampleModel model) {
		SampleDao updateModel = null;
		SampleModel modelNew=new SampleModel();
		Optional<SampleDao> byIdData=repo.findById(model.getId());
		if(byIdData.isPresent()) {
			updateModel=byIdData.get();
			updateModel.setProductName(model.getProductName());
			updateModel.setCategory(model.getCategory());
			updateModel.setId(updateModel.getId());
			updateModel.setDate(LocalDateTime.now());
			repo.save(updateModel);
			modelNew.setProductName(updateModel.getProductName());
			modelNew.setCategory(updateModel.getCategory());
		}
		return modelNew;
	}

}
