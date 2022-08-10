package org.hcm.controller;

import org.hcm.model.BoardVO;
import org.hcm.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	// spring 에서는 interface명으로 , java에서는 class 명으로
	
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public void list() {
//		/*리턴이 없으면 @RequestMapping의 value 값이 들어감	 */
//	}
//	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public void list(Model model) { // Model Class
		model.addAttribute("list", bs.list());
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write() {

	}
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePOST(BoardVO bvo) {
//		System.out.println(bvo);
//		System.out.println(bvo.getTitle());
//		System.out.println(bvo.getContent());
		bs.write(bvo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public void detail(BoardVO bvo, Model model) {
		System.out.println(bvo.getBno());
		model.addAttribute("detail", bs.detail(bvo));
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String modify(BoardVO bvo, RedirectAttributes rttr) {
		bs.modify(bvo);
		rttr.addAttribute("bno",bvo.getBno());
		return "redirect:/board/detail";
	}
	
	@RequestMapping(value = "/board/remove", method = RequestMethod.POST)
	public String remove(BoardVO bvo) {
		bs.remove(bvo);
		return "redirect:/board/list";
	}
	
}
