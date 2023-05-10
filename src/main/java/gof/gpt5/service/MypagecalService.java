package gof.gpt5.service;

import gof.gpt5.dao.MypagecalDao;
import gof.gpt5.dto.MypagecalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MypagecalService {
    @Autowired
    MypagecalDao dao;

    public boolean addcal(MypagecalDto dto){
        int n = dao.addcal(dto);
        return n > 0?true:false;
    }
}
