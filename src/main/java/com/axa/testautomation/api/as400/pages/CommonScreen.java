package com.axa.testautomation.api.as400.pages;

import com.axa.testautomation.api.as400.components.TerminalDriver;
import org.junit.Assert;

public class CommonScreen extends BaseScreen {
    public CommonScreen(TerminalDriver terminalDriver) {
        super(terminalDriver);
    }

    public void validateScreenTitle(String title) {
        Assert.assertTrue(terminalDriver.getScreenContent().getLine(0).contains(title));

    }

    public void sendkey(String keys) throws Exception {
        switch (keys) {
            case "Enter":
                terminalDriver.sendEnter();
                break;
            case "F3":
                terminalDriver.sendFunctionKey(3);
                break;
            case "F12":
                terminalDriver.sendFunctionKey(12);
                break;
            default:
                throw new Exception(keys + " " + "not found in not valid choice! ");
        }
    }

    public void validateTextInScreenLine(String text, int line) {
        Assert.assertTrue(terminalDriver.getScreenContent().getLine(line).contains(text));
    }


}
