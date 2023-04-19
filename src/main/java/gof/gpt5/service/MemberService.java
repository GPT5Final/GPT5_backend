package gof.gpt5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.MemberDao;
import gof.gpt5.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	@Autowired
	MemberDao dao;
	
	public boolean emailcheck(String email) {
		int n = dao.emailcheck(email);
		return n>0?true:false;
	}
	
	public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);
		return n>0?true:false;
	}
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
		
	}
}
