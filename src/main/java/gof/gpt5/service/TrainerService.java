package gof.gpt5.service;

import gof.gpt5.dto.TrainerDto;
import gof.gpt5.dto.TrainerLikeDto;
import gof.gpt5.dto.TrainersParam;
import gof.gpt5.dao.TrainerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerDao trainerDao;

    public List<TrainerDto> trainerlist(TrainersParam param, String nickname) {
        List<TrainerDto> trainers = trainerDao.trainerlist(param);
        for (TrainerDto trainer : trainers) {
            TrainerLikeDto trainerLikeDto = new TrainerLikeDto(0, trainer.getSeq(), nickname);
            int likeStatus = trainerDao.checkUserLikeStatus(trainerLikeDto);
            trainer.setLove(likeStatus);
        }
        return trainers;
    }


    public int getAllTrainer(TrainersParam param) {
        return trainerDao.getAllTrainer(param);
    }

    public TrainerDto getTrainer(int seq) {
        return trainerDao.getTrainer(seq);
    }

    public boolean writeTrainer(TrainerDto dto) {
    	return trainerDao.writeTrainer(dto) > 0;
    }
    public boolean updateTrainer(TrainerDto dto) {
        return trainerDao.updateTrainer(dto) > 0;
    }

    public boolean deleteTrainer(int seq) {
        return trainerDao.deleteTrainer(seq) > 0;
    }
    
    
    public boolean toggleLike(int pt_seq, String nickname, boolean isLiked) {
        TrainerLikeDto trainerLikeDto = new TrainerLikeDto(0, pt_seq, nickname);

        // 좋아요를 누른 상태에서 다시 누르면 좋아요 취소
        if (isLiked) {
            int deleteResult = trainerDao.deleteLike(trainerLikeDto);
            if (deleteResult > 0) {
                trainerDao.decreaseLikes(pt_seq);
                return true;
            }
            return false;
        }
        // 좋아요를 누르지 않은 상태에서 누르면 좋아요
        else {
            int addResult = trainerDao.addLike(trainerLikeDto);
            if (addResult > 0) {
                trainerDao.increaseLikes(pt_seq);
                return true;
            }
            return false;
        }
    }
    public int countLikesByTrainer(int trainerSeq) {
        return trainerDao.countLikesByTrainer(trainerSeq);
    }
}
