package gof.gpt5.dao;

import gof.gpt5.dto.MypagecalDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MypagecalDao {
    int addcal(MypagecalDto dto);
}
