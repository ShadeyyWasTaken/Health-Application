package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class MentalWellBeingController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label todayDateField;
    private Controller mainController;

    @FXML
    public void handleHealthOverview()
    {
        mainController.initRootLayout();
    }

    @FXML
    public void handleHealthActivities()
    {

    }

    @FXML
    public void handleSettings()
    {

    }

    @FXML
    public void handleHotlines()
    {
        mainController.mentalWellBeingHotlinesForm();
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
    public void handleHappyEmoji()
    {
        changeMood("Happy");
    }

    @FXML
    public void handleGoodEmoji()
    {
        changeMood("Good");
    }

    @FXML
    public void handleNeutralEmoji()
    {
        changeMood("Neutral");
    }

    @FXML
    public void handleStressedEmoji()
    {
        changeMood("Stressed");
    }

    @FXML
    public void handleSadEmoji()
    {
        changeMood("Sad");
    }

    @FXML
    public void handleCalmLevel()
    {
        changeStressLevel("Calm");
    }

    @FXML
    public void handleModerateLevel()
    {
        changeStressLevel("Moderate");
    }

    @FXML
    public void handleStressedLevel()
    {
        changeStressLevel("Stressed");
    }

    private void changeMood(String mood)
    {
        mainController.getRepository().changeAttribute(mainController.getAccount().getUsername(), "MOOD", mood, mainController.getToday());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Successfully changed mood to " + "'" + mood + "'" + "!");
        alert.showAndWait();
    }

    private void changeStressLevel(String stressLevel)
    {
        mainController.getRepository().changeAttribute(mainController.getAccount().getUsername(), "STRESS_LEVEL", stressLevel, mainController.getToday());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Successfully changed stress level to " +  "'" + stressLevel + "'" + "!");
        alert.showAndWait();
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setInformation() {
        nameLabel.setText(mainController.getAccount().getUsername());
        todayDateField.setText(mainController.getToday());
    }
}
