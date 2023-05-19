package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.CommunityDto;
import gof.gpt5.dto.CommunityParam;

@Mapper
@Repository
public interface CommunityDao {

    List<CommunityDto> Communitylist(CommunityParam param);
    int getAllCommunity(CommunityParam param);
    CommunityDto getCommunity(int seq);

    int writeCommunity(CommunityDto dto);
	int updateCommunity(CommunityDto dto);
    int deleteCommunity(int seq);

    List<CommunityDto> Bannerlist(CommunityParam param);
    int getAllBanner(CommunityParam param);
    CommunityDto getBanner(int seq);
    
    List<CommunityDto> Homelist(CommunityParam param);
    int getAllHome(CommunityParam param);
    CommunityDto getHome(int seq);
    
    List<CommunityDto> PartnerMentorlist(CommunityParam param);
    int getAllPartnerMentor(CommunityParam param);
    CommunityDto getPartnerMentor(int seq);
    
    List<CommunityDto> MentorMenteelist(CommunityParam param);
    int getAllMentorMentee(CommunityParam param);
    CommunityDto getMentorMentee(int seq);
    
    List<CommunityDto> ExerciseTalklist(CommunityParam param);
    int getAllExerciseTalk(CommunityParam param);
    CommunityDto getExerciseTalk(int seq);
    
    int increaseReadCount(int seq);
}
