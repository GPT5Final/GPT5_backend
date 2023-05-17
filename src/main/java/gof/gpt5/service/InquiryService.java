package gof.gpt5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.InquiryDao;
import gof.gpt5.dto.InquiryBbsDto;
import gof.gpt5.dto.InquiryParamDto;

@Service
@Transactional
public class InquiryService {

	@Autowired
	InquiryDao dao;
	
	public boolean addInquiryBbs (InquiryBbsDto dto) {
		int n = dao.addInquiryBbs(dto);
		return n > 0 ? true : false;
	}
	
	public boolean addInquiryFileBbs(InquiryBbsDto dto) {
		int n = dao.addInquiryFileBbs(dto);
		return n > 0 ? true : false;
	}
	
	public List<InquiryBbsDto> InquiryBbs(InquiryParamDto param){
		
		//System.out.println(dao.InquiryBbs(param));
		
		return dao.InquiryBbs(param);
	}
	
	public int getInquiryCount(InquiryParamDto param) {
		return dao.getInquiryCount(param);
	}
	
	public InquiryBbsDto getInquiryBbs (int seq) {
		return dao.getInquiryBbs(seq);
	}
	
	public boolean deleteInquiryBbs(int seq) {
		int n = dao.deleteInquiryBbs(seq);
		return n > 0 ? true : false;
	}
	
	
	
}
