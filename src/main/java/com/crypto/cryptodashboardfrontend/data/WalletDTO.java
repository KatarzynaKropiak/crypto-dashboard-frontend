package com.crypto.cryptodashboardfrontend.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletDTO {
  
	private String walletId;

  @JsonProperty("userName")
	private String userName;
  @JsonProperty("email")
  private String email;

	public String getwalletId() {
		return walletId;
	}

	public void setwalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

  public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof WalletDTO)) {
			return false;
		}

		return (walletId == ((WalletDTO) obj).walletId) && (userName == ((WalletDTO) obj).userName) && (email == ((WalletDTO) obj).email);
	}

}
