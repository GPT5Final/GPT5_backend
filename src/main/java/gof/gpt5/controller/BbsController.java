package gof.gpt5.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gof.gpt5.dto.BbsComment;
import gof.gpt5.dto.BbsDto;
import gof.gpt5.dto.BbsParam;
import gof.gpt5.service.BbsService;

@RestController
public class BbsController {
	@Autowired
	BbsService service;
	
	@GetMapping(value = "bbslist")
	public Map<String, Object> bbslist(BbsParam param){
		System.out.println("BbsController bbslist " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);				
		
		List<BbsDto> list = service.bbslist(param);
		int len = service.getAllBbs(param);
		
//		int pageBbs = len / 10;		// 25 / 10 -> 2
//		if((len % 10) > 0) {
//			pageBbs = pageBbs + 1;
//		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
//		map.put("pageBbs", pageBbs);
		map.put("cnt", len);
		
		return map;
		
	}
	
	
	@GetMapping(value = "getBbs")
	public BbsDto getBbs(int seq) {
		System.out.println("BbsController getBbs " + new Date());
		return service.getBbs(seq);
	}
	
	
	@PostMapping(value = "/bbswrite")
	public String bbswrite(BbsDto dto) {
		System.out.println("BbsController bbswrite " + new Date());
		
		boolean b = service.writeBbs(dto);
		if(!b) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value = "/bbsupdate")
	public String bbsupdate(BbsDto dto) {
		System.out.println("BbsController bbsupdate " + new Date());
		
		boolean isS = service.updateBbs(dto);
		if (!isS) {
			return "NO";
		}
		return "YES";
	}
	
	
	@PostMapping(value = "bbsdelete")
	public String bbsdelete(int seq) {
		System.out.println("BbsController bbsdelete " + new Date());
		
		boolean b = service.deleteBbs(seq);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value = "/answerBbs")
	public String answerBbs(BbsDto dto) {
		System.out.println("BbsController answerBbs " + new Date());
		boolean b = service.answerBbs(dto);
		if (!b) {
			return "NO";
		}
		return "YES";
	}


	@PostMapping(value = "commentWrite")
	public String commentWriteAf(BbsComment bbs) {
		System.out.println("BbsController commentWrite " + new Date());
		boolean b = service.commentWrite(bbs);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	@GetMapping(value = "commentList")
	public List<BbsComment> commentList(int seq){
		return service.commentList(seq);
	}
}


