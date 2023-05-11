package gof.gpt5.dto;

public class PaymentParamDto {
	private String buyer;
	private int pageNumber;
	
	private int start;
	private int end;
	
	public PaymentParamDto() {
	}

	public PaymentParamDto(String buyer, int pageNumber, int start, int end) {
		super();
		this.buyer = buyer;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
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
		return "PaymentParamDto [buyer=" + buyer + ", pageNumber=" + pageNumber + ", start=" + start + ", end=" + end
				+ "]";
	}
	
	
}
