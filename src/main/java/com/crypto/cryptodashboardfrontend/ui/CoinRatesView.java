package com.crypto.cryptodashboardfrontend.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.crypto.cryptodashboardfrontend.data.SimpleRateDTO;
import com.crypto.cryptodashboardfrontend.data.CoinDTO;
import com.crypto.cryptodashboardfrontend.data.CurrencyDTO;
import com.crypto.cryptodashboardfrontend.data.CoinRatesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Coin Rates")
@Route(value = "coin-rates", layout = MainLayout.class)
public class CoinRatesView extends Main {

	public CoinRatesView(@Autowired CoinRatesService service) {

		final Grid<SimpleRateDTO> simpleRateGrid = new Grid<SimpleRateDTO>(SimpleRateDTO.class);
		// final TextField coin = new TextField("coinId");
		// final TextField currency = new TextField("currency");

		final Select<CoinDTO> coinSelect = new Select<CoinDTO>();
		coinSelect.setItemLabelGenerator(CoinDTO::getName);
		coinSelect.setItems(service.getCoins());

		final Select<CurrencyDTO> currencySelect = new Select<CurrencyDTO>();
		currencySelect.setItemLabelGenerator(CurrencyDTO::getName);
		currencySelect.setItems(service.getCurrencies());

		// final Button fetchSimpleRate = new Button("Fetch a rate",
		// 		e -> simpleRateGrid.setItems(service.getSimpleRate(coin.getValue(), currency.getValue())));
		final Button fetchSimpleRate = new Button("Fetch a rate",
					e -> simpleRateGrid.setItems(service.getSimpleRate(coinSelect.getValue().getId(), currencySelect.getValue().getId())));
		fetchSimpleRate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button fetchAllRates = new Button("Fetch all rates for a currency",
				e -> simpleRateGrid.setItems(service.getAllRates(currencySelect.getValue().getId())));
		fetchAllRates.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button fetchAllCurrencies = new Button("Fetch a rate for all currencies",
				e -> simpleRateGrid.setItems(service.getRateForAllCurrencies(coinSelect.getValue().getId())));
				fetchAllCurrencies.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		add(coinSelect, currencySelect, fetchSimpleRate, fetchAllRates, fetchAllCurrencies, simpleRateGrid);

	}

}
