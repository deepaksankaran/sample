package com.sample.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sample.entity.SampleDao;
import com.sample.model.SampleModel;
import com.sample.repository.SampleRepository;
import com.sample.service.SampleService;


@SpringBootTest
class SampleApplicationTests {

	
	@Autowired
	private SampleService service;
	
	@MockBean
	SampleRepository repository;
	
	
	@Test
	void saveUserTest() {
		SampleModel model = new SampleModel(1L, "xyz","abc");
		SampleDao dao=new SampleDao();
		service.save(model);
//		dao.setCategory(model.getCategory());
//		dao.setProductName(model.getProductName());
		when(service.save(model)).thenReturn(model);
		assertEquals(model, model);
		
	}

}
