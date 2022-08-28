package com.crypto.cryptodashboardfrontend.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.crypto.cryptodashboardfrontend.data.ArticleDto;
import com.crypto.cryptodashboardfrontend.data.CoinDto;
import com.crypto.cryptodashboardfrontend.data.NewsService;
import com.crypto.cryptodashboardfrontend.data.CoinRatesService;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("News")
@Route(value = "news", layout = MainLayout.class)
public class NewsView extends Main {

	public NewsView(@Autowired NewsService service, @Autowired CoinRatesService coinService) {

		final Grid<ArticleDto> newsGrid = new Grid<ArticleDto>(ArticleDto.class);

		ComponentEventListener<ItemClickEvent<ArticleDto>> listener;
		listener = new ComponentEventListener<ItemClickEvent<ArticleDto>>() {
			@Override
			public void onComponentEvent(ItemClickEvent<ArticleDto> ice){
				getUI().ifPresent(ui -> ui.getPage().open(ice.getItem().getUrl()));
			}
		};
		newsGrid.addItemClickListener(listener);

		final Select<CoinDto> coinSelect = new Select<CoinDto>();
		coinSelect.setItemLabelGenerator(CoinDto::getName);
		coinSelect.setItems(coinService.getCoins());

		final Button fetchAllNews = new Button("Fetch all news",
					e -> newsGrid.setItems(service.getAllNews()));
		fetchAllNews.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button fetchCoinNews = new Button("Fetch coin news",
					e -> newsGrid.setItems(service.getCoinNews(coinSelect.getValue().getId())));
		fetchCoinNews.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		add(fetchAllNews, coinSelect, fetchCoinNews, newsGrid);

	}

}
