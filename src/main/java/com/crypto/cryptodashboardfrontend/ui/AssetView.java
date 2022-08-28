package com.crypto.cryptodashboardfrontend.ui;

import com.crypto.cryptodashboardfrontend.data.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;

@PageTitle("Assets")
@Route(value = "assets", layout = MainLayout.class)
public class AssetView extends Main {

    public AssetView(@Autowired AssetService service, @Autowired WalletService walletService, @Autowired CoinRatesService coinService) {

        final Grid<AssetDto> assetsGrid = new Grid<AssetDto>(AssetDto.class);


        final Select<WalletDto> walletSelect = new Select<WalletDto>();
        walletSelect.setItemLabelGenerator(WalletDto::getWalletId);
        walletSelect.setItems(walletService.getAllWallets());


        final Button fetchWallet = new Button("Fetch wallet's assets",
                e -> assetsGrid.setItems(walletService.getWalletAssets(walletSelect.getValue().getWalletId())));
        fetchWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        final TextField coinValue = new TextField("quantity");

        final Select<CoinDto> coinSelect = new Select<CoinDto>();
        coinSelect.setItemLabelGenerator(CoinDto::getName);
        coinSelect.setItems(coinService.getCoins());


        final Button addAsset = new Button("Add the asset",
                e -> {
                    service.addAsset(walletSelect.getValue().getWalletId(), coinSelect.getValue().getId(), new BigDecimal(coinValue.getValue()), null, null);
                    assetsGrid.setItems(walletService.getWalletAssets(walletSelect.getValue().getWalletId()));
                });
        addAsset.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

//
//        final Button removeWallet = new Button("Remove a wallet",
//                e -> {
//                    service.deleteWallet(walletSelect.getValue().getWalletId());
//                    walletSelect.setItems(service.getAllWallets());
//                });
//        removeWallet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(walletSelect, fetchWallet, coinSelect, coinValue, addAsset, assetsGrid);
    }

}
