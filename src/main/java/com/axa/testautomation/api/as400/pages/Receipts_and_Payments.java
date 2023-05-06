package com.axa.testautomation.api.as400.pages;

import com.axa.testautomation.api.as400.components.TerminalDriver;
import org.junit.Assert;

public class Receipts_and_Payments extends BaseScreen {
    public Receipts_and_Payments(TerminalDriver terminalDriver) {
        super(terminalDriver);
    }

    private final int[] coord_Receipts_SG = new int[]{9, 13};
    private final int[] coord_Receipts_MY = new int[]{9, 13};

    public void select_Receipts(String entity) throws Exception {
        int[] coords = {0,0};
        switch (entity.toUpperCase()){
            case "SG": coords = coord_Receipts_SG; break;
            case "MY": coords = coord_Receipts_MY; break;
        }
        terminalDriver.setCursor(coords).sendEnter();
    }

}
