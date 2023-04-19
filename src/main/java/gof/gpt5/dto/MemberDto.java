package gof.gpt5.dto;

import java.io.Serializable;
/*
		CREATE TABLE member (
		email varchar(50) NOT NULL,
		pwd varchar(50) NOT NULL,
		nickname varchar(50) NOT NULL,
		gender char(1) NOT NULL,
		name varchar(50) DEFAULT NULL,
		auth int NOT NULL COMMENT '운영자 : 0, 회원 : 1',
		contact varchar(255) DEFAULT NULL,
		birth int NOT NULL,
		coin int default 0 unique key,		
		profile decimal(1),
		
		UNIQUE KEY (nickname),
		PRIMARY KEY email (email)
		);  
 */
public class MemberDto implements Serializable {

	private String email;
	private String pwd;
	private String nickname;
	private char gender;
	private String name;
	private int auth;
	private String contact;
	private String birth;
	private int coin;
	private int profile;

	public MemberDto() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "MemberDto [email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", gender=" + gender
				+ ", name=" + name + ", auth=" + auth + ", contact=" + contact + ", birth=" + birth + ", coin=" + coin
				+ ", profile=" + profile + "]";
	}
	

}

