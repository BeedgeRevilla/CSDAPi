package com.axa.testautomation.api.as400.pages;

import com.axa.testautomation.api.as400.components.TerminalDriver;

import java.util.List;


public class BaseScreen {

    protected String clientNumber;

    protected TerminalDriver terminalDriver;

    public BaseScreen(TerminalDriver terminalDriver) {
        this.terminalDriver = terminalDriver;
    }

    public void pressEnter() {
        terminalDriver.sendEnter();
    }

    public boolean isConnected() {
        return terminalDriver.isConnected();
    }

    public List<String> getScreen() {
        return terminalDriver.getScreenContent().getLines();
    }

    public void disconnect() {
        terminalDriver.disconnect();
    }

}
