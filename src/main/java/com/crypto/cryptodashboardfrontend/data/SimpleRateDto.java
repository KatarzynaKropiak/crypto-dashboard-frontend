package com.crypto.cryptodashboardfrontend.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleRateDto {

	private String coinId;
	private String currency;
	private Double rate;



//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof SimpleRateDto)) {
//			return false;
//		}
//
//		return (coinId == ((SimpleRateDto) obj).coinId) && (currency == ((SimpleRateDto) obj).currency) && (rate == ((SimpleRateDto) obj).rate);
//	}
}
