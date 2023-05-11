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
import gof.gpt5.dto.ChargeDto;
import gof.gpt5.dto.ChargeParamDto;
import gof.gpt5.service.ChargeService;

@RestController
public class ChargeController {

	@Autowired
	ChargeService service;

	// 코인 충전 및 내역 DB에 저장
	@PostMapping(value = "/addChargeBbs")
	public String addChargeBbs(ChargeDto dto) {
		System.out.println("ChargeController addChargeBbs " + new Date());

		// System.out.println(dto.toString());

		boolean isS = service.addChargeBbs(dto);

		if (isS) {
			return "SUCCESS";
		}
		return "FAIL";
	}

	@PostMapping(value = "/getChargeBbs")
	public Map<String, Object> getChargeBbs(ChargeParamDto param) {
		System.out.println("ChargeController getPaymentBbs " + new Date());

		int pn = param.getPageNumber();
		int start = 1 + (pn * 10);
		int end = (pn + 1) * 10;

		param.setStart(start);
		param.setEnd(end);

		List<ChargeDto> list = service.getChargeBbs(param);
		int len = service.getChargeCount(param);

		//System.out.println(list);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;
	}

}
