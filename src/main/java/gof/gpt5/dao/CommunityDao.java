package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.CommunityDto;
import gof.gpt5.dto.CommunityParam;
import gof.gpt5.dto.TrainerDto;
import gof.gpt5.dto.TrainerLikeDto;
import gof.gpt5.dto.TrainersParam;

@Mapper
@Repository
public interface CommunityDao {

    List<CommunityDto> Communitylist(CommunityParam param);
    int getAllCommunity(CommunityParam param);
    CommunityDto getCommunity(int seq);

    int writeCommunity(CommunityDto dto);
	int updateCommunity(CommunityDto dto);
    int deleteCommunity(int seq);


}
