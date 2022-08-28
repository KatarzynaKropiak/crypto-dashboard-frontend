package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

@SuppressWarnings("serial")
@Service
public class CoinRatesService implements Serializable {

	@Value("${server.port}")
	private String serverPort;

	public SimpleRateDto getSimpleRate(String coinId, String currency) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/rates?coinId="+ coinId + "&currency="+currency);

		// do fetch and map result
		final SimpleRateDto simpleRate = spec.retrieve().toEntity(SimpleRateDto.class).block().getBody();


		return simpleRate;
	}

	public List<SimpleRateDto> getAllRates(String currency) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/rates?currency=" + currency);

		// do fetch and map result
		final List<SimpleRateDto> allRates = spec.retrieve().toEntityList(SimpleRateDto.class).block().getBody();


		return allRates;
	}

	public List<SimpleRateDto> getRateForAllCurrencies(String coinId) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/rates?coinId=" + coinId);

		// do fetch and map result
		final List<SimpleRateDto> allCurrencies = spec.retrieve().toEntityList(SimpleRateDto.class).block().getBody();


		return allCurrencies;
	}

	public List<CoinDto> getCoins() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/coins");

		// do fetch and map result
		final List<CoinDto> coins = spec.retrieve().toEntityList(CoinDto.class).block().getBody();


		return coins;
	}

	public List<CurrencyDto> getCurrencies() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/currencies");

		// do fetch and map result
		final List<CurrencyDto> currencies = spec.retrieve().toEntityList(CurrencyDto.class).block().getBody();


		return currencies;
	}



}
