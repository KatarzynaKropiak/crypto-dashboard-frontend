package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.data.provider.DataProvider;

@SuppressWarnings("serial")
@Service
public class NewsService implements Serializable {

	@Value("${server.port}")
	private String serverPort;

	public List<ArticleDTO> getAllNews() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/news");

		final List<NewsDTO> allNews = spec.retrieve().toEntityList(NewsDTO.class).block().getBody();
		final List<ArticleDTO> allArticles = allNews.get(0).getNews();
		
		return allArticles;
	}

	public List<ArticleDTO> getCoinNews(String coinId) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/news?coinId="+coinId);

		final List<NewsDTO> coinNews = spec.retrieve().toEntityList(NewsDTO.class).block().getBody();
		final List<ArticleDTO> coinArticles = coinNews.get(0).getNews();


		return coinArticles;
	}

}
