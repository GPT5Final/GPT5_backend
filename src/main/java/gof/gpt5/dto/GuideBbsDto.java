package gof.gpt5.dto;

import java.io.Serializable;

// BBS  Bulletin Board System
public class GuideBbsDto implements Serializable {

	private int seq;		// sequence 글번호
	private String nickname; 
	private String filename;
	private String title;
	private String content;
	private String wdate;
	private int readcount;	// 조회수
	
	public GuideBbsDto() {
	}

	public GuideBbsDto(int seq, String nickname, String filename, String title, String content, String wdate,
			int readcount) {
		super();
		this.seq = seq;
		this.nickname = nickname;
		this.filename = filename;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.readcount = readcount;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BbsDto [seq=" + seq + ", nickname=" + nickname + ", filename=" + filename + ", title=" + title
				+ ", content=" + content + ", wdate=" + wdate + ", readcount=" + readcount + "]";
	}

	
	
}
