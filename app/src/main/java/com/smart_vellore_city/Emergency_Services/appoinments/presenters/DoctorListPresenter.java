package com.smart_vellore_city.Emergency_Services.appoinments.presenters;

import com.smart_vellore_city.Emergency_Services.appoinments.contracts.IDoctorListContract;
import com.smart_vellore_city.Emergency_Services.appoinments.models.DocBean;

import java.util.ArrayList;
import java.util.List;

public class DoctorListPresenter implements IDoctorListContract.presenter{

    private IDoctorListContract.view view;

    public DoctorListPresenter(IDoctorListContract.view view) {
        this.view = view;
    }


    @Override
    public void loadDatas() {
            List<DocBean> docBeanList = new ArrayList<>();
            docBeanList.add(new DocBean(1,"Dr. Selvaraj Loganathan","4.2","9080465444",
                    "Dentistry","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Vds Dental And Maxillofacial Centre","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://i.ytimg.com/vi/1rr5HR6eliM/maxresdefault.jpg","120"));
            docBeanList.add(new DocBean(2,"Dr. Venkataramanan","4.5","9080465444",
                    "Nephrology","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","K V R Kidney Kare & Diabetic Hospital","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://images1-fabric.practo.com/dr-saravanan-lakshmanan-1482476221-585ccabdbeb39.jpg","130"));
            docBeanList.add(new DocBean(3,"Dr. Dharani Sakthi","4.3","9080465444",
                    "Complementary / Alternative Medicine","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Mothers Care Homoeo Clinic","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","http://www.dragarwal.com/wp-content/uploads/2016/07/Anjana-Krishnan-Vellore.jpg","140"));
            docBeanList.add(new DocBean(4,"Dr. Surekha . V","4.6","9080465444",
                    "Geriatrics","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Christian Medical College And Hospital","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","http://www.dragarwal.com/wp-content/uploads/2016/07/Nithya-Vellore.jpg","110"));
            docBeanList.add(new DocBean(5,"Dr. Kuruvilla Prasad Mathews","4.8","9080465444",
                    "Geriatrics","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Christian Medical College & Hospital","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://images1-fabric.practo.com/doctor/263656/dr-n-sezhian-5a08070234b7e.jpg","100"));
            docBeanList.add(new DocBean(6,"Dr. George M. Chandy","4.2","9080465444",
                    "Geriatrics","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Christian Medical College & Hospital,","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://images1-fabric.practo.com/dr-dhanasekar-1475753323-57f6356be5269.jpg","50"));
            docBeanList.add(new DocBean(7,"Dr. Purendra Kumar Pati","5.0","9080465444",
                    "Cardiology","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","C.M.C Hospital","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://images1-fabric.practo.com/55630deaa628b8277e0910d750195b448797616e091ad.jpg","100"));
            docBeanList.add(new DocBean(8,"Dr. Selvaraj Loganathan","4.2","9080465444",
                    "Dentistry","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Vds Dental And Maxillofacial Centre","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","http://www3.kpjsentosa.com.my/front_html/images/find_doctor/img_Mohan_Arasu.jpg","150"));
            docBeanList.add(new DocBean(9,"Dr. Oommen K George","4.2","9080465444",
                    "Dentistry","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Christian Medical College Hospital","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://www.sriramakrishnahospital.com/wp-content/uploads/2017/11/Manjulatha-3.jpg","170"));
            docBeanList.add(new DocBean(10,"Dr. Sunithi Elizabeth Mani","4.7","9080465444",
                    "Radiology / Sonology / Ultrasound","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Vds Dental And Maxillofacial Centre","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","https://www.browardhealth.org/-/media/BH_Doctor_Images/108634.png/","200"));
            docBeanList.add(new DocBean(11,"Dr. Selvaraj Loganathan","4.2","9080465444",
                    "Dentistry","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Vds Dental And Maxillofacial Centre","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","http://www.cmchaematology.org/img/doctor/alok.jpg","300"));
            docBeanList.add(new DocBean(12,"Dr. Selvaraj Loganathan","4.2","9080465444",
                    "Dentistry","He  is the head of K. V .R kidney Kare & diabetic hospital." +
                    "He received medal from honourable president Shri Pranabh Mukharjee for meritorious performance in D.M Nephrology." +
                    "He is a dynamic and skillful intervention nephrologist currently working in vellore.","Vds Dental And Maxillofacial Centre","24, D Mandy Street , \n" +
                    "Near Old Bus Stand And Traffic Police Station, Vellore - 632004, \n" +
                    "Tamil Nadu","Tamil, English","http://www.cmchaematology.org/img/doctor/alok.jpg","540"));
            view.getDatas(docBeanList);

    }
}
