package gof.gpt5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.MemberDao;
import gof.gpt5.dto.EmailChkDto;
import gof.gpt5.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	@Autowired
	MemberDao dao;

	public boolean emailcheck(String email) { 
		int n = dao.emailcheck(email);
		return n > 0 ? true : false;
	}

	public boolean insertEmailKey(EmailChkDto dto) {
		int n = dao.insertEmailKey(dto);
		return n > 0 ? true : false;
	}
	
	public boolean updateEmailKey(EmailChkDto dto) {
		int n = dao.updateEmailKey(dto);
		return n > 0 ? true : false;
	}
	
	public EmailChkDto emailKeyChk(EmailChkDto dto) {
		return dao.emailKeyChk(dto);
	}
	
	public int updateMailAuth(EmailChkDto dto) {
		return dao.updateMailAuth(dto);
	}
	
	public boolean emailChk(String email) { //이메일 인증 확인 
		int n = dao.emailChk(email);
		return n > 0 ? true : false;
	}
	
	public boolean emailAuthChk(EmailChkDto dto) {
		int n = dao.emailAuthChk(dto);
		return n == 1 ? true : false;
	}

	public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);
		return n > 0 ? true : false;
	}

	public MemberDto login(MemberDto dto) {
		return dao.login(dto);

	}
}
