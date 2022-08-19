package org.hcm.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hcm.model.ReplyVO;
import org.hcm.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	@Autowired
	ReplyService rs;
	
	@RequestMapping(value = "/replies/new",method = RequestMethod.POST)
	public ResponseEntity<String> replyWrite(@RequestBody ReplyVO rvo) {
		int result = rs.replyWrite(rvo);
		
		return result == 1 ? new ResponseEntity<>("success",HttpStatus.OK)
						   : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/replies/{bno}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ReplyVO>> replyView(@PathVariable int bno) {
		
		return  new ResponseEntity<>(rs.replyView(bno),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/replies/delete", method = RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@RequestBody int rno) {
		int result = rs.replyDelete(rno);
		
		return result == 1 ? new ResponseEntity<>("success",HttpStatus.OK)
				   : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
