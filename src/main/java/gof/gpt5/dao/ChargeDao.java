package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.CoinPaymentDto;
import gof.gpt5.dto.MemberDto;
import gof.gpt5.dto.ChargeDto;
import gof.gpt5.dto.ChargeParamDto;

@Mapper
@Repository
public interface ChargeDao {
	int addChargeBbs(ChargeDto dto);

	List<ChargeDto> getChargeBbs(ChargeParamDto param);

	int getChargeCount(ChargeParamDto param);

}
