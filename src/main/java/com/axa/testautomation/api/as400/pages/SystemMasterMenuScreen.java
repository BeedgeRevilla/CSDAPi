package com.axa.testautomation.api.as400.pages;


import com.axa.testautomation.api.as400.components.TerminalDriver;

public class SystemMasterMenuScreen extends BaseScreen {

    public SystemMasterMenuScreen(TerminalDriver terminalDriver) {
        super(terminalDriver);
    }

    private final int[] coord_Receipts_and_Payments_SG = new int[]{7, 10};
    private final int[] coord_Receipts_and_Payments_MY = new int[]{7, 11};

    public void select_ReceiptsandPayments(String entity) throws Exception {
        int[] coords = {0,0};
        switch (entity.toUpperCase()){
            case "SG": coords = coord_Receipts_and_Payments_SG; break;
            case "MY": coords = coord_Receipts_and_Payments_MY; break;
        }
        terminalDriver.setCursor(coords).sendEnter();
    }

}
