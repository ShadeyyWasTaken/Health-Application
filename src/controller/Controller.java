package controller;

import app.HealthApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import repositories.Repository;
import model.Account;

import java.io.IOException;

import views.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    private final Stage primaryStage;
    private AnchorPane rootLayout;
    private final Repository repository;
    private Account account;
    private String today;

    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.repository = new Repository();
        this.account = null;
        Format f = new SimpleDateFormat("dd/MM/yyyy");
        this.today = f.format(new Date());
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Repository getRepository() {
        return repository;
    }

    public String getToday() {
        return today;
    }

    public void changeAccountInfoForm(String attribute)
    {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class.getResource("../views/DialogValue.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Change Details");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            DialogValueController dialogValueController = loader.getController();
            dialogValueController.setDialogStage(dialogStage);
            dialogValueController.setMainController(this);
            dialogValueController.setAttribute(attribute);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeUserInfoForm()
    {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class.getResource("../views/DialogValueChangeDetails.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Change Details");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            DialogValueChangeDetailsController dialogValueChangeDetailsController = loader.getController();
            dialogValueChangeDetailsController.setDialogStage(dialogStage);
            dialogValueChangeDetailsController.setMainController(this);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void settingsAdminForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/SettingsAdmin.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            SettingsAdminController settingsAdminController = loader.getController();
            settingsAdminController.setMainController(this);
            settingsAdminController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void settingsUserForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/SettingsUser.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            SettingsUserController settingsUserController = loader.getController();
            settingsUserController.setMainController(this);
            settingsUserController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void healthOverviewForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/HealthOverview.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            HealthOverviewController healthOverviewController = loader.getController();
            healthOverviewController.setMainController(this);
            healthOverviewController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/Login.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            LoginController loginController = loader.getController();
            loginController.setMainController(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/Register.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RegisterController registerController = loader.getController();
            registerController.setMainController(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerOptionalForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/RegisterOptional.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RegisterOptionalController registerOptionalController = loader.getController();
            registerOptionalController.setMainController(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/Main.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            MainController mainFormController = loader.getController();
            mainFormController.setMainController(this);
            mainFormController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mentalWellBeingForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/MentalWellBeing.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            MentalWellBeingController mentalWellBeingController = loader.getController();
            mentalWellBeingController.setMainController(this);
            mentalWellBeingController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mentalWellBeingHotlinesForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/MentalWellBeingHotlines.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            MentalWellBeingHotlinesController mentalWellBeingHotlinesController = loader.getController();
            mentalWellBeingHotlinesController.setMainController(this);
            mentalWellBeingHotlinesController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mentalWellBeingWellNessForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/MentalWellBeingWellness.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            MentalWellBeingWellnessController mentalWellBeingWellnessController = loader.getController();
            mentalWellBeingWellnessController.setMainController(this);
            mentalWellBeingWellnessController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mentalWellBeingWellNessDiaryForm()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HealthApp.class
                    .getResource("../views/MentalWellBeingWellnessDiary.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            MentalWellBeingWellnessDiaryController mentalWellBeingWellnessDiaryController = loader.getController();
            mentalWellBeingWellnessDiaryController.setMainController(this);
            mentalWellBeingWellnessDiaryController.setInformation();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
