package gof.gpt5.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gof.gpt5.dao.MemberDao;
import gof.gpt5.dto.EmailChkDto;
import gof.gpt5.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	public static String localPath = "/Users/admin/springboot_img/";
	
	@Autowired
	MemberDao dao;

	public boolean emailcheck(String email) { 
		int n = dao.emailcheck(email);
		return n > 0 ? true : false;
	}

	public boolean insertEmailKey(EmailChkDto dto) {
		int n = dao.insertEmailKey(dto);
		return n > 0 ? true : false;
	}
	
	public boolean updateEmailKey(EmailChkDto dto) {
		int n = dao.updateEmailKey(dto);
		return n > 0 ? true : false;
	}
	
	public EmailChkDto emailKeyChk(EmailChkDto dto) {
		return dao.emailKeyChk(dto);
	}
	
	public int updateMailAuth(EmailChkDto dto) {
		return dao.updateMailAuth(dto);
	}
	
	public boolean emailChk(String email) { //이메일 인증 확인 
		int n = dao.emailChk(email);
		return n > 0 ? true : false;
	}
	
	public boolean emailAuthChk(EmailChkDto dto) {
		int n = dao.emailAuthChk(dto);
		return n == 1 ? true : false;
	}

//	public boolean addmember(MemberDto dto) {
//		int n = dao.addmember(dto);
//		return n > 0 ? true : false;
//	}

	public boolean addmember(MemberDto dto) throws IOException {
        System.out.println("service 도착");
        if (dto.getImage() != null) {
            MultipartFile imageFile = dto.getImage();
            String originalFileName = imageFile.getOriginalFilename();    //오리지날 파일명
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

            String storedFileName = UUID.randomUUID() + extension;
            String savePath = localPath + "profile/" + storedFileName;
            imageFile.transferTo(new File(savePath));

            dto.setProfile(storedFileName);
        }
        System.out.println(dto);
        System.out.println("service 탈출");
        int n = dao.addmember(dto);
		return n > 0 ? true : false;
    }
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
	public MemberDto getMember(MemberDto dto) {
		return dao.getMember(dto);
	}
	
	public boolean chargeCoin(MemberDto dto) {
		int n = dao.chargeCoin(dto);
		return n > 0 ? true : false;
	}
	
	public boolean delmember(String email) {
		int n = dao.delmember(email);
		return n>0?true:false;
	}
	
	public boolean updatemember(MemberDto dto) {
		int n = dao.updatemember(dto);
		return n>0?true:false;
	}
	
	public MemberDto allmember(MemberDto dto) {
		return dao.allmember(dto);
	}

}
