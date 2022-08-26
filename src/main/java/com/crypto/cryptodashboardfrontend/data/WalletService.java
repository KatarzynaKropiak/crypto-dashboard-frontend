package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.data.provider.DataProvider;

import reactor.core.publisher.Mono;

@SuppressWarnings("serial")
@Service
public class WalletService implements Serializable {

	@Value("${server.port}")
	private String serverPort;
	private String baseUri = "http://localhost:8080/v1/crypto";

	public List<WalletDTO> getAllWallets() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri(baseUri + "/wallets");

		final List<WalletDTO> wallets = spec.retrieve().toEntityList(WalletDTO.class).block().getBody();

		return wallets;
	}

	public List<AssetDTO> getWalletAssets(String walletId) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri(baseUri + "/wallets/"+walletId+"/assets");

		final List<AssetDTO> walletAssets = spec.retrieve().toEntityList(AssetDTO.class).block().getBody();

		return walletAssets;
	}

	public void addWallet(String userName, String email) {

		WebClient webClient = WebClient.builder()
        .baseUrl(baseUri)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();

		WalletDTO walletRequest = new WalletDTO();
		walletRequest.setUserName(userName);
		walletRequest.setEmail(email);

	  webClient.post()
		.uri("/wallets")
		.contentType(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromValue(walletRequest))
		.exchange()
		.block();

	}

	public void deleteWallet(String walletId) {

		WebClient.create().delete()
		.uri(baseUri + "/wallets/" + walletId)
		.exchange()
		.block();

	}


}
