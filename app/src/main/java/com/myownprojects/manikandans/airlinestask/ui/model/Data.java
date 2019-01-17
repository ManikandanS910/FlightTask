package com.myownprojects.manikandans.airlinestask.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by manikandans on 13/01/19.
 */

public class Data {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("web")
    @Expose
    private Boolean web;
    @SerializedName("mob")
    @Expose
    private Boolean mob;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("imagePath")
    @Expose
    private String imagePath;
    @SerializedName("designationId")
    @Expose
    private Object designationId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("airport")
    @Expose
    private Airport airport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getWeb() {
        return web;
    }

    public void setWeb(Boolean web) {
        this.web = web;
    }

    public Boolean getMob() {
        return mob;
    }

    public void setMob(Boolean mob) {
        this.mob = mob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Object getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Object designationId) {
        this.designationId = designationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
