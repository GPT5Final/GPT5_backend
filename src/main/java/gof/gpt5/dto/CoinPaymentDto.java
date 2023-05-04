package gof.gpt5.dto;

import java.io.Serializable;

public class CoinPaymentDto implements Serializable {
	private String buyer;
	private int amount;
	private String paymentkey;
	private String seller;
	private String ordername;
	private String wdate; 
	
	public CoinPaymentDto() {
	}

	public CoinPaymentDto(String buyer, int amount, String paymentkey, String seller, String ordername, String wdate) {
		super();
		this.buyer = buyer;
		this.amount = amount;
		this.paymentkey = paymentkey;
		this.seller = seller;
		this.ordername = ordername;
		this.wdate = wdate;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentkey() {
		return paymentkey;
	}

	public void setPaymentkey(String paymentkey) {
		this.paymentkey = paymentkey;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "CoinPaymentDto [buyer=" + buyer + ", amount=" + amount + ", paymentkey=" + paymentkey + ", seller="
				+ seller + ", ordername=" + ordername + ", wdate=" + wdate + "]";
	}	
	
	
}
