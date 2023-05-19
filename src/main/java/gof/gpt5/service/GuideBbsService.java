package gof.gpt5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.GuideBbsDao;
import gof.gpt5.dto.GuideBbsDto;
import gof.gpt5.dto.GuideBbsParamDto;

@Service
@Transactional
public class GuideBbsService {

	@Autowired
	GuideBbsDao dao;
	
	public boolean addGuideBbs (GuideBbsDto dto) {
		int n = dao.addGuideBbs(dto);
		return n > 0 ? true : false;
	}
	
	public boolean addGuideFileBbs(GuideBbsDto dto) {
		int n = dao.addGuideFileBbs(dto);
		return n > 0 ? true : false;
	}
	
	public List<GuideBbsDto> GuideBbs(GuideBbsParamDto param){
		
		//System.out.println(dao.GuideBbs(param));
		
		return dao.GuideBbs(param);
	}
	
	public int getGuideCount(GuideBbsParamDto param) {
		return dao.getGuideCount(param);
	}
	
	public GuideBbsDto getGuideBbs (int seq) {
		return dao.getGuideBbs(seq);
	}
	
	public boolean deleteGuideBbs(int seq) {
		int n = dao.deleteGuideBbs(seq);
		return n > 0 ? true : false;
	}
	
	
	
}
