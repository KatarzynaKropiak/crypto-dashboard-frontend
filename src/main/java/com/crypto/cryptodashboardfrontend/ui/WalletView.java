package com.crypto.cryptodashboardfrontend.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.crypto.cryptodashboardfrontend.data.AssetDto;
import com.crypto.cryptodashboardfrontend.data.WalletDto;
import com.crypto.cryptodashboardfrontend.data.WalletService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Wallet")
@Route(value = "wallet", layout = MainLayout.class)
public class WalletView extends Main {

	public WalletView(@Autowired WalletService service) {

		final Grid<WalletDto> walletsGrid = new Grid<WalletDto>(WalletDto.class);
		final TextField userName = new TextField("User Name");
		final TextField email = new TextField("Email");

		final Select<WalletDto> walletSelect = new Select<WalletDto>();
		walletSelect.setItemLabelGenerator(WalletDto::getWalletId);
		walletSelect.setItems(service.getAllWallets());

		final Button addWallet = new Button("Add a new wallet",
				e -> {service.addWallet(userName.getValue(), email.getValue());
					walletSelect.setItems(service.getAllWallets());});
		addWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button fetchAllWallets = new Button("Fetch all wallets",
				e -> walletsGrid.setItems(service.getAllWallets()));
		fetchAllWallets.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Grid<AssetDto> assetsGrid = new Grid<AssetDto>(AssetDto.class);

		final Button fetchWallet = new Button("Fetch wallet's assets",
				e -> assetsGrid.setItems(service.getWalletAssets(walletSelect.getValue().getWalletId())));
		fetchWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button removeWallet = new Button("Remove a wallet",
				e -> {
					service.deleteWallet(walletSelect.getValue().getWalletId());
					walletSelect.setItems(service.getAllWallets());
				});
		removeWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		add(userName, email, addWallet, fetchAllWallets, walletsGrid, walletSelect, fetchWallet, removeWallet, assetsGrid);
	}

}
