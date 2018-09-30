package client;

import javafx.application.Application;

import java.util.logging.Logger;

public class App extends GUI {

    static Logger log = Logger.getLogger("App log");

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        System.setProperty("prism.subpixeltext", "true");
        Application.launch();
    }
}
