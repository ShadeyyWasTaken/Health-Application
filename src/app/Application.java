package app;

import controller.Controller;


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
