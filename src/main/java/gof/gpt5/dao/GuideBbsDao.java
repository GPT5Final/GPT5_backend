package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.GuideBbsDto;
import gof.gpt5.dto.GuideBbsParamDto;



@Mapper
@Repository
public interface GuideBbsDao {
	int addGuideBbs(GuideBbsDto dto);
	
	int addGuideFileBbs(GuideBbsDto dto);
	
	List<GuideBbsDto> GuideBbs(GuideBbsParamDto param);
	
	int getGuideCount (GuideBbsParamDto param);
	
	GuideBbsDto getGuideBbs (int seq);
	
	int deleteGuideBbs (int seq);
	
	
}
