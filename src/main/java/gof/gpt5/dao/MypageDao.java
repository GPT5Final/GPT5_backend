package gof.gpt5.dao;

import gof.gpt5.dto.MypageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MypageDao {
    int addcal(MypageDto dto);
}
