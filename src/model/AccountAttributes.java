package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountAttributes {
    private double weight;
    private double weightGoal;
    private int age;
    private String gender;
    private int height;
    private int heartRate;
    private int restingHeartRate;
    private int bloodPressure;
    private int bloodOxygen;
    private int respiratoryRate;
    private int lungCapacity;
    private int steps;
    private double walkingDistance;
    private int walkingTime;
    private int sleepTime;
    private int sleepGoal;
    private int waterIntake;
    private int waterGoal;
    private LocalDate todayDate;
    private boolean appointment;
    private String mood;
    private String stressLevel;

    public AccountAttributes(double weight, double weightGoal, int age, String gender, int height, int heartRate, int restingHeartRate, int bloodPressure, int bloodOxygen, int respiratoryRate, int lungCapacity, int steps, double walkingDistance, int walkingTime, int sleepTime, int sleepGoal, int waterIntake, int waterGoal, LocalDate todayDate, boolean appointment, String mood, String stressLevel) {
        this.weight = weight;
        this.weightGoal = weightGoal;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.heartRate = heartRate;
        this.restingHeartRate = restingHeartRate;
        this.bloodPressure = bloodPressure;
        this.bloodOxygen = bloodOxygen;
        this.respiratoryRate = respiratoryRate;
        this.lungCapacity = lungCapacity;
        this.steps = steps;
        this.walkingDistance = walkingDistance;
        this.walkingTime = walkingTime;
        this.sleepTime = sleepTime;
        this.sleepGoal = sleepGoal;
        this.waterIntake = waterIntake;
        this.waterGoal = waterGoal;
        this.todayDate = todayDate;
        this.appointment = appointment;
        this.mood = mood;
        this.stressLevel = stressLevel;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setBloodOxygen(int bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public void setLungCapacity(int lungCapacity) {
        this.lungCapacity = lungCapacity;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setWalkingDistance(double walkingDistance) {
        this.walkingDistance = walkingDistance;
    }

    public void setWalkingTime(int walkingTime) {
        this.walkingTime = walkingTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void setSleepGoal(int sleepGoal) {
        this.sleepGoal = sleepGoal;
    }

    public void setWaterIntake(int waterIntake) {
        this.waterIntake = waterIntake;
    }

    public void setWaterGoal(int waterGoal) {
        this.waterGoal = waterGoal;
    }

    public void setTodayDate(LocalDate todayDate) {
        this.todayDate = todayDate;
    }

    public void setAppointment(boolean appointment) {
        this.appointment = appointment;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setStressLevel(String stressLevel) {
        this.stressLevel = stressLevel;
    }

    public double getWeight() {
        return weight;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public int getBloodOxygen() {
        return bloodOxygen;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public int getLungCapacity() {
        return lungCapacity;
    }

    public int getSteps() {
        return steps;
    }

    public double getWalkingDistance() {
        return walkingDistance;
    }

    public int getWalkingTime() {
        return walkingTime;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public int getSleepGoal() {
        return sleepGoal;
    }

    public int getWaterIntake() {
        return waterIntake;
    }

    public int getWaterGoal() {
        return waterGoal;
    }

    public LocalDate getTodayDate() {
        return todayDate;
    }

    public boolean isAppointment() {
        return appointment;
    }

    public String getMood() {
        return mood;
    }

    public String getStressLevel() {
        return stressLevel;
    }

    private String formatDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(todayDate);
    }

    public String CSVFormat(){
        return this.weight + "," + this.weightGoal + "," + this.age + "," + this.gender + "," + this.height
                + "," + this.heartRate + "," + this.restingHeartRate + "," + this.bloodPressure + "," + this.bloodOxygen
                + "," + this.respiratoryRate + "," + this.lungCapacity + "," + this.steps + "," + this.walkingDistance
                + "," + this.walkingTime + "," + this.sleepTime + "," + this.sleepGoal + "," + this.waterIntake
                + "," + this.waterGoal + "," + this.todayDate + "," + this.appointment + "," + this.mood
                + "," + this.stressLevel;
    }

    @Override
    public String toString() {



        return "AccountAttributes{" +
                "weight=" + weight +
                ", weightGoal=" + weightGoal +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", heartRate=" + heartRate +
                ", restingHeartRate=" + restingHeartRate +
                ", bloodPressure=" + bloodPressure +
                ", bloodOxygen=" + bloodOxygen +
                ", respiratoryRate=" + respiratoryRate +
                ", lungCapacity=" + lungCapacity +
                ", steps=" + steps +
                ", walkingDistance=" + walkingDistance +
                ", walkingTime=" + walkingTime +
                ", sleepTime=" + sleepTime +
                ", sleepGoal=" + sleepGoal +
                ", waterIntake=" + waterIntake +
                ", waterGoal=" + waterGoal +
                ", todayDate=" + formatDate() +
                ", appointment=" + appointment +
                ", mood='" + mood + '\'' +
                ", stressLevel=" + stressLevel +
                '}';
    }
}


