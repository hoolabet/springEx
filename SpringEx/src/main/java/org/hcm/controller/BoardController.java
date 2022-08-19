package org.hcm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hcm.model.BoardVO;
import org.hcm.model.CriteriaVO;
import org.hcm.model.PageVO;
import org.hcm.model.ReplyVO;
import org.hcm.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;

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
	public void list(Model model, HttpSession session,CriteriaVO cri) { // Model Class
			model.addAttribute("list", bs.listSearch(cri));
			model.addAttribute("paging", new PageVO(cri, bs.maxNumSearch(cri)));
			session.setAttribute("isCounted", 0);
			session.setAttribute("criValue", new PageVO(cri, bs.maxNumSearch(cri)));
	}

//	@RequestMapping(value = "/board/list", method = RequestMethod.POST)
//	public void listSearch(String search, Model model, HttpSession session) {
//		System.out.println(search);
//		System.out.println("'%"+search+"%'");
//		model.addAttribute("list", bs.listSearch("'%"+search+"%'"));
//		session.setAttribute("isCounted", 0);
//	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write() {

	}
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePOST(BoardVO bvo) {
		bvo.setTitle(bvo.getTitle().replace("<", "&lt;").replace(">", "&gt;"));
		bvo.setContent(bvo.getContent().replace("<", "&lt;").replace(">", "&gt;"));
		bs.write(bvo);
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String detail(BoardVO bvo, Model model, ReplyVO rvo, HttpSession session) {
		try {
			model.addAttribute("detail", bs.detail(bvo));
			model.addAttribute("reply", bs.reply(rvo));
			if(session.getAttribute("isCounted") == null || (int)session.getAttribute("isCounted") != 1) {
				bs.count(bvo);
			}
			session.setAttribute("isCounted", 1);
			return "/board/detail";
		}catch (Exception e) {
			return "redirect:/board/list";
		}
	}

	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String modify(BoardVO bvo, RedirectAttributes rttr, HttpSession session) {
		try {
			String id = (String)session.getAttribute("id");
			if(id.equals(bs.detail(bvo).getId())) {
				session.setAttribute("Access", true);
				session.setAttribute("modi", true);
				bvo.setTitle(bvo.getTitle().replace("<", "&lt;").replace(">", "&gt;"));
				bvo.setContent(bvo.getContent().replace("<", "&lt;").replace(">", "&gt;"));
				bs.modify(bvo);
				rttr.addAttribute("bno",bvo.getBno());
				return "redirect:/board/detail";
			}else {
				session.setAttribute("Access", false);
				rttr.addAttribute("bno",bvo.getBno());
				return "redirect:/board/detail";
			}
		}catch (Exception e) {
			session.setAttribute("Access", false);
			rttr.addAttribute("bno",bvo.getBno());
			return "redirect:/board/detail";
		}
	}

	@RequestMapping(value = "/board/remove", method = RequestMethod.POST)
	public String remove(BoardVO bvo, RedirectAttributes rttr, HttpSession session) {
		try {
			String id = (String)session.getAttribute("id");
			if(id.equals(bs.detail(bvo).getId())) {
				session.setAttribute("Access", true);
				session.setAttribute("remo", true);
				bs.remove(bvo);
				return "redirect:/board/list";
			}else {
				session.setAttribute("Access", false);
				rttr.addAttribute("bno",bvo.getBno());
				return "redirect:/board/detail";
			}
		}catch (Exception e) {
			session.setAttribute("Access", false);
			rttr.addAttribute("bno",bvo.getBno());
			return "redirect:/board/detail";
		}
	}
	
	@RequestMapping(value = "/board/reply", method = RequestMethod.POST)
	public String replyPOST(ReplyVO rvo, RedirectAttributes rttr) {
		rvo.setContent(rvo.getContent().replace("<", "&lt;").replace(">", "&gt;"));
		bs.writeRe(rvo);
		rttr.addAttribute("bno",rvo.getBno());
		return "redirect:/board/detail";
	}
	
	@RequestMapping(value = "/board/replyRemove", method = RequestMethod.POST)
	public String replyRemove(ReplyVO rvo, RedirectAttributes rttr, HttpSession session) {
		try {
			String id = (String)session.getAttribute("id");
			if(id.equals(rvo.getId())) {
				bs.replyRemove(rvo);
				rttr.addAttribute("bno",rvo.getBno());
				return "redirect:/board/detail";
			}else {
				rttr.addAttribute("bno",rvo.getBno());
				return "redirect:/board/detail";
			}
		}catch (Exception e) {
			rttr.addAttribute("bno",rvo.getBno());
			return "redirect:/board/detail";
		}
	}
	
}
