package com.smart_vellore_city.Emergency_Services.nearby.beans;

public class RecentNearByBean {
    private String searchItemName;
    private String searchItemDescription;
    private String searchItemDistance;

    public RecentNearByBean(String searchItemName, String searchItemDescription, String searchItemDistance) {
        this.searchItemName = searchItemName;
        this.searchItemDescription = searchItemDescription;
        this.searchItemDistance = searchItemDistance;
    }

    public String getSearchItemDescription() {
        return searchItemDescription;
    }

    public void setSearchItemDescription(String searchItemDescription) {
        this.searchItemDescription = searchItemDescription;
    }

    public String getSearchItemName() {
        return searchItemName;
    }

    public void setSearchItemName(String searchItemName) {
        this.searchItemName = searchItemName;
    }

    public String getSearchItemDistance() {
        return searchItemDistance;
    }

    public void setSearchItemDistance(String searchItemDistance) {
        this.searchItemDistance = searchItemDistance;
    }
}
