package com.axa.testautomation.api.as400.pages;

import com.axa.testautomation.api.as400.components.TerminalDriver;

public class Command_Entry extends BaseScreen {
    public Command_Entry(TerminalDriver terminalDriver) {
        super(terminalDriver);
    }

    private final int[] coord_command = new int[]{18, 17};


    public void input_Command(String value) throws Exception {
        terminalDriver.setCursor(coord_command).sendKeys(value);
    }

}
