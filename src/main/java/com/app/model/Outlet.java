package com.app.model;

import com.app.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t2_outlet")
public class Outlet extends BaseEntity {

    private String name;
    private String latitude;
    private String longitude;
    private String Description;
    private User userSales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public User getUserSales() {
        return userSales;
    }

    public void setUserSales(User userSales) {
        this.userSales = userSales;
    }
}
