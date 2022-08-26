package com.crypto.cryptodashboardfrontend.data;

public class CoinDTO {

	private String id;
	private String name;
	private String symbol;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CoinDTO)) {
			return false;
		}

		return (id == ((CoinDTO) obj).id) && (name == ((CoinDTO) obj).name) && (symbol == ((CoinDTO) obj).symbol);
	}
}
