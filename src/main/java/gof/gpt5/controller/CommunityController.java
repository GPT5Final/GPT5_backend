package gof.gpt5.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gof.gpt5.dto.CommunityDto;
import gof.gpt5.dto.CommunityParam;
import gof.gpt5.service.CommunityService;

@RestController
public class CommunityController {

	@Autowired
	CommunityService service;

	@GetMapping(value = "Communitylist")
	public Map<String, Object> Communitylist(CommunityParam param) {
	    System.out.println("CommunityController Communitylist() " + new Date());

	    // 글의 시작과 끝
	    int pn = param.getPageNumber(); // 1 2 3 4 5
	    int start = 1 + ((pn - 1) * 10); // 1 11 21 31 41
	    int end = pn * 10; // 10 20 30 40 50
	    param.setStart(start);
	    param.setEnd(end);

	    List<CommunityDto> list = service.Communitylist(param);
	    int len = service.getAllCommunity(param);

	    Map<String, Object> map = new HashMap<>();
	    map.put("list", list);
	    map.put("cnt", len);

	    return map;
	}

	@GetMapping(value = "getCommunity")
	public CommunityDto getCommunity(int seq) {
		System.out.println("CommunityController getCommunity() " + new Date());
		return service.getCommunity(seq);
	}

	@PostMapping(value = "Communitywrite")
	public String Communitywrite(CommunityDto dto) {
		System.out.println("CommunityController Communitywrite() " + new Date());

		boolean b = service.writeCommunity(dto);
		if (b) {
			return "YES";
		}
		return "NO";
	}

    @RequestMapping(value = "/updateCommunity", method = { RequestMethod.POST, RequestMethod.OPTIONS })
    public String handleUpdateCommunity() {
        return "OK";
    }
	
	@PostMapping(value = "Communityupdate")
	public String Communityupdate(CommunityDto dto) {
		System.out.println("CommunityController Communityupdate() " + new Date());
		
		boolean isS = service.updateCommunity(dto);
		if (!isS) {
			return "NO";
		}
		return "그룹에 가입되었습니다";
	}

	@PostMapping(value = "Communitydelete")
	public String Communitydelete(int seq) {
		boolean b = service.deleteCommunity(seq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@GetMapping(value = "Bannerlist")
	public Map<String, Object> Bannerlist(CommunityParam param) {
		System.out.println("CommunityController Bannerlist() " + new Date());

		// 글의 시작과 끝
		int start = 1; // 시작 글 번호
		int end = Integer.MAX_VALUE; // 끝 글 번호 (최대값으로 설정하여 전체 글을 가져옴)
		param.setStart(start);
		param.setEnd(end);

		List<CommunityDto> list = service.Bannerlist(param);
		int len = service.getAllBanner(param);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;
	}

	@GetMapping(value = "getBanner")
	public CommunityDto getBanner(int seq) {
		System.out.println("CommunityController getBanner() " + new Date());
		return service.getBanner(seq);
	}
	
	@GetMapping(value = "Homelist")
	public Map<String, Object> Homelist(CommunityParam param) {
	    System.out.println("CommunityController Homelist() " + new Date());

	    // 글의 시작과 끝
	    int pn = param.getPageNumber(); // 1 2 3 4 5
	    int start = 1 + ((pn - 1) * 10); // 1 11 21 31 41
	    int end = pn * 10; // 10 20 30 40 50
	    param.setStart(start);
	    param.setEnd(end);

	    List<CommunityDto> list = service.Homelist(param);
	    int len = service.getAllHome(param);

	    Map<String, Object> map = new HashMap<>();
	    map.put("list", list);
	    map.put("cnt", len);

	    return map;
	}
	
	@GetMapping(value = "getHome")
	public CommunityDto getHome(int seq) {
		System.out.println("CommunityController getHome() " + new Date());
		return service.getHome(seq);
	}
	
	@GetMapping(value = "PartnerMentorlist")
	public Map<String, Object> PartnerMentorlist(CommunityParam param) {
	    System.out.println("CommunityController PartnerMentorlist() " + new Date());

	    // 글의 시작과 끝
	    int pn = param.getPageNumber(); // 1 2 3 4 5
	    int start = 1 + ((pn - 1) * 10); // 1 11 21 31 41
	    int end = pn * 10; // 10 20 30 40 50
	    param.setStart(start);
	    param.setEnd(end);

	    List<CommunityDto> list = service.PartnerMentorlist(param);
	    int len = service.getAllPartnerMentor(param);

	    Map<String, Object> map = new HashMap<>();
	    map.put("list", list);
	    map.put("cnt", len);

	    return map;
	}
	
	@GetMapping(value = "getPartnerMentor")
	public CommunityDto getPartnerMentor(int seq) {
		System.out.println("CommunityController getPartnerMentor() " + new Date());
		return service.getPartnerMentor(seq);
	}
	
	@GetMapping(value = "MentorMenteelist")
	public Map<String, Object> MentorMenteelist(CommunityParam param) {
	    System.out.println("CommunityController MentorMenteelist() " + new Date());

	    // 글의 시작과 끝
	    int pn = param.getPageNumber(); // 1 2 3 4 5
	    int start = 1 + ((pn - 1) * 10); // 1 11 21 31 41
	    int end = pn * 10; // 10 20 30 40 50
	    param.setStart(start);
	    param.setEnd(end);

	    List<CommunityDto> list = service.MentorMenteelist(param);
	    int len = service.getAllMentorMentee(param);

	    Map<String, Object> map = new HashMap<>();
	    map.put("list", list);
	    map.put("cnt", len);

	    return map;
	}
	
	@GetMapping(value = "getMentorMentee")
	public CommunityDto getMentorMentee(int seq) {
		System.out.println("CommunityController getMentorMentee() " + new Date());
		return service.getMentorMentee(seq);
	}
	
	@GetMapping(value = "ExerciseTalklist")
	public Map<String, Object> ExerciseTalklist(CommunityParam param) {
	    System.out.println("CommunityController ExerciseTalklist() " + new Date());

	    // 글의 시작과 끝
	    int pn = param.getPageNumber(); // 1 2 3 4 5
	    int start = 1 + ((pn - 1) * 10); // 1 11 21 31 41
	    int end = pn * 10; // 10 20 30 40 50
	    param.setStart(start);
	    param.setEnd(end);

	    List<CommunityDto> list = service.ExerciseTalklist(param);
	    int len = service.getAllExerciseTalk(param);

	    Map<String, Object> map = new HashMap<>();
	    map.put("list", list);
	    map.put("cnt", len);

	    return map;
	}
	
	@GetMapping(value = "getExerciseTalk")
	public CommunityDto getExerciseTalk(int seq) {
		System.out.println("CommunityController getExerciseTalk() " + new Date());
		return service.getCommunity(seq);
	}
	
	@PostMapping(value = "increaseReadCount")
	public int increaseReadCount(int seq) {
		System.out.println("CommunityController increaseReadCount() " + new Date());
		return service.increaseReadCount(seq);
	}


}
