package gof.gpt5.dto;

public class InquiryBbsDto {
	private int seq;
	private String nickname;
	private String title;
	private String content;
	private String filename;
	private String category;
	private String wdate;
	
	public InquiryBbsDto() {
	}

	public InquiryBbsDto(int seq, String nickname, String title, String content, String filename, String category,
			String wdate) {
		super();
		this.seq = seq;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.category = category;
		this.wdate = wdate;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "InquiryBbsDto [seq=" + seq + ", nickname=" + nickname + ", title=" + title + ", content=" + content
				+ ", filename=" + filename + ", category=" + category + ", wdate=" + wdate + "]";
	}

	
	
}
