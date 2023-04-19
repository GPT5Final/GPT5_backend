package gof.gpt5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.BbsDao;
import gof.gpt5.dto.BbsComment;
import gof.gpt5.dto.BbsDto;
import gof.gpt5.dto.BbsParam;

@Service
@Transactional
public class BbsService {
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> bbslist(BbsParam param) {
		return dao.bbslist(param);
	}
	
	public int getAllBbs(BbsParam param) {
		return dao.getAllBbs(param);
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0?true:false;
	}
	
	public boolean updateBbs(BbsDto dto) {
		int n = dao.updateBbs(dto); 
		return n>0?true:false;
	}
	
//	public BbsDto deleteBbs(int seq) {
//		return dao.deleteBbs(seq);
//	}
	
	public boolean deleteBbs(int seq) {
		int n = dao.deleteBbs(seq);
		return n>0?true:false;
	}
	
	public boolean answerBbs(BbsDto bbs) {
		dao.answerBbsUpdate(bbs);
		int n = dao.answerBbsInsert(bbs);
		return n>0?true:false;
	}
	
	public boolean commentWrite(BbsComment bbs) {
		int n = dao.commentWrite(bbs);
		return n>0?true:false;
	}
	
	public List<BbsComment> commentList(int seq) {
		return dao.commentList(seq);
	}
	
}





