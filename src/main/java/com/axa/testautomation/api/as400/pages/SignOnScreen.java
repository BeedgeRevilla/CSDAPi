package com.axa.testautomation.api.as400.pages;


import com.axa.testautomation.api.as400.components.TerminalDriver;

public class SignOnScreen extends BaseScreen {

    private final int[] USERNAME_COORDINTES = {6, 53};
    private final int[] PASSWORD_COORDINTES = {7, 53};


    public SignOnScreen(TerminalDriver terminalDriver) {
        super(terminalDriver);
    }


    public void setUsername(String username) {
        terminalDriver.setCursor(USERNAME_COORDINTES);
        terminalDriver.sendKeys(username);
    }

    public void setPassword(String password) {
        terminalDriver.setCursor(PASSWORD_COORDINTES);
        terminalDriver.sendKeys(password);
    }

}
