package gof.gpt5.dto;

public class PaymentDto {
	private String nickname;
	private int amount;
	private String orderid;
	private String ordername;
	private String paymentkey;
	private String wdate;

	public PaymentDto() {
	}

	public PaymentDto(String nickname, int amount, String orderid, String ordername, String paymentkey, String wdate) {
		super();
		this.nickname = nickname;
		this.amount = amount;
		this.orderid = orderid;
		this.ordername = ordername;
		this.paymentkey = paymentkey;
		this.wdate = wdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getPaymentkey() {
		return paymentkey;
	}

	public void setPaymentkey(String paymentkey) {
		this.paymentkey = paymentkey;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "PaymentDto [nickname=" + nickname + ", amount=" + amount + ", orderid=" + orderid + ", ordername="
				+ ordername + ", paymentkey=" + paymentkey + ", wdate=" + wdate + "]";
	}

	

}
