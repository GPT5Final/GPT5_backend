package gof.gpt5.service;

import gof.gpt5.dto.GimageDto;
import gof.gpt5.dto.GymsDto;
import gof.gpt5.dto.GymsLikeDto;
import gof.gpt5.dto.TrainersParam;
import gof.gpt5.dao.GymsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymsService {

    @Autowired
    private GymsDao gymsDao;

    public List<GymsDto> gymslist(TrainersParam param, String nickname) {
        List<GymsDto> gyms = gymsDao.gymslist(param);
        for (GymsDto gym : gyms) {
            GymsLikeDto GymsLikeDto = new GymsLikeDto(0, gym.getgSeq(), nickname);
            int likeStatus = gymsDao.checkUserLikeStatus(GymsLikeDto);
            gym.setLove(likeStatus);
        }
        return gyms;
    }

    public int getAllGyms(TrainersParam param) {
        return gymsDao.getAllGyms(param);
    }

    public GymsDto getGym(int seq) {
        return gymsDao.getGym(seq);
    }

    public GymsDto getTopGym() {
        return gymsDao.getTopGym();
    }

    public boolean writeImageInfo(GimageDto dto) {
        return gymsDao.writeImageInfo(dto) > 0;
    }

    public int writeGyms(GymsDto dto) {
        int result = gymsDao.writeGym(dto);
        if(result > 0) {
            return dto.getgSeq();  // gymsDto가 성공적으로 저장된 경우, 생성된 g_seq 값을 반환합니다.
        } else {
            return -1;  // gymsDto가 데이터베이스에 저장되지 않은 경우, -1을 반환합니다.
        }
    }

    public boolean updateGym(GymsDto dto) {
        return gymsDao.updateGym(dto) > 0;
    }

    public boolean deleteGym(int seq) {
        return gymsDao.deleteGym(seq) > 0;
    }

    public boolean gtoggleLike(int gymSeq, String nickname) {
        GymsLikeDto GymsLikeDto = new GymsLikeDto(gymSeq, nickname);

        // '좋아요' 상태를 확인
        int likeStatus = gymsDao.checkUserLikeStatus(GymsLikeDto);

        // 이미 '좋아요'를 누른 상태라면
        if (likeStatus > 0) {
            int deleteResult = gymsDao.deleteLike(GymsLikeDto);
            System.out.println("deleteLike 결과: " + deleteResult);
            if (deleteResult > 0) {
                gymsDao.decreaseLikes(gymSeq);
                return true;
            }
            return false;
        }
        // '좋아요'를 누르지 않은 상태라면
        else {
            int addResult = gymsDao.addLike(GymsLikeDto);
            System.out.println("addLike 결과: " + addResult);
            if (addResult > 0) {
                gymsDao.increaseLikes(gymSeq);
                return true;
            }
            return false;
        }
    }
    
    public boolean existsGymSeq(int gymSeq) {
        return gymsDao.existsGymSeq(gymSeq) > 0;
    }

    public int countLikesByGyms(int gymSeq) {
        return gymsDao.countLikesByGyms(gymSeq);
    }
    
    public GimageDto getFirstImage(int gSeq) {
        return gymsDao.getFirstImage(gSeq);
    }

    public List<GimageDto> getAllImages(int gSeq) {
        return gymsDao.getAllImages(gSeq);
    }
}

