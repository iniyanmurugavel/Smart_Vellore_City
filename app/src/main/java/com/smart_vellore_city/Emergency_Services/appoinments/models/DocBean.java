package com.smart_vellore_city.Emergency_Services.appoinments.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DocBean implements Parcelable {
    private int docId;
    private String docName;
    private String docRating;
    private String docPhno;
    private String docSpeciality;
    private String docGeneralIntro;
    private String docHospital;
    private String docAddress;
    private String docKnownLanguages;
    private String docImgUrl;
    private String docPackage;


    public DocBean(int docId, String docName, String docRating, String docPhno, String docSpeciality, String docGeneralIntro, String docHospital, String docAddress, String docKnownLanguages, String docImgUrl, String docPackage) {
        this.docId = docId;
        this.docName = docName;
        this.docRating = docRating;
        this.docPhno = docPhno;
        this.docSpeciality = docSpeciality;
        this.docGeneralIntro = docGeneralIntro;
        this.docHospital = docHospital;
        this.docAddress = docAddress;
        this.docKnownLanguages = docKnownLanguages;
        this.docImgUrl = docImgUrl;
        this.docPackage = docPackage;
    }

    public DocBean(Parcel in) {
        docId = in.readInt();
        docName = in.readString();
        docRating = in.readString();
        docPhno = in.readString();
        docSpeciality = in.readString();
        docGeneralIntro = in.readString();
        docHospital = in.readString();
        docAddress = in.readString();
        docKnownLanguages = in.readString();
        docImgUrl = in.readString();
        docPackage = in.readString();
    }

    public static final Creator<DocBean> CREATOR = new Creator<DocBean>() {
        @Override
        public DocBean createFromParcel(Parcel in) {
            return new DocBean(in);
        }

        @Override
        public DocBean[] newArray(int size) {
            return new DocBean[size];
        }
    };

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocRating() {
        return docRating;
    }

    public void setDocRating(String docRating) {
        this.docRating = docRating;
    }

    public String getDocPhno() {
        return docPhno;
    }

    public void setDocPhno(String docPhno) {
        this.docPhno = docPhno;
    }

    public String getDocSpeciality() {
        return docSpeciality;
    }

    public void setDocSpeciality(String docSpeciality) {
        this.docSpeciality = docSpeciality;
    }

    public String getDocGeneralIntro() {
        return docGeneralIntro;
    }

    public void setDocGeneralIntro(String docGeneralIntro) {
        this.docGeneralIntro = docGeneralIntro;
    }

    public String getDocHospital() {
        return docHospital;
    }

    public void setDocHospital(String docHospital) {
        this.docHospital = docHospital;
    }

    public String getDocAddress() {
        return docAddress;
    }

    public void setDocAddress(String docAddress) {
        this.docAddress = docAddress;
    }

    public String getDocKnownLanguages() {
        return docKnownLanguages;
    }

    public void setDocKnownLanguages(String docKnownLanguages) {
        this.docKnownLanguages = docKnownLanguages;
    }

    public String getDocImgUrl() {
        return docImgUrl;
    }

    public void setDocImgUrl(String docImgUrl) {
        this.docImgUrl = docImgUrl;
    }

    public String getDocPackage() {
        return docPackage;
    }

    public void setDocPackage(String docPackage) {
        this.docPackage = docPackage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(docId);
        dest.writeString(docName);
        dest.writeString(docRating);
        dest.writeString(docPhno);
        dest.writeString(docSpeciality);
        dest.writeString(docGeneralIntro);
        dest.writeString(docHospital);
        dest.writeString(docAddress);
        dest.writeString(docKnownLanguages);
        dest.writeString(docImgUrl);
        dest.writeString(docPackage);
    }
}
