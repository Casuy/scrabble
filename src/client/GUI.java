package client;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {
        WebView webview = new WebView();
        WebEngine engine = webview.getEngine();
        Scene scene = new Scene(webview, 800, 600);
        stage.setScene(scene);
        stage.setMinHeight(580);
        stage.setMinWidth(800);
        stage.setMaxHeight(580);
        stage.setMaxWidth(800);
        stage.setHeight(580);
        stage.setWidth(800);
        engine.setJavaScriptEnabled(true);

//        engine.load("https://www.google.com.au");
        engine.load("http://localhost:4200");
//        engine.load(this.getClass().getResource("./ui/index.html").toExternalForm());
        engine.getLoadWorker().stateProperty().addListener((ov, oldState, newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        Client.getAgent().bindEngine(engine);
                        JSObject win = (JSObject) engine.executeScript("window");
                        win.setMember("casuyagent", Client.getInstance());
                    }
                }
        );
        stage.show();
    }
}