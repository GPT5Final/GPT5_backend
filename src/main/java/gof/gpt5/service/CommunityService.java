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
	
	public List<CommunityDto> Communitylist(CommunityParam bbs) {
		return CommunityDao.Communitylist(bbs);
	}
	
	public int getAllCommunity(CommunityParam bbs) {
		return CommunityDao.getAllCommunity(bbs);
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

    
}
