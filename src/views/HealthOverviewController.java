package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.AccountAttributes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HealthOverviewController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label bmiLabel;
    @FXML
    private Label restingHeartRateLabel;
    @FXML
    private Label bloodPressureLabel;
    @FXML
    private Label heartRateLabel;
    @FXML
    private Label currentWaterLabel;
    @FXML
    private Label waterGoalLabel;
    @FXML
    private Label todaySleepLabel;
    @FXML
    private Label goalSleepLabel;
    private Controller mainController;

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
        if (mainController.getAccount().getUserRole().equals("administrator"))
        {
            mainController.settingsAdminForm();
        }

        else
        {
            mainController.settingsUserForm();
        }
    }



    @FXML
    public void handleExport()
    {
        List<AccountAttributes> attributesList = mainController.getRepository().getAccountAttributes(mainController.getAccount().getUsername());
        String transactionFile = System.getProperty("user.dir") +"\\" + "report.csv";

        try {
            File myFile = new File(transactionFile);

            if(myFile.exists()){
                myFile.delete();
            }
            else if (myFile.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myFile = new File(transactionFile);
            FileWriter myWriter = new FileWriter(myFile.getName(), true);
            for (int i=0;i<attributesList.size();i++) {
                if(i==0) {
                    myWriter.write(attributesList.get(0).CSVFormat());
                }
                else {
                    myWriter.write(attributesList.get(0).CSVFormat() + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setInformation() {
        nameLabel.setText(mainController.getAccount().getUsername());
        setLabel(restingHeartRateLabel,Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getRestingHeartRate()));
        setLabel(bloodPressureLabel, Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getBloodPressure()));
        setLabel(heartRateLabel, Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getHeartRate()));
        setLabel(currentWaterLabel, Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getWaterIntake()));
        setLabel(waterGoalLabel, Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getWaterGoal()));
        setLabel(todaySleepLabel, Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getSleepTime()));
        setLabel(goalSleepLabel, Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getSleepGoal()));


        if(!checkAttributeNull(Double.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getWeight()))
        && !checkAttributeNull(Integer.toString(mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getHeight())))
        {
            double height = (double)mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getHeight() / 100;
            height = Math.round(Math.pow(height, 2) * 100.0) / 100.0;
            double bmi = mainController.getAccount().getAttributes().get(mainController.getAccount().getAttributes().size()-1).getWeight() / height;
            bmi =  Math.round(bmi * 10.0) / 10.0;
            bmiLabel.setText(Double.toString(bmi));
        }
        else
        {
            bmiLabel.setText("N/A");
        }
    }

    private boolean checkAttributeNull(String attribute)
    {
        return attribute.equalsIgnoreCase("0");
    }

    private void setLabel(Label label, String attribute)
    {
        if (checkAttributeNull(attribute))
        {
            label.setText("N/A");
        }
        else
        {
            label.setText(attribute);
        }
    }
}
