package com.crypto.cryptodashboardfrontend.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

	private String title;
	private String url;


//	@Override
//	public int hashCode() {
//		return 42;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || !(obj instanceof ArticleDto)) {
//			return false;
//		}
//
//		return (title == ((ArticleDto) obj).title) && (url == ((ArticleDto) obj).url);
//	}
}
