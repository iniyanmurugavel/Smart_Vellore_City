package com.smart_vellore_city.Directory.Model;

public class Hospital {

    private String hospitalName,phNo,email,pinCode,type;

    public Hospital(String hospitalName, String phNo, String email, String pinCode, String type) {
        this.hospitalName=hospitalName;
        this.phNo=phNo;
        this.email=email;
        this.pinCode=pinCode;
        this.type=type;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
