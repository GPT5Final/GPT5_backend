package gof.gpt5.service;

import gof.gpt5.dao.MypageDao;
import gof.gpt5.dto.MypageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MypageService {
    @Autowired
    MypageDao dao;

    public boolean addcal(MypageDto dto){
        int n = dao.addcal(dto);
        return n > 0?true:false;
    }

}
