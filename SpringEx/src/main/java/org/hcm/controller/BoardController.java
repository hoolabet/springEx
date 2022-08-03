package org.hcm.controller;

import org.hcm.model.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public void list() {
//		/*리턴이 없으면 @RequestMapping의 value 값이 들어감	 */
//	}
//	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public void list() {

	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write() {

	}
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public void writePOST(BoardVO bvo) {
		System.out.println(bvo);
		System.out.println(bvo.getTitle());
	}
}
