package ru.vsprog.springinaction.chapter8;

import ru.vsprog.springinaction.chapter2.City;

/**
 * Created by vsa
 * Date: 25.11.2014.
 */
public class Rant {
    private double postedDate;
    private String rantText;
    private City vehicle;

    public double getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(double postedDate) {
        this.postedDate = postedDate;
    }

    public String getRantText() {
        return rantText;
    }

    public void setRantText(String rantText) {
        this.rantText = rantText;
    }

    public City getVehicle() {
        return vehicle;
    }

    public void setVehicle(City vehicle) {
        this.vehicle = vehicle;
    }
}
