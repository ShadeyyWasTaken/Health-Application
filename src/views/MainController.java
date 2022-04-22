package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label nameLabel;
    private Controller mainController;

    @FXML
    public void handleHealthOverview()
    {

    }

    @FXML
    public void handleHealthActivities()
    {

    }

    @FXML
    public void handleMentalWellbeing()
    {
        mainController.mentalWellBeingForm();
    }

    @FXML
    public void handleSettings()
    {

    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setInformation() {
        nameLabel.setText(mainController.getAccount().getUsername());
    }
}
