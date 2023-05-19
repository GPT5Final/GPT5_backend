package gof.gpt5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gof.gpt5.dao.CommunityDao;
import gof.gpt5.dto.CommunityDto;
import gof.gpt5.dto.CommunityParam;

@Service
public class CommunityService {
	
	@Autowired
	CommunityDao CommunityDao;
	
	public List<CommunityDto> Communitylist(CommunityParam param) {
		return CommunityDao.Communitylist(param);
	}
	
	public int getAllCommunity(CommunityParam param) {
		return CommunityDao.getAllCommunity(param);
	}
	
	public CommunityDto getCommunity(int seq) {
		return CommunityDao.getCommunity(seq);
	}

    public boolean writeCommunity(CommunityDto dto) {
    	return CommunityDao.writeCommunity(dto) > 0;
    }
    public boolean updateCommunity(CommunityDto dto) {
        return CommunityDao.updateCommunity(dto) > 0;
    }

    public boolean deleteCommunity(int seq) {
        return CommunityDao.deleteCommunity(seq) > 0;
    }
	public List<CommunityDto> Bannerlist(CommunityParam param) {
		return CommunityDao.Bannerlist(param);
	}
	
	public int getAllBanner(CommunityParam param) {
		return CommunityDao.getAllBanner(param);
	}
	
	public CommunityDto getBanner(int seq) {
		return CommunityDao.getBanner(seq);
	}
	
	public List<CommunityDto> Homelist(CommunityParam param) {
		return CommunityDao.Homelist(param);
	}
	
	public int getAllHome(CommunityParam param) {
		return CommunityDao.getAllHome(param);
	}
	
	public CommunityDto getHome(int seq) {
		return CommunityDao.getHome(seq);
	}
	public List<CommunityDto> PartnerMentorlist(CommunityParam param) {
		return CommunityDao.PartnerMentorlist(param);
	}
	
	public int getAllPartnerMentor(CommunityParam param) {
		return CommunityDao.getAllPartnerMentor(param);
	}
	
	public CommunityDto getPartnerMentor(int seq) {
		return CommunityDao.getPartnerMentor(seq);
	}
	public List<CommunityDto> MentorMenteelist(CommunityParam param) {
		return CommunityDao.MentorMenteelist(param);
	}
	
	public int getAllMentorMentee(CommunityParam param) {
		return CommunityDao.getAllMentorMentee(param);
	}
	
	public CommunityDto getMentorMentee(int seq) {
		return CommunityDao.getMentorMentee(seq);
	}
	public List<CommunityDto> ExerciseTalklist(CommunityParam param) {
		return CommunityDao.ExerciseTalklist(param);
	}
	
	public int getAllExerciseTalk(CommunityParam param) {
		return CommunityDao.getAllExerciseTalk(param);
	}
	
	public CommunityDto getExerciseTalk(int seq) {
		return CommunityDao.getExerciseTalk(seq);
	}
	
    public int increaseReadCount(int seq) {
        return CommunityDao.increaseReadCount(seq);
    }
	
}
