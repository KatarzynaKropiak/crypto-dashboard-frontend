package com.crypto.cryptodashboardfrontend.ui;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.crypto.cryptodashboardfrontend.data.ArticleDTO;
import com.crypto.cryptodashboardfrontend.data.CoinDTO;
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
import com.vaadin.flow.data.renderer.ClickableRenderer.ItemClickListener;

@PageTitle("News")
@Route(value = "news", layout = MainLayout.class)
public class NewsView extends Main {

	public NewsView(@Autowired NewsService service, @Autowired CoinRatesService coinService) {

		final Grid<ArticleDTO> newsGrid = new Grid<ArticleDTO>(ArticleDTO.class);

		ComponentEventListener<ItemClickEvent<ArticleDTO>> listener;
		listener = new ComponentEventListener<ItemClickEvent<ArticleDTO>>() {
			@Override
			public void onComponentEvent(ItemClickEvent<ArticleDTO> ice){
				getUI().ifPresent(ui -> ui.getPage().open(ice.getItem().geturl()));
			}
		};
		newsGrid.addItemClickListener(listener);

		final Select<CoinDTO> coinSelect = new Select<CoinDTO>();
		coinSelect.setItemLabelGenerator(CoinDTO::getName);
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
