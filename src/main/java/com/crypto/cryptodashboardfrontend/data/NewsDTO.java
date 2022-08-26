package com.crypto.cryptodashboardfrontend.data;

import java.util.List;

public class NewsDTO {

	private String message;
	private List<ArticleDTO> news;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ArticleDTO> getNews() {
		return news;
	}

	public void setNews(List<ArticleDTO> news) {
		this.news = news;
	}


	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ArticleDTO)) {
			return false;
		}

		return (message == ((NewsDTO) obj).message) && (news == ((NewsDTO) obj).news);
	}
}
