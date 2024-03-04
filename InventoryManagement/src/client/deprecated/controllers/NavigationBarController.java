package client.deprecated.controllers;

import client.common.controllers.InventoryManagementController;
import client.sales.views.SalesNavigationBarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBarController {
    InventoryManagementController inventoryManagementController;
    SalesNavigationBarView navigationBarView;

    public NavigationBarController(InventoryManagementController inventoryManagementController) {
        this.inventoryManagementController = inventoryManagementController;
        navigationBarView = new SalesNavigationBarView();

        initComponents();
    }

    private void initComponents() {
        initButtons();
    }

    private void initButtons() {
        navigationBarView.getLogobtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                inventoryManagementController.changeScreen();
            }
        });

        navigationBarView.getDashboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryManagementController.changeScreen(inventoryManagementController.getDashboardController().dashboardView.getMainPanel());
            }
        });

        navigationBarView.getStockControlButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        navigationBarView.getCustomerOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: display customer order view instead of finance view
                inventoryManagementController.changeScreen(inventoryManagementController.getFinancesController().financesView.getMainPanel());
            }
        });

        navigationBarView.getProfileButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public SalesNavigationBarView getNavigationBarView() {
        return navigationBarView;
    }
}
