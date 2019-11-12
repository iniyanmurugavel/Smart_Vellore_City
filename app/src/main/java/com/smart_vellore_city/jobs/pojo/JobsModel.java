package com.smart_vellore_city.jobs.pojo;

public class JobsModel {

    String companyName,role,location,experience,postedDate;

    public JobsModel(String companyName, String role, String location, String experience, String postedDate) {
        this.companyName = companyName;
        this.role = role;
        this.location = location;
        this.experience = experience;
        this.postedDate = postedDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }
}
