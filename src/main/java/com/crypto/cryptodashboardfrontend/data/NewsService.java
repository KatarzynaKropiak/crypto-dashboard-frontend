package com.crypto.cryptodashboardfrontend.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

@SuppressWarnings("serial")
@Service
public class NewsService implements Serializable {

	@Value("${server.port}")
	private String serverPort;

	public List<ArticleDto> getAllNews() {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/news");

		final List<NewsDto> allNews = spec.retrieve().toEntityList(NewsDto.class).block().getBody();
		final List<ArticleDto> allArticles = allNews.get(0).getNews();
		
		return allArticles;
	}

	public List<ArticleDto> getCoinNews(String coinId) {

		final RequestHeadersSpec<?> spec = WebClient.create().get()
				.uri("http://localhost:8080/v1/crypto/news?coinId=" + coinId);

		final List<NewsDto> coinNews = spec.retrieve().toEntityList(NewsDto.class).block().getBody();
		final List<ArticleDto> coinArticles = coinNews.get(0).getNews();


		return coinArticles;
	}

}
