package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DialogValueChangeDetailsController {
    @FXML
    private TextField valueTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private ComboBox attributeComboBox;
    private Stage dialogStage;
    private Controller mainController;

    @FXML
    private void initialize() {
        attributeComboBox.getItems().removeAll(attributeComboBox.getItems());
        attributeComboBox.getItems().addAll("Username", "Email");
    }

    @FXML
    private void handleOk() {
        if(isInputValid())
        {
            if(mainController.getRepository().getAccount(usernameTextField.getText()) != null)
            {
                mainController.getRepository().changeUserInfo(usernameTextField.getText(), attributeComboBox.getValue().toString(), valueTextField.getText());
                dialogStage.close();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Error");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Account with that username does not exist!");
                alert.showAndWait();
            }
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";


        if (usernameTextField.getText() == null || usernameTextField.getText().length() == 0) {
            errorMessage += "Username field is incorrect or empty!\n\n";
        }

        try {
            attributeComboBox.getValue().toString();
        }
        catch (Exception exception)
        {
            errorMessage += "Attribute field is incorrect or empty!\n\n";
        }

        if (valueTextField.getText() == null || valueTextField.getText().length() == 0) {
            errorMessage += "Value field  is incorrect or empty!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Error");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
