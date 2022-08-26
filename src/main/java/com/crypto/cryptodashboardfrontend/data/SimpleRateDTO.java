package com.crypto.cryptodashboardfrontend.data;

public class SimpleRateDTO {

	private String coinId;
	private String currency;
	private Double rate;

	public String getCoinId() {
		return coinId;
	}

	public void setCoinId(String coinId) {
		this.coinId = coinId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof SimpleRateDTO)) {
			return false;
		}

		return (coinId == ((SimpleRateDTO) obj).coinId) && (currency == ((SimpleRateDTO) obj).currency) && (rate == ((SimpleRateDTO) obj).rate);
	}
}
