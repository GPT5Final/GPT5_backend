package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.InquiryBbsDto;
import gof.gpt5.dto.InquiryParamDto;


@Mapper
@Repository
public interface InquiryDao {
	int addInquiryBbs(InquiryBbsDto dto);
	
	int addInquiryFileBbs(InquiryBbsDto dto);
	
	List<InquiryBbsDto> InquiryBbs(InquiryParamDto param);
	
	int getInquiryCount (InquiryParamDto param);
	
	InquiryBbsDto getInquiryBbs (int seq);
	
	int deleteInquiryBbs (int seq);
}
