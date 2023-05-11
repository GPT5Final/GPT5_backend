package gof.gpt5.dto;

public class ChargeParamDto {
	private String nickname;
	private int pageNumber;
	
	private int start;
	private int end;
	
	public ChargeParamDto() {
	}

	public ChargeParamDto(String nickname, int pageNumber, int start, int end) {
		super();
		this.nickname = nickname;
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
		return "PaymentParamDto [nickname=" + nickname + ", pageNumber=" + pageNumber + ", start=" + start + ", end="
				+ end + "]";
	} 


	
	
}

