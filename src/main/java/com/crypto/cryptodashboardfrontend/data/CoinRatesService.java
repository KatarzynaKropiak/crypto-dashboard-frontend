package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.data.provider.DataProvider;

@SuppressWarnings("serial")
@Service
public class CoinRatesService implements Serializable {

	@Value("${server.port}")
	private String serverPort;

	public SimpleRateDTO getSimpleRate(String coinId, String currency) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/rates?coinId="+ coinId + "&currency="+currency);

		// do fetch and map result
		final SimpleRateDTO simpleRate = spec.retrieve().toEntity(SimpleRateDTO.class).block().getBody();


		return simpleRate;
	}

	public List<SimpleRateDTO> getAllRates(String currency) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/rates?currency="+currency);

		// do fetch and map result
		final List<SimpleRateDTO> allRates = spec.retrieve().toEntityList(SimpleRateDTO.class).block().getBody();


		return allRates;
	}

	public List<SimpleRateDTO> getRateForAllCurrencies(String coinId) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/rates?coinId="+coinId);

		// do fetch and map result
		final List<SimpleRateDTO> allCurrencies = spec.retrieve().toEntityList(SimpleRateDTO.class).block().getBody();


		return allCurrencies;
	}

	public List<CoinDTO> getCoins() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/coins");

		// do fetch and map result
		final List<CoinDTO> coins = spec.retrieve().toEntityList(CoinDTO.class).block().getBody();


		return coins;
	}

	public List<CurrencyDTO> getCurrencies() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/currencies");

		// do fetch and map result
		final List<CurrencyDTO> currencies = spec.retrieve().toEntityList(CurrencyDTO.class).block().getBody();


		return currencies;
	}



}
