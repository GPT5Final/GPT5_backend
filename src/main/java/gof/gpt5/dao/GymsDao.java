package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.GimageDto;
import gof.gpt5.dto.GymsDto;
import gof.gpt5.dto.GymsLikeDto;
import gof.gpt5.dto.TrainersParam;

@Mapper
@Repository
public interface GymsDao {

    List<GymsDto> gymslist(TrainersParam param);
    int getAllGyms(TrainersParam param);
    GymsDto getGym(int gSeq);
    GymsDto getTopGym();

    int writeImageInfo(GimageDto dto);
    GimageDto getFirstImage(int gSeq);
    List<GimageDto> getAllImages(int gSeq);
    
    int writeGym(GymsDto dto);
    int updateGym(GymsDto dto);
    int deleteGym(int gSeq);
    
    // 좋아요
    int checkUserLikeStatus(GymsLikeDto dto);
    int addLike(GymsLikeDto dto);
    int deleteLike(GymsLikeDto dto);
    int countLikesByGyms(int gymSeq);
    int existsGymSeq(int gymSeq);

    // 좋아요 수 증가 및 감소
    int increaseLikes(int gymSeq);
    int decreaseLikes(int gymSeq);
}
