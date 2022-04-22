package views;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import model.AccountAttributes;

import javafx.scene.image.ImageView ;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MentalWellBeingWellnessDiaryController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label weekHolder;
    @FXML
    private ImageView moodMon;
    @FXML
    private ImageView moodTue;
    @FXML
    private ImageView moodWed;
    @FXML
    private ImageView moodThur;
    @FXML
    private ImageView moodFri;
    @FXML
    private ImageView moodSat;
    @FXML
    private ImageView moodSun;
    @FXML
    private ImageView stressLevelMon;
    @FXML
    private ImageView stressLevelTue;
    @FXML
    private ImageView stressLevelWed;
    @FXML
    private ImageView stressLevelThur;
    @FXML
    private ImageView stressLevelFri;
    @FXML
    private ImageView stressLevelSat;
    @FXML
    private ImageView stressLevelSun;
    @FXML
    private Controller mainController;
    private LocalDate date;

    @FXML
    private void initialize() {
        date = LocalDate.now();
    }

    @FXML
    public void handleSettings() {
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
    public void handleHealthOverview() {
        mainController.healthOverviewForm();
    }

    @FXML
    public void handleHealthActivities() {

    }

    @FXML
    public void handleMentalWellBeing() {
        mainController.mentalWellBeingForm();
    }

    @FXML
    public void handleHotlines() {
        mainController.mentalWellBeingHotlinesForm();
    }

    @FXML
    public void handleWellness() {
        mainController.mentalWellBeingWellNessForm();
    }

    @FXML
    public void handleNextWeek()
    {
        date = date.plusWeeks(1);
        List<String> thisWeek = getWeek(date);
        weekHolder.setText(getWeekSpan(thisWeek));
        clearImages();
        setImages(thisWeek);
    }

    @FXML
    public void handlePreviousWeek()
    {
        date = date.minusWeeks(1);
        List<String> previousWeek = getWeek(date);
        weekHolder.setText(getWeekSpan(previousWeek));
        clearImages();
        setImages(previousWeek);
    }

    private List<String> getWeek(LocalDate day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<String> week = new ArrayList<>();
        LocalDate mondayDate = day.with(DayOfWeek.MONDAY);
        String monday = formatter.format(mondayDate);
        week.add(monday);
        LocalDate tuesdayDate = day.with(DayOfWeek.TUESDAY);
        String tuesday = formatter.format(tuesdayDate);
        week.add(tuesday);
        LocalDate wednesdayDate = day.with(DayOfWeek.WEDNESDAY);
        String wednesday = formatter.format(wednesdayDate);
        week.add(wednesday);
        LocalDate thursdayDate = day.with(DayOfWeek.THURSDAY);
        String thursday = formatter.format(thursdayDate);
        week.add(thursday);
        LocalDate fridayDate = day.with(DayOfWeek.FRIDAY);
        String friday = formatter.format(fridayDate);
        week.add(friday);
        LocalDate saturdayDate = day.with(DayOfWeek.SATURDAY);
        String saturday = formatter.format(saturdayDate);
        week.add(saturday);
        LocalDate sundayDate = day.with(DayOfWeek.SUNDAY);
        String sunday = formatter.format(sundayDate);
        week.add(sunday);
        return week;
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    public void setInformation() {
        nameLabel.setText(mainController.getAccount().getUsername());
        List<String> thisWeek = getWeek(date);
        weekHolder.setText(getWeekSpan(thisWeek));
        setImages(thisWeek);
    }

    private void setImages(List<String> thisWeek) {
        for (int i = 0; i < thisWeek.size(); i++) {
            AccountAttributes attributes = mainController.getRepository().getAccountAttributesByDate(mainController.getAccount().getUsername(), thisWeek.get(i));
            if (attributes != null) {
                try {
                    if (!attributes.getMood().equals("NULL") && !attributes.getStressLevel().equals("NULL")) {
                        switch (i) {
                            case 0:
                                moodMon.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelMon.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                            case 1:
                                moodTue.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelTue.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                            case 2:
                                moodWed.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelWed.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                            case 3:
                                moodThur.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelThur.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                            case 4:
                                moodFri.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelFri.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                            case 5:
                                moodSat.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelSat.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                            case 6:
                                moodSun.setImage(new Image(getMoodImageType(attributes)));
                                stressLevelSun.setImage(new Image(getStressLevelImageType(attributes)));
                                break;
                        }
                    }
                    else
                    {
                        switch (i) {
                            case 0:
                                moodMon.setImage(new Image("views/Cross.png"));
                                break;
                            case 1:
                                moodTue.setImage(new Image("views/Cross.png"));
                                break;
                            case 2:
                                moodWed.setImage(new Image("views/Cross.png"));
                                break;
                            case 3:
                                moodThur.setImage(new Image("views/Cross.png"));
                                break;
                            case 4:
                                moodFri.setImage(new Image("views/Cross.png"));
                                break;
                            case 5:
                                moodSat.setImage(new Image("views/Cross.png"));
                                break;
                            case 6:
                                moodSun.setImage(new Image("views/Cross.png"));
                                break;
                            }
                    }
                    }
                catch (Exception exception) {
                    switch (i) {
                        case 0:
                            moodMon.setImage(new Image("views/Cross.png"));
                            break;
                        case 1:
                            moodTue.setImage(new Image("views/Cross.png"));
                            break;
                        case 2:
                            moodWed.setImage(new Image("views/Cross.png"));
                            break;
                        case 3:
                            moodThur.setImage(new Image("views/Cross.png"));
                            break;
                        case 4:
                            moodFri.setImage(new Image("views/Cross.png"));
                            break;
                        case 5:
                            moodSat.setImage(new Image("views/Cross.png"));
                            break;
                        case 6:
                            moodSun.setImage(new Image("views/Cross.png"));
                            break;
                    }
                }
            }
            }
        }
        private String getMoodImageType (AccountAttributes attributes)
        {
            return "views/" + attributes.getMood() + "Emoji.png";
        }

        private String getStressLevelImageType (AccountAttributes attributes)
        {
            return "views/" + attributes.getStressLevel() + ".png";
        }

        private void clearImages()
        {
            moodMon.setImage(new Image("views/Blank.png"));
            moodTue.setImage(new Image("views/Blank.png"));
            moodWed.setImage(new Image("views/Blank.png"));
            moodThur.setImage(new Image("views/Blank.png"));
            moodFri.setImage(new Image("views/Blank.png"));
            moodSat.setImage(new Image("views/Blank.png"));
            moodSun.setImage(new Image("views/Blank.png"));
            stressLevelMon.setImage(new Image("views/Blank.png"));
            stressLevelTue.setImage(new Image("views/Blank.png"));
            stressLevelWed.setImage(new Image("views/Blank.png"));
            stressLevelThur.setImage(new Image("views/Blank.png"));
            stressLevelFri.setImage(new Image("views/Blank.png"));
            stressLevelSat.setImage(new Image("views/Blank.png"));
            stressLevelSun.setImage(new Image("views/Blank.png"));
        }

        private String getWeekSpan(List<String> date)
        {
            return date.get(0) + " - " +  date.get(date.size()-1);
        }
    }

