package views;

import controller.Controller;
import helpers.ValidationHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Account;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterOptionalController {

    @FXML
    private TextField ageField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private ComboBox genderField;
    private Controller mainController;

    @FXML
    private void initialize() {
        genderField.getItems().removeAll(genderField.getItems());
        genderField.getItems().addAll("Male", "Female", "N/A");
    }

    @FXML
    private void handleRegister()
    {
        if (isInputValid())
        {
            String date = mainController.getToday();
            String age = ageField.getText();
            String height = heightField.getText();
            String weight = weightField.getText();
            String gender = genderField.getValue().toString();

            mainController.getRepository().addActivity(mainController.getAccount().getUsername(), date);
            mainController.getRepository().changeAttribute(mainController.getAccount().getUsername(),"AGE", age, date);
            mainController.getRepository().changeAttribute(mainController.getAccount().getUsername(),"HEIGHT", height, date);
            mainController.getRepository().changeAttribute(mainController.getAccount().getUsername(),"WEIGHT", weight, date);
            mainController.getRepository().changeAttribute(mainController.getAccount().getUsername(),"GENDER", gender, date);
            mainController.setAccount(mainController.getRepository().getAccount(mainController.getAccount().getUsername()));
            mainController.mainForm();
        }
    }


    @FXML
    private void handleSkip() {
        mainController.mainForm();
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (!ValidationHelper.ageChecker(ageField.getText())) {
            errorMessage += "The age value is incorrect!\n\n";
        }

        if (!ValidationHelper.heightChecker(heightField.getText())) {
            errorMessage += "The height value is incorrect!\n\n";
        }

        if (!ValidationHelper.weightChecker(weightField.getText())) {
            errorMessage += "The weight value is incorrect!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Try again!");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }

    }
}
