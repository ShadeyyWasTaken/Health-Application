package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class SettingsUserController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label settingsNameLabel;
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
    public void handleMentalWellbeing()
    {
        mainController.mentalWellBeingForm();
    }


    @FXML
    public void handleUsername()
    {
        mainController.changeAccountInfoForm("username");
        setInformation();
    }

    @FXML
    public void handleEmail()
    {
        mainController.changeAccountInfoForm("email");
    }

    @FXML
    public void handleExit()
    {
        mainController.initRootLayout();
    }


    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setInformation() {
        nameLabel.setText(mainController.getAccount().getUsername());
        settingsNameLabel.setText(mainController.getAccount().getUsername());
    }
}
