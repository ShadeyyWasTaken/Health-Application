package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;
import repositories.Repository;

import java.awt.*;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private Controller mainController;

    @FXML
    private void initialize() {
    }


    @FXML
    private void handleLogin() {
        if (isInputValid())
        {
            Account account = mainController.getRepository().login(usernameField.getText(), passwordField.getText());

            if(account != null )
            {
                mainController.setAccount(account);
                mainController.mainForm();
            }

            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Try again!");
                alert.setHeaderText("Incorrect password or username!");
                alert.setContentText("Incorrect password or username!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleRegister() {
        mainController.registerForm();
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (usernameField.getText() == null || usernameField.getText().length() == 0) {
            errorMessage += "The username field is empty!\n\n";
        }

        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "The password field is empty!\n";
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
