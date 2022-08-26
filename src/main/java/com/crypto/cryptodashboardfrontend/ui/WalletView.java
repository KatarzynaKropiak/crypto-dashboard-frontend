package com.crypto.cryptodashboardfrontend.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.crypto.cryptodashboardfrontend.data.AssetDTO;
import com.crypto.cryptodashboardfrontend.data.SimpleRateDTO;
import com.crypto.cryptodashboardfrontend.data.WalletDTO;
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

		final Grid<WalletDTO> walletsGrid = new Grid<WalletDTO>(WalletDTO.class);
		final TextField userName = new TextField("User Name");
		final TextField email = new TextField("Email");

		final Select<WalletDTO> walletSelect = new Select<WalletDTO>();
		walletSelect.setItemLabelGenerator(WalletDTO::getwalletId);
		walletSelect.setItems(service.getAllWallets());

		final Button addWallet = new Button("Add a new wallet",
				e -> {service.addWallet(userName.getValue(), email.getValue());
					walletSelect.setItems(service.getAllWallets());});
		addWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button fetchAllWallets = new Button("Fetch all wallets",
				e -> walletsGrid.setItems(service.getAllWallets()));
		fetchAllWallets.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Grid<AssetDTO> assetsGrid = new Grid<AssetDTO>(AssetDTO.class);

		final Button fetchWallet = new Button("Fetch wallet's assets",
				e -> assetsGrid.setItems(service.getWalletAssets(walletSelect.getValue().getwalletId())));
		fetchWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		final Button removeWallet = new Button("Remove a wallet",
				e -> {
					service.deleteWallet(walletSelect.getValue().getwalletId());
					walletSelect.setItems(service.getAllWallets());
				});
		removeWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		add(userName, email, addWallet, fetchAllWallets, walletsGrid, walletSelect, fetchWallet, removeWallet, assetsGrid);
	}

}
