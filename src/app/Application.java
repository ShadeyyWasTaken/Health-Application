package app;

import controller.Controller;

import static javafx.application.Application.launch;

public class Application {
    /**
     * Launches the JavaFX application

    public static void main(final String[] args) {
        launch(args);
    }
     */

    public static void main(final String[] args){
        run();

    }

    private static void run()
    {
        final Controller controller = new Controller();
        controller.run();
    }
}
