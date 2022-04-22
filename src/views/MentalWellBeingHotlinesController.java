package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MentalWellBeingHotlinesController {
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
    private void handleMentalWellBeing()
    {
        mainController.mentalWellBeingForm();
    }

    @FXML
    public void handleWellness()
    {
        mainController.mentalWellBeingWellNessForm();
    }

    @FXML
    public void handleWellnessDiary()
    {
        mainController.mentalWellBeingWellNessDiaryForm();
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
