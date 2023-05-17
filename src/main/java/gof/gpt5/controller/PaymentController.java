package gof.gpt5.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gof.gpt5.dto.CoinPaymentDto;
import gof.gpt5.dto.MemberDto;
import gof.gpt5.dto.PaymentParamDto;
import gof.gpt5.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired 
	PaymentService service;
	
	// 코인 결제 및 내역 DB에 저장
		@PostMapping(value = "/addCoinPayment")
		public String addCoinPayment(CoinPaymentDto dto) {
			System.out.println("PaymentController addPayment " + new Date() );
			
			boolean isS = service.addCoinPayment(dto);
			
			if(isS) {
				return "SUCCESS";
			}
			
			return "FAIL";
		}
		
		// 구매자 코인 업데이트
		@PostMapping(value= "/updateBuyerCoin")
		public void updateCoin(MemberDto dto) {
			System.out.println("PaymentController updateBuyerCoin " + new Date() );
			
			service.updateBuyerCoin(dto);
		}
		
		// 판매자 코인 업데이트
		@PostMapping(value= "/updateSellerCoin")
		public void updateSellerCoin(MemberDto dto) {
			System.out.println("PaymentController updateSellerCoin " + new Date() );
			
			service.updateSellerCoin(dto);
		}
		
		@PostMapping(value = "/getPaymentBbs")
		public Map<String, Object> getPaymentBbs(PaymentParamDto param){
			System.out.println("PaymentController getPaymentBbs " + new Date() );
			
			int pn = param.getPageNumber();
			int start = 1 + (pn * 10);
			int end = (pn + 1) * 10;
			
			param.setStart(start);
			param.setEnd(end);
			
			System.out.println(param.toString());
			List<CoinPaymentDto> list = service.getPaymentBbs(param);
			int len = service.getPaymentCount(param);
			
			//System.out.println(list);
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("cnt", len);
			
			return map;
		}
	

}
