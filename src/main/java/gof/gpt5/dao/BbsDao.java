package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.BbsComment;
import gof.gpt5.dto.BbsDto;
import gof.gpt5.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	List<BbsDto> bbslist(BbsParam param);
	int getAllBbs(BbsParam param);
	BbsDto getBbs(int seq);
	
	int writeBbs(BbsDto dto);
	int updateBbs(BbsDto dto);
//	BbsDto deleteBbs(int seq);
	int deleteBbs(int seq);
	
	//TODO 답글
	int answerBbsUpdate(BbsDto bbs);
	int answerBbsInsert(BbsDto bbs);
	
	//TODO 댓글
	int commentWrite(BbsComment bbs);
	List<BbsComment> commentList(int seq);
	
}
