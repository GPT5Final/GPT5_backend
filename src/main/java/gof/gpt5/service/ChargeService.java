package gof.gpt5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.gpt5.dao.ChargeDao;
import gof.gpt5.dto.CoinPaymentDto;
import gof.gpt5.dto.MemberDto;
import gof.gpt5.dto.ChargeDto;
import gof.gpt5.dto.ChargeParamDto;

@Service
@Transactional
public class ChargeService {

	@Autowired
	ChargeDao dao;

	public boolean addChargeBbs(ChargeDto dto) {
		int n = dao.addChargeBbs(dto);
		return n > 0 ? true : false;
	}

	public List<ChargeDto> getChargeBbs(ChargeParamDto param) {
		return dao.getChargeBbs(param);
	}

	public int getChargeCount(ChargeParamDto param) {
		return dao.getChargeCount(param);
	}
}
