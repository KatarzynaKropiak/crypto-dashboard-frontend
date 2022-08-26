package com.crypto.cryptodashboardfrontend.data;

import java.math.BigDecimal;

public class AssetDTO {
  private String assetId;
	private String walletId;
  private String coinId;
  private BigDecimal coinValue;
	private String currencyId;
  private BigDecimal currencyValue;


	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

  public String getCoinId() {
		return coinId;
	}

	public void setCoinId(String coinId) {
		this.coinId = coinId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

  public BigDecimal getCoinValue() {
		return coinValue;
	}

	public void setCoinValue(BigDecimal coinValue) {
		this.coinValue = coinValue;
	}

  public BigDecimal getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}



	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof AssetDTO)) {
			return false;
		}

		return (assetId == ((AssetDTO) obj).assetId) && (walletId == ((AssetDTO) obj).walletId);
	}
}
