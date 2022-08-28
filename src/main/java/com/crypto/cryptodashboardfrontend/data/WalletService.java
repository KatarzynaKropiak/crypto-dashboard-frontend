package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

@SuppressWarnings("serial")
@Service
public class WalletService implements Serializable {

	@Value("${server.port}")
	private String serverPort;
	private String baseUri = "http://localhost:8080/v1/crypto";

	public List<WalletDto> getAllWallets() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri(baseUri + "/wallets");

		final List<WalletDto> wallets = spec.retrieve().toEntityList(WalletDto.class).block().getBody();

		return wallets;
	}

	public List<AssetDto> getWalletAssets(String walletId) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri(baseUri + "/wallets/" + walletId + "/assets");

		final List<AssetDto> walletAssets = spec.retrieve().toEntityList(AssetDto.class).block().getBody();

		return walletAssets;
	}

	public void addWallet(String userName, String email) {

		WebClient webClient = WebClient.builder()
        .baseUrl(baseUri)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();

		WalletDto walletRequest = new WalletDto();
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
