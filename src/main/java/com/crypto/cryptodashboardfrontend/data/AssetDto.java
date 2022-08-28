package com.crypto.cryptodashboardfrontend.data;

import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
public class AssetDto {
  private String assetId;
  private String walletId;
  private String coinId;
  private BigDecimal coinValue;
  private String currencyId;
  private BigDecimal currencyValue;


//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof AssetDto)) {
//			return false;
//		}
//
//		return (assetId == ((AssetDto) obj).assetId) && (walletId == ((AssetDto) obj).walletId);
//	}
}
