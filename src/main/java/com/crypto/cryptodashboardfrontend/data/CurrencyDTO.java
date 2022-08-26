package com.crypto.cryptodashboardfrontend.data;

public class CurrencyDTO {

	private String id;
	private String name;

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

	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CurrencyDTO)) {
			return false;
		}

		return (id == ((CurrencyDTO) obj).id) && (name == ((CurrencyDTO) obj).name);
	}
}
