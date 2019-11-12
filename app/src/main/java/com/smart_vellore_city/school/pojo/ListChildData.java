package com.smart_vellore_city.school.pojo;

/**
 * Created by Murugan on 11-12-2018.
 */

public class ListChildData {
    String childName,childAge,schoolName,childPlace;
    int childPic;

    public ListChildData(String childName, String childAge, String schoolName, String childPlace, int childPic) {
        this.childName = childName;
        this.childAge = childAge;
        this.schoolName = schoolName;
        this.childPlace = childPlace;
        this.childPic = childPic;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildAge() {
        return childAge;
    }

    public void setChildAge(String childAge) {
        this.childAge = childAge;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getChildPlace() {
        return childPlace;
    }

    public void setChildPlace(String childPlace) {
        this.childPlace = childPlace;
    }

    public int getChildPic() {
        return childPic;
    }

    public void setChildPic(int childPic) {
        this.childPic = childPic;
    }
}
