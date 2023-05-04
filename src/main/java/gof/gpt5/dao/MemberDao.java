package gof.gpt5.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.EmailChkDto;
import gof.gpt5.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {

	// 이메일 인증
	int insertEmailKey(EmailChkDto dto);
	
	// 이메일 중복확인
	int emailChk(String email);
	
	// 이메일 재전송
	int updateEmailKey(EmailChkDto dto);
	
	// 인증코드 일치 확인
	EmailChkDto emailKeyChk(EmailChkDto dto);
	
	// 인증완료하면 auth 1로 변경
	int updateMailAuth(EmailChkDto dto);
	
	// 이메일 인증완료여부 확인
	int emailAuthChk(EmailChkDto dto);

	int emailcheck(String email);
	int addmember(MemberDto dto);
	MemberDto login(MemberDto dto);
	MemberDto getMember(MemberDto dto);
	
	int chargeCoin(MemberDto dto);

}
