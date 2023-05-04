package gof.gpt5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.PaymentDao;
import gof.gpt5.dto.CoinPaymentDto;
import gof.gpt5.dto.MemberDto;
import gof.gpt5.dto.PaymentDto;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	PaymentDao dao;
	
	public boolean addPayment(PaymentDto dto) {
		int n = dao.addPayment(dto);
		return n > 0 ? true : false;
	}
	
	public boolean addCoinPayment(CoinPaymentDto dto) {
		int n = dao.addCoinPayment(dto);
		return n > 0 ? true : false;
	}
	
	public void updateBuyerCoin(MemberDto dto) {
		dao.updateBuyerCoin(dto);
	}
	
	public void updateSellerCoin(MemberDto dto) {
		dao.updateSellerCoin(dto);
	}
	
	public List<PaymentDto> getPaymentBbs(MemberDto dto){
		return dao.getPaymentBbs(dto);
	}
}
