package gof.gpt5.service;

import gof.gpt5.dto.ImageDto;
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
    public TrainerDto getTopTrainer() {
        return trainerDao.getTopTrainer();
    }
    public boolean writeImageInfo(ImageDto dto) {
        return trainerDao.writeImageInfo(dto) > 0;
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
        
    public boolean toggleLike(int ptSeq, String nickname) {
        TrainerLikeDto trainerLikeDto = new TrainerLikeDto(ptSeq, nickname);

        // '좋아요' 상태를 확인
        int likeStatus = trainerDao.checkUserLikeStatus(trainerLikeDto);

        // 이미 '좋아요'를 누른 상태
        if (likeStatus > 0) {
            int deleteResult = trainerDao.deleteLike(trainerLikeDto);
            System.out.println("deleteLike 결과: " + deleteResult);
            if (deleteResult > 0) {
                trainerDao.decreaseLikes(ptSeq);
                return true;
            }
            return false;
        }
        // '좋아요'를 누르지 않은 상태
        else {
            int addResult = trainerDao.addLike(trainerLikeDto);
            System.out.println("addLike 결과: " + addResult);
            if (addResult > 0) {
                trainerDao.increaseLikes(ptSeq);
                return true;
            }
            return false;
        }
    }

    public boolean existsPtSeq(int ptSeq) {
        return trainerDao.existsPtSeq(ptSeq) > 0;
    }
    
    public int countLikesByTrainer(int trainerSeq) {
        return trainerDao.countLikesByTrainer(trainerSeq);
    }
    
    public ImageDto getFirstImage(int trainerSeq) {
        return trainerDao.getFirstImage(trainerSeq);
    }

    public List<ImageDto> getAllImages(int trainerSeq) {
        return trainerDao.getAllImages(trainerSeq);
    }
}
