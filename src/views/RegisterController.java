package views;

import controller.Controller;
import helpers.ValidationHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;
    private Controller mainController;


    @FXML
    private void handleProceed()
    {
        if (isInputValid())
        {
            mainController.getRepository().register(usernameField.getText(), passwordField.getText(), emailField.getText());
            mainController.setAccount(mainController.getRepository().getAccount(usernameField.getText()));
            mainController.registerOptionalForm();
        }
    }

    @FXML
    private void handleBack()
    {
        mainController.initRootLayout();
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (usernameField.getText() == null || usernameField.getText().length() == 0) {
            errorMessage += "The username field is empty!\n\n";
        }

        if (!ValidationHelper.passwordChecker(passwordField.getText())) {
            errorMessage += "The password should have 1 Capital Letter, 1 Small Letter, 1 Special Symbol, 1 Digit and should be " +
                    "between 6 and 16 characters!!\n\n";
        }

        if (!ValidationHelper.emailChecker(emailField.getText()))
        {
            errorMessage += "Incorrect email address format!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else
        {
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
