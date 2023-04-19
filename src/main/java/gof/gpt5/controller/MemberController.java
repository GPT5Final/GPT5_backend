package gof.gpt5.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gof.gpt5.dto.MemberDto;
import gof.gpt5.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@PostMapping(value = "/emailcheck")
	public String emailcheck(String email) {
		System.out.println("MemberController emailcheck " + new Date());
		
		boolean b = service.emailcheck(email);
		if (b) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value = "/addmember")
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember " + new Date());
		
		boolean b = service.addmember(dto);
		if (!b) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value = "/login")
	public MemberDto login(MemberDto dto) {
		
		System.out.println("MemberController login " + new Date());
		
		MemberDto mem = service.login(dto);
//		if (mem != null) {
//			req.getSession().setAttribute("login", mem);
//			req.getSession().setMaxInactiveInterval(7200);
//			return mem;
//		}
		return mem;
	}
}



