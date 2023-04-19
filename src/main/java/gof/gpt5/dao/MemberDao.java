package gof.gpt5.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	int emailcheck(String email);
	int addmember(MemberDto dto);
	MemberDto login(MemberDto dto);

}
