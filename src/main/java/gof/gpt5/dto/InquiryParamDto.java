package gof.gpt5.dto;

public class InquiryParamDto {
	private String nickname;
	private String choice;
	private String search;
	private int pageNumber;
	
	private int start;
	private int end;
	
	public InquiryParamDto() {}

	public InquiryParamDto(String choice, String search, int pageNumber, int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "InquiryParamDto [nickname=" + nickname + ", choice=" + choice + ", search=" + search + ", pageNumber="
				+ pageNumber + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
