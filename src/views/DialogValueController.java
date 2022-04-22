package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class DialogValueController {
    @FXML
    private TextField valueTextField;
    private Stage dialogStage;
    private Controller mainController;
    private String attribute;

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            if(attribute.equalsIgnoreCase("userrole"))
            {
                if (mainController.getRepository().getAccount(valueTextField.getText()) != null)
                {
                    mainController.getRepository().makeAdministrator(valueTextField.getText());
                    dialogStage.close();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("An account with that username does not exist");
                    alert.showAndWait();
                }

            }
            else
            {
                mainController.getRepository().changeUserInfo(mainController.getAccount().getUsername(), attribute, valueTextField.getText());
                if(attribute.equalsIgnoreCase("username"))
                {
                    mainController.setAccount(mainController.getRepository().getAccount(valueTextField.getText()));
                }
                dialogStage.close();
            }
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (valueTextField.getText() == null || valueTextField.getText().length() == 0) {
            errorMessage += "Value field is incorrect or empty!\n";
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

    public void setAttribute(String attribute)
    {
        this.attribute = attribute;
    }
}
