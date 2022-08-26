package com.crypto.cryptodashboardfrontend.data;

public class ArticleDTO {

	private String title;
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
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

		return (title == ((ArticleDTO) obj).title) && (url == ((ArticleDTO) obj).url);
	}
}
