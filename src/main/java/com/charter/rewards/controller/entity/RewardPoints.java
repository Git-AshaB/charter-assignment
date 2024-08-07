package com.charter.rewards.controller.entity;

public class RewardPoints {
    int customerId;
    String month;
    String year;
    int points;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "RewardPoints{" +
                "customerId=" + customerId +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", points=" + points +
                '}';
    }
}
