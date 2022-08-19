package org.hcm.controller;

import org.hcm.model.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	@RequestMapping(value = "/sample/getText",produces="text/plain; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getText() {
		return new ResponseEntity<String>("hiㅋㅋ",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sample/getSample", method = RequestMethod.GET)
	public ResponseEntity<SampleVO> getSample() {
		SampleVO sample = new SampleVO();
		sample.setNo(1);
		sample.setName("hi");
		sample.setGender("M");
		
		ResponseEntity<SampleVO> result = null;
		result = ResponseEntity.status(HttpStatus.OK).body(sample);
		
		return result;
	}
	
	// rest client 확장 프로그램으로 확인
	@RequestMapping(value = "/sample/getSample1", method = RequestMethod.POST)
	public ResponseEntity<SampleVO> getSample1(@RequestBody SampleVO sample){
		
		ResponseEntity<SampleVO> result = null;
		result = ResponseEntity.status(HttpStatus.OK).body(sample);
			
		return result; 
	}
	
	
}
