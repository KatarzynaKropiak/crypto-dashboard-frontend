package com.crypto.cryptodashboardfrontend.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WalletDto {
	private String walletId;

  	@JsonProperty("userName")
  	private String userName;
  	@JsonProperty("email")
  	private String email;


//
//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof WalletDto)) {
//			return false;
//		}
//
//		return (walletId == ((WalletDto) obj).walletId) && (userName == ((WalletDto) obj).userName) && (email == ((WalletDto) obj).email);
//	}

}
