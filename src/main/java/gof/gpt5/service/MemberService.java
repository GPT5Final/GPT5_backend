package gof.gpt5.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.google.protobuf.compiler.PluginProtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import gof.gpt5.dao.MemberDao;
import gof.gpt5.dto.EmailChkDto;
import gof.gpt5.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	public static String localPath = "src/main/resources/static/images/";

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

	public boolean addmember(MemberDto dto) throws IOException {

		if (dto.getImage() != null) {
			MultipartFile imageFile = dto.getImage();
			String originalFileName = imageFile.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

			String storedFileName = UUID.randomUUID() + extension;
			String filePath = localPath + "/" + storedFileName;
			FileCopyUtils.copy(imageFile.getBytes(), new File(filePath));

			dto.setProfile(storedFileName);
		}

		int n = dao.addmember(dto);
		return n > 0;
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

	public boolean updatemembernull(MemberDto dto) {
		int n = dao.updatemembernull(dto);
		return n>0?true:false;
	}
	public boolean updatemember(MemberDto dto) throws IOException {

		if (dto.getImage() != null) {
			MultipartFile imageFile = dto.getImage();
			String originalFileName = imageFile.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

			String storedFileName = UUID.randomUUID() + extension;
			String filePath = localPath + "/" + storedFileName;
			FileCopyUtils.copy(imageFile.getBytes(), new File(filePath));

			dto.setProfile(storedFileName);
		}

		int n = dao.updatemember(dto);
		return n > 0;
	}


	public MemberDto allmember(MemberDto dto) {
		return dao.allmember(dto);
	}

}
