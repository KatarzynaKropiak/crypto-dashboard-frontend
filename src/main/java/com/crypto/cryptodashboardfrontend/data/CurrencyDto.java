package com.crypto.cryptodashboardfrontend.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDto {

	private String id;
	private String name;

//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof CurrencyDto)) {
//			return false;
//		}
//
//		return (id == ((CurrencyDto) obj).id) && (name == ((CurrencyDto) obj).name);
//	}
}
