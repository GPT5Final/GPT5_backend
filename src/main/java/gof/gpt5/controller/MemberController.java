package gof.gpt5.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gof.gpt5.dto.EmailChkDto;
import gof.gpt5.dto.MemberDto;
import gof.gpt5.mail.MailHandler;
import gof.gpt5.mail.TempKey;
import gof.gpt5.service.MemberService;

@RestController
public class MemberController {
	public static String localPath = "/Users/admin/springboot_img/";

	@Autowired
	MemberService service;

	@Autowired
	JavaMailSender mailSender;

	@PostMapping(value = "/emailcheck")
	public String emailcheck(String email) {
		System.out.println("MemberController emailcheck " + new Date());

		boolean b = service.emailcheck(email);
		if (b) {
			return "NO";
		}
		return "YES";
	}

	@PostMapping(value = "/emailChkSend")
	public String emailChksend(EmailChkDto dto, @RequestParam(value = "usermail") String usermail) throws Exception {

		System.out.println("MemberController emailChksend " + new Date());
		// 이메일 중복확인 후 사용가능하면 이메일전송
		boolean emailS = service.emailChk(usermail);
		if (emailS == true) {
			return "NO";
		} else {
			String mailKey = new TempKey().getKey(6, false);
			dto.setEmailKey(mailKey);
			dto.setEmail(usermail);

			boolean emailready = service.updateEmailKey(dto);

			if (emailready) {
				MailHandler sendMail = new MailHandler(mailSender);
				sendMail.setSubject("GPT5 인증메일입니다.");
				sendMail.setText("<h1>GPT5 메일인증</h1>" + "<br><br>" + "<p>이메일 인증코드는 <b>" + mailKey + "</b> 입니다.</p><br>"
						+ "<p>사이트로 돌아가서 인증코드를 입력해주세요</p>");
				sendMail.setFrom("dlsco123@naver.com", "GPT5");
				sendMail.setTo(dto.getEmail());
				sendMail.send();

				return "updateSuccess";

			} else {
				boolean isS = service.insertEmailKey(dto);
				if (isS) {
					MailHandler sendMail = new MailHandler(mailSender);
					sendMail.setSubject("GPT5 인증메일입니다.");
					sendMail.setText("<h1>GPT5 메일인증</h1>" + "<br><br>" + "<p>이메일 인증코드는 <b>" + mailKey
							+ "</b> 입니다.</p><br>" + "<p>사이트로 돌아가서 인증코드를 입력해주세요</p>");
					sendMail.setFrom("dlsco123@naver.com", "GPT5");
					sendMail.setTo(dto.getEmail());
					sendMail.send();

					return "success";
				} else {
					return "fail";
				}

			}
		}

	}

	@PostMapping(value = "/mailKeyChk")
	public String mailKeyChk(EmailChkDto dto) throws Exception {
		System.out.println("MemberController mailKeyChk " + new Date());

		// System.out.println(dto.toString());

		EmailChkDto echk = service.emailKeyChk(dto);

		// System.out.println(dto.getEmailKey());

		if (echk != null) {
			service.updateMailAuth(dto);
			return "OK";
		} else {
			return "FAIL";
		}
	}

	// Auth가 1 이면 인증된 이메일 // 0 이면 인증 X
	@PostMapping(value = "/emailAuthChk")
	public String emailAuthChk(EmailChkDto dto) {
		System.out.println("MemberController emailAuthChk " + new Date());

		System.out.println(dto.toString());

		boolean isS = service.emailAuthChk(dto);

		System.out.println(isS);

		if (isS == true) { // 인증완료
			return "YES";
		}

		return "NO"; // 인증안함
	}

	@PostMapping(value = "/addmember")
	public String addmember(@ModelAttribute MemberDto dto) throws IOException {
		System.out.println("MemberController addmember " + new Date());
		
		System.out.println(dto.toString());
		
		boolean b = service.addmember(dto);
		if (!b) {
			return "NO";
		}
		return "YES";
	}


	@PostMapping(value = "/chargeCoin")
	public String chargeCoin(MemberDto dto) {
		System.out.println("MemberController chargeCoin " + new Date());
		boolean isS = service.chargeCoin(dto);

		if (isS) {
			return "SUCCESS";
		}

		return "FAIL";
	}

	@PostMapping(value = "/getMember")
	public MemberDto getMember(MemberDto dto) {
		System.out.println("MemberController getMember " + new Date());
		MemberDto mem = service.getMember(dto);

		return mem;
	}

	
	@PostMapping(value = "/login")
	public MemberDto login(MemberDto dto) {		
		System.out.println("MemberController login " + new Date());
		
		MemberDto mem = service.login(dto);
		
		
		System.out.println(dto);
//		if (mem != null) {
//			req.getSession().setAttribute("login", mem);
//			req.getSession().setMaxInactiveInterval(7200);
//			return mem;
//		}
		return mem;
	}
	
	
	@PostMapping(value = "/updatemember")
	public String updatemember(@RequestBody MemberDto dto) {
		System.out.println("MemberController updatemember " + new Date());
		System.out.println(dto);
		System.out.println(dto.getNickname());
		
		boolean b = service.updatemember(dto);
		
		if(!b) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value = "/updatemembernull")
	public String updatemembernull(@RequestBody MemberDto dto) {
		System.out.println("updatemembernull updatemember " + new Date());
		System.out.println(dto);
		System.out.println(dto.getNickname());
		System.out.println(dto.getProfile());

		boolean b = service.updatemember(dto);

		if(!b) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value = "/allmember")
	
	public MemberDto allmember(@RequestBody MemberDto dto) {
		System.out.println("MemberController allmember " + new Date());
		
		MemberDto mem = service.allmember(dto);
		return mem;
	}
	
	@GetMapping(value = "/images/{folderName}/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<FileSystemResource> getImage(@PathVariable String folderName, @PathVariable String imageName) {
        System.out.println("getImage " + new Date());

        String imagePath = localPath + folderName + "/" + imageName;

        File imageFile = new File(imagePath);
        return ResponseEntity.ok()
                .contentLength(imageFile.length())
                .body(new FileSystemResource(imageFile));
    }
	
}
