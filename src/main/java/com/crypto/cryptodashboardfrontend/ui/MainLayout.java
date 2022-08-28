package com.crypto.cryptodashboardfrontend.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout implements AfterNavigationObserver {

	private final H1 pageTitle;
	private final RouterLink home;
	private final RouterLink coinRates;
	private final RouterLink wallets;
	private final RouterLink news;
	private final RouterLink assets;

	public MainLayout() {
		// Navigation
		home = new RouterLink("Home", HomeView.class);
		coinRates = new RouterLink("Coin Rates", CoinRatesView.class);
		wallets = new RouterLink("Wallets", WalletView.class);
		news = new RouterLink("News", NewsView.class);
		assets = new RouterLink("Assets", AssetView.class);

		final UnorderedList list = new UnorderedList(new ListItem(home), new ListItem(coinRates), new ListItem(wallets),
				new ListItem(news), new ListItem(assets));
		final Nav navigation = new Nav(list);
		addToDrawer(navigation);
		setPrimarySection(Section.DRAWER);
		setDrawerOpened(false);

		// Header
		pageTitle = new H1("Home");
		final Header header = new Header(new DrawerToggle(), pageTitle);
		addToNavbar(header);
	}

	private RouterLink[] getRouterLinks() {
		return new RouterLink[] { home, coinRates, wallets, news, assets };
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		for (final RouterLink routerLink : getRouterLinks()) {
			if (routerLink.getHighlightCondition().shouldHighlight(routerLink, event)) {
				pageTitle.setText(routerLink.getText());
			}
		}
	}
}
