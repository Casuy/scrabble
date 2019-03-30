package client;

import javafx.application.Application;

public class App extends View {

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        System.setProperty("prism.subpixeltext", "true");
        Application.launch();
    }

}
