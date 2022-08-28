package com.crypto.cryptodashboardfrontend.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinDto {

	private String id;
	private String name;
	private String symbol;


//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof CoinDto)) {
//			return false;
//		}
//
//		return (id == ((CoinDto) obj).id) && (name == ((CoinDto) obj).name) && (symbol == ((CoinDto) obj).symbol);
//	}
}
