package gof.gpt5.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gof.gpt5.dto.CommunityDto;
import gof.gpt5.dto.CommunityParam;
import gof.gpt5.service.CommunityService;


@RestController
public class CommunityController{
	@Autowired
	CommunityService service;
	
	
	@GetMapping(value = "Communitylist")
	public Map<String, Object> Communitylist(CommunityParam param){
		System.out.println("CommunityController Communitylist() " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 		
		param.setStart(start);
		param.setEnd(end);
		
		List<CommunityDto> Communities = service.Communitylist(param);
		int len = service.getAllCommunity(param);
		
		Map<String, Object> map = new HashMap<>();
		map.put("Communities", Communities);
		map.put("cnt", len);
		
		return map;
	}
	
	@PostMapping(value = "Communitywrite")
	public String Communitywrite(CommunityDto bbs) {
		System.out.println("CommunityController Communitywrite() " + new Date());
		
		boolean b = service.writeCommunity(bbs);
		if(b) {
			return "YES";
		}		
		return "NO";
	}
	
    @PostMapping(value = "/Communityupdate")
    public String Communityupdate(CommunityDto dto) {
        boolean isS = service.updateCommunity(dto);
        if (!isS) {
            return "NO";
        }
        return "YES";
    }
    
    @PostMapping(value = "Communitydelete")
    public String Communitydelete(int seq) {
        boolean b = service.deleteCommunity(seq);
        if(b == false) {
            return "NO";
        }
        return "YES";
    }


}
