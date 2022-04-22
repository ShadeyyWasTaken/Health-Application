package app;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;


public class HealthApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Health Application");
        Controller controller = new Controller(primaryStage);
        controller.initRootLayout();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
