package gof.gpt5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import gof.gpt5.dto.CoinPaymentDto;
import gof.gpt5.dto.MemberDto;
import gof.gpt5.dto.PaymentParamDto;

@Mapper
@Repository
public interface PaymentDao {

	int addCoinPayment(CoinPaymentDto dto);

	void updateBuyerCoin(MemberDto dto);

	void updateSellerCoin(MemberDto dto);
	
	List<CoinPaymentDto> getPaymentBbs(PaymentParamDto param);
	
	int getPaymentCount(PaymentParamDto param);

}
