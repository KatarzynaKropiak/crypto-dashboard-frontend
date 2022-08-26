package com.crypto.cryptodashboardfrontend.ui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Crypto Dashboards")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

	public HomeView() {
		add(new Section(new Paragraph(
				"Welcome to the crypto dashboard app!"),
				new Span("The sources for this application can be found "),
				new Anchor("https://github.com/KatarzynaKropiak/crypto-dashboard-frontend", "here.")));

		add(new Section(
				new H2(new RouterLink("Coin Rates", CoinRatesView.class)),
				new Paragraph(
						"Click above to get current rates of coins")));

		add(new Section(
			new H2(new RouterLink("Wallets", WalletView.class)),
			new Paragraph(
					"Click above to see and modifiy coin wallets")));

		add(new Section(
			new H2(new RouterLink("News", NewsView.class)),
			new Paragraph(
					"Click above to see the News")));


	}
}
