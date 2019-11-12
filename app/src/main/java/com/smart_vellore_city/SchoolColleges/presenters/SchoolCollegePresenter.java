package com.smart_vellore_city.SchoolColleges.presenters;


import com.smart_vellore_city.SchoolColleges.beans.SchoolCollegeBean;
import com.smart_vellore_city.SchoolColleges.contracts.SchoolCollegeContract;

import java.util.ArrayList;
import java.util.List;

public class SchoolCollegePresenter implements SchoolCollegeContract.presenter {
    SchoolCollegeContract.view view;

    public SchoolCollegePresenter(SchoolCollegeContract.view view) {
        this.view = view;
    }

    @Override
    public void loadSchools() {
        List<SchoolCollegeBean> schoolCollegeBeans = new ArrayList<>();
        schoolCollegeBeans.add(new SchoolCollegeBean("http://www.singhvischools.com/vellore/images/photo_gallery/683011893967_747944708685200_3500528441299934092_o.jpg", "Takshila School","8th East Main Rd, Suthanthira Ponvizha Nagar, Gandhi Nagar, Vellore, Tamil Nadu 632006","9856677508"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://lh3.googleusercontent.com/1osbiOwOzmwhcys5Ae3Ifg4_OVl_IZXPmhoDks9T-xuCJ0GR03_g21a-5JynOCWn00RYjxRe6eHyAQ=w1440-h811-rw-no", "Sunbeam Schools","8th East Main Rd, Suthanthira Ponvizha Nagar, Gandhi Nagar, Vellore, Tamil Nadu 632006","9856677508"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://content.jdmagicbox.com/comp/vellore/f8/9999px416.x416.110707141829.p5f8/catalogue/holy-cross-matriculation-higher-secondary-school-sathuvacheri-vellore-schools-5rjmv84.jpg?interpolation=lanczos-none&output-format=jpg&resize=1024:370&crop=1024:370px;*,*", "Holy Cross Matriculation Hr.Sec. School","Phase III, Sathuvachari, Vellore, Tamil Nadu 632009","0416 225 2431"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://lh3.googleusercontent.com/W-yRKb9Vbl1ZDdAlY_4VSMuJ5s7KDj2X_COxOS0w9ndkKzQV_9w9yCITdFon9oFpx50PXwp41CL1DQ=w600-h400-rw-no", "SPARK GROUP OF SCHOOLS (RESIDENTIAL)","Azad Road, SH 207, Thirumalaikodi, Vellore, Tamil Nadu 632105","0416 227 1799"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://lh3.googleusercontent.com/ybVAoyH9wpm5QuQuh6CTHHnwxQvk0C8tKUlGbdCHOMMAELnEXrfEctb3MuCSKayZeTpJdnUtZbPUIA=w4288-h2848-rw-no", "Sri Sai Vidyashram - CBSE","Chennai- Bangalore Highway, Vellore, Eraiyankadu, Tamil Nadu 632104","098430 22989"));
        view.getDatas(schoolCollegeBeans);
   }

    @Override
    public void loadColleges() {
        List<SchoolCollegeBean> schoolCollegeBeans = new ArrayList<>();
        schoolCollegeBeans.add(new SchoolCollegeBean("http://www.auxiliumcollege.edu.in/wp-content/uploads/2016/01/auditorium-1.jpg", "Auxilium College Autonomous","17th East Cross Road, Gandhi Nagar, Suthanthira Ponvizha Nagar, Vellore, Tamil Nadu 632006","0416 224 1774"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://lh3.googleusercontent.com/9qD5ROQ-TR4FUa4qONKVNyeYo5o0R4s0EeYi1hkN-kfC2fLvt69QTPNwX9BKrqNzuVTJIHzapu7yDQ=w4608-h3456-rw-no", "Government Vellore Medical College","Pennathur Post, Adukkamparai, Sapthalipuram, Vellore, Tamil Nadu 632011","0416 226 0900"));
        schoolCollegeBeans.add(new SchoolCollegeBean("http://www.gtec.ac.in/images/slider/1.jpg", "Ganadipathy Tulsi’s Jain Engineering College","Ganadipathy Tulsi's Jain Engineering College, Chittoor-Cuddalore Road, Kaniyambadi, Vellore-632 102, Kaniyambadi, Tamil Nadu 632102","0416 223 0900"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://static.careers360.mobi/media/article_images/2018/03/15/CMC_Vellore_MBBS.jpg", "Christian Medical College, Vellore","Ida Scudder Road, Vellore, Tamil Nadu 632004","0416 228 1000"));
        schoolCollegeBeans.add(new SchoolCollegeBean("https://i.ndtvimg.com/i/2017-04/vit-vellore_650x400_81492934847.jpg", "VIT Vellore","VIT Main Rd, Old Katpadi, Andal Nagar, Katpadi, Vellore, Tamil Nadu 632006","0416 220 2125"));
        view.getDatas(schoolCollegeBeans);
    }
}
