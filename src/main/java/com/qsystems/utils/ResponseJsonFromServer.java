package com.qsystems.utils;

import java.time.LocalDate;

/**
 * Created by Kornyukhina Sasha
 */
public class ResponseJsonFromServer {
    private String currentDate;
    private double currentValue;
    private String dayBeforeDate;
    private double dayBeforeValue;
    private String twoDaysBeforeDate;
    private double twoDaysBeforeValue;

    public ResponseJsonFromServer() {
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public String getDayBeforeDate() {
        return dayBeforeDate;
    }

    public void setDayBeforeDate(String dayBeforeDate) {
        this.dayBeforeDate = dayBeforeDate;
    }

    public double getDayBeforeValue() {
        return dayBeforeValue;
    }

    public void setDayBeforeValue(double dayBeforeValue) {
        this.dayBeforeValue = dayBeforeValue;
    }

    public String getTwoDaysBeforeDate() {
        return twoDaysBeforeDate;
    }

    public void setTwoDaysBeforeDate(String twoDaysBeforeDate) {
        this.twoDaysBeforeDate = twoDaysBeforeDate;
    }

    public double getTwoDaysBeforeValue() {
        return twoDaysBeforeValue;
    }

    public void setTwoDaysBeforeValue(double twoDaysBeforeValue) {
        this.twoDaysBeforeValue = twoDaysBeforeValue;
    }
}
