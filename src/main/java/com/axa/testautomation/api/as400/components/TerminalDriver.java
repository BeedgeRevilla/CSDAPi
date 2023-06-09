package com.axa.testautomation.api.as400.components;

import org.apache.log4j.Logger;
import org.tn5250j.Session5250;
import org.tn5250j.TN5250jConstants;
import org.tn5250j.event.ScreenOIAListener;
import org.tn5250j.event.SessionChangeEvent;
import org.tn5250j.event.SessionListener;
import org.tn5250j.framework.common.SessionManager;
import org.tn5250j.framework.tn5250.Screen5250;
import org.tn5250j.framework.tn5250.ScreenField;
import org.tn5250j.framework.tn5250.ScreenOIA;

import java.util.Properties;


public class TerminalDriver {

    Logger LOG = Logger.getLogger(TerminalDriver.class);

    private final Properties properties;
    private Session5250 session;
    private boolean connected;
    private boolean informed;
    private int informChange;
    private Screen5250 screen;

    public TerminalDriver(String host, String port) {
        properties = new Properties();
        properties.put(TN5250jConstants.SESSION_HOST, host);
        properties.put(TN5250jConstants.SESSION_HOST_PORT, port);
        properties.put(TN5250jConstants.SESSION_CODE_PAGE, "37");
    }

    public TerminalDriver connect() throws InterruptedException {
        createSession();
        session.connect();
        int retries = 100;
        while (!connected) {
            Thread.sleep(100);
            if(retries == 0) {
                break;
            }
            retries--;
        }
        if(retries==0) return null;

        screen = session.getScreen();
        addOperatorInformationAreaListener();
        return this;
    }

    public TerminalDriver setCursor(int[] coordinates) {
        screen.setCursor(coordinates[0], coordinates[1]);
        return this;
    }

    public void disconnect() {
        session.disconnect();
    }

    private void createSession() {
        if(SessionManager.instance().getSessions().getCount() == 0) {
            session = SessionManager.instance().openSession(properties, null, null);
            session.addSessionListener(new SessionListener() {
                @Override
                public void onSessionChanged(SessionChangeEvent changeEvent) {
                    connected = changeEvent.getState() == TN5250jConstants.STATE_CONNECTED;
                }
            });
        }
        else {
            SessionManager.instance().getSessions().getSessionsList().get(0).connect();
        }
    }


    private void addOperatorInformationAreaListener() {
        session.getScreen().getOIA().addOIAListener(new ScreenOIAListener() {
            @Override
            public void onOIAChanged(ScreenOIA oia, int change) {
                LOG.debug(String.format("OIA %d", change));
                informed = informed | informChange == change;
            }
        });
    }

    public void waitForUnlock() {
        int retries = 100;

        informed = false;
        informChange = ScreenOIAListener.OIA_CHANGED_KEYBOARD_LOCKED;
        while (!informed) {
            Thread.yield();
            if(retries == 0){
                break;
            }
            retries --;
        }

        dumpScreen();
        if(retries==0){
            assert(true);
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public TerminalDriver sendKeys(String keys) {
        screen.sendKeys(keys);
        return this;
    }

    public TerminalDriver fillCurrentField(String text) {
        ScreenField currentField = screen.getScreenFields().getCurrentField();
        LOG.info(String.format("cursor: %d %d", currentField.startRow(), currentField.startCol()));
        currentField.setString(text);
        return this;
    }

    public TerminalDriver select(String label, String text) {
        ScreenContent content = getScreenContent();
        int index = content.indexOf(label);
        ScreenField field = null;
        while (field == null && index > 0) {
            field = screen.getScreenFields().findByPosition(index--);
        }
        if (field == null) {
            throw new IllegalStateException(String.format("Could not find field *before* label %s"));
        }
        field.setString(text);
        return this;
    }

    public TerminalDriver fillFieldWith(String label, String text) {
        ScreenContent content = getScreenContent();
        int index = content.indexOf(label);
        ScreenField field = null;
        while (field == null && index < content.length()) {
            field = screen.getScreenFields().findByPosition(index++);
        }
        if (field == null) {
            throw new IllegalStateException(String.format("Could not find field *after* label %s"));
        }
        field.setString(text);
        return this;
    }

    public void dumpScreen() {
        getScreenContent().dumpScreen();
    }

    public void assertScreen(String name) {
        assert getScreenContent().getLine(0).contains(name) : String.format("Screen is not '%s'", name);
    }

    public ScreenContent getScreenContent() {
        return new ScreenContent(session);
    }

    public void sendCommand(String command) {
        fillFieldWith("===>", command).sendEnter();
    }

    public TerminalDriver sendEnter() {
        sendKeys("[enter]").waitForUnlock();
        return this;
    }

    public String lastReportLine()  {
        ScreenContent content = getScreenContent();
        fillFieldWith("Position to line", "B").sendEnter();
        return content.getLine(content.lineOf("********  End of report  ********") - 1);
    }

    public TerminalDriver sendBack()  {
        sendKeys("[pf1]").waitForUnlock();
        getScreenContent().getLines();
        return this;
    }

    public TerminalDriver sendFunctionKey(int key) {
        sendKeys("[pf" + key + "]").waitForUnlock();
        return this;
    }

}