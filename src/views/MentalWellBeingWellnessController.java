package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MentalWellBeingWellnessController {
    @FXML
    private Label nameLabel;
    private Controller mainController;

    @FXML
    public void handleHealthOverview()
    {
        mainController.healthOverviewForm();
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
    public void handleHotlines()
    {
        mainController.mentalWellBeingHotlinesForm();
    }

    @FXML
    public void handleWellnessDiary()
    {
        mainController.mentalWellBeingWellNessDiaryForm();
    }

    @FXML
    public void handleSettings()
    {
        if (mainController.getAccount().getUserRole().equals("administrator"))
        {
            mainController.settingsAdminForm();
        }

        else
        {
            mainController.settingsUserForm();
        }
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setInformation() {
        nameLabel.setText(mainController.getAccount().getUsername());
    }
}
