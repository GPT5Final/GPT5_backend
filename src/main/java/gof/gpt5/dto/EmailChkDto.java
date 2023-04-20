package gof.gpt5.dto;

public class EmailChkDto {
	private String Email; // 이메일
	private String EmailAuth; // 인증 0 인증 1
	private String EmailKey; // 랜덤 키 저장
	
	public EmailChkDto() {
	}

	public EmailChkDto(String email, String emailAuth, String emailKey) {
		super();
		Email = email;
		EmailAuth = emailAuth;
		EmailKey = emailKey;
	}

	public EmailChkDto(String email, String emailKey) {
		super();
		Email = email;
		EmailKey = emailKey;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmailAuth() {
		return EmailAuth;
	}

	public void setEmailAuth(String emailAuth) {
		EmailAuth = emailAuth;
	}

	public String getEmailKey() {
		return EmailKey;
	}

	public void setEmailKey(String emailKey) {
		EmailKey = emailKey;
	}

	@Override
	public String toString() {
		return "EmailChkDto [Email=" + Email + ", EmailAuth=" + EmailAuth + ", EmailKey=" + EmailKey + "]";
	}
	
	
	
}
