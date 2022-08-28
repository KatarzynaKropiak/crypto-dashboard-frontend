package com.crypto.cryptodashboardfrontend.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsDto {

	private String message;
	private List<ArticleDto> news;



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
//		return (message == ((NewsDto) obj).message) && (news == ((NewsDto) obj).news);
//	}
}
