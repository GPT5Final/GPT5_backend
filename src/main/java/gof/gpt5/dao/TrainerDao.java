package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.ImageDto;
import gof.gpt5.dto.TrainerDto;
import gof.gpt5.dto.TrainerLikeDto;
import gof.gpt5.dto.TrainersParam;

@Mapper
@Repository
public interface TrainerDao {

    List<TrainerDto> trainerlist(TrainersParam param);
    int getAllTrainer(TrainersParam param);
    TrainerDto getTrainer(int seq);
    TrainerDto getTopTrainer();

    int writeImageInfo(ImageDto dto);
    ImageDto getFirstImage(int trainerSeq);
    List<ImageDto> getAllImages(int trainerSeq);
    
    int writeTrainer(TrainerDto dto);
    int updateTrainer(TrainerDto dto);
    int deleteTrainer(int seq);
    
    // 좋아요
    int checkUserLikeStatus(TrainerLikeDto dto);
    int addLike(TrainerLikeDto dto);
    int deleteLike(TrainerLikeDto dto);
    int countLikesByTrainer(int ptSeq);
    int existsPtSeq(int ptSeq);

    // 좋아요 수 증가 및 감소
    int increaseLikes(int ptSeq);
    int decreaseLikes(int ptSeq);
}
