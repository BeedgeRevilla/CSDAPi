package com.axa.testautomation.api.as400.pages;

import com.axa.testautomation.api.as400.components.TerminalDriver;

public class Cash_Receipt_Submenu extends BaseScreen {
    public Cash_Receipt_Submenu(TerminalDriver terminalDriver) {
        super(terminalDriver);
    }

    private final int[] coord_Bank_Code = new int[]{17, 44};
    private final int[] coord_Receipt_Number = new int[]{18, 44};
    private final int[] coord_Action = new int[]{21, 44};

    public void input_BankCode(String value) throws Exception {
        terminalDriver.setCursor(coord_Bank_Code).sendKeys(value);
        Thread.sleep(1000);
    }

    public void input_ReceiptNumber(String value) throws Exception {
        terminalDriver.setCursor(coord_Receipt_Number).sendKeys(value);
        Thread.sleep(1000);
    }

    public void input_Action(String value) throws Exception {
        terminalDriver.setCursor(coord_Action).sendKeys(value);
        Thread.sleep(1000);
    }



}
