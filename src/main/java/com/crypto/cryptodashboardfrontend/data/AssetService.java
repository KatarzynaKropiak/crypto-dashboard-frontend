package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class AssetService implements Serializable {

    @Value("${server.port}")
    private String serverPort;
    private String baseUri = "http://localhost:8080/v1/crypto";


    public void addAsset(String walletId, String coinId, BigDecimal coinValue, String currencyId, BigDecimal currencyValue) {

        WebClient webClient = WebClient.builder()
                .baseUrl(baseUri)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        AssetDto assetRequest = new AssetDto();
        assetRequest.setWalletId(walletId);
        assetRequest.setCoinId(coinId);
        assetRequest.setCoinValue(coinValue);
        assetRequest.setCurrencyId(currencyId);
        assetRequest.setCurrencyValue(currencyValue);

        webClient.post()
                .uri("/assets")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(assetRequest))
                .exchange()
                .block();

    }

    public void deleteAsset(String assetId) {

        WebClient.create().delete()
                .uri(baseUri + "/assets/" + assetId)
                .exchange()
                .block();

    }


}
