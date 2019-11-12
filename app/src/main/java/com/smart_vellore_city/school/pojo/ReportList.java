package com.smart_vellore_city.school.pojo;

/**
 * Created by Murugan on 10-12-2018.
 */

public class ReportList {

    String reportType, facultyName,reportDate,reportDescription;

    public ReportList(String reportType, String facultyName, String reportDate, String reportDescription) {
        this.reportType = reportType;
        this.facultyName = facultyName;
        this.reportDate = reportDate;
        this.reportDescription = reportDescription;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }
}
