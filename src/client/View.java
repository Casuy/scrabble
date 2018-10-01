package client;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import netscape.javascript.JSObject;

public class View extends Application {

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        Scene scene = new Scene(webView, 800, 600);

        stage.setScene(scene);
        stage.setMinHeight(580);
        stage.setMinWidth(800);
        stage.setMaxHeight(580);
        stage.setMaxWidth(800);
        stage.setHeight(580);
        stage.setWidth(800);

        webEngine.setJavaScriptEnabled(true);

        webEngine.load("http://localhost:4200");
//        webEngine.load(this.getClass().getResource("/client/ui/index.html").toExternalForm());

        webEngine.getLoadWorker().stateProperty().addListener(
                (observable, oldState, newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        Client.getAgent().bindEngine(webEngine);
                        JSObject window = (JSObject) webEngine.executeScript("window");
                        window.setMember("casuyagent", Client.getInstance());
                    }
                }
        );
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    ServerService.getInstance().logout();
                } catch (Exception ignore) {

                }
                System.exit(0);
            }
        });
        stage.show();
    }

}
