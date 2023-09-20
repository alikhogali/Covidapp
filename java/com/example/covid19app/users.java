package com.example.covid19app;

public class users {

        String first_name;
        String last_name;
        String dateofbirth;
        String gendertype;
        String positive_negative;
        String vaccine_;
        String symptoms_;
        String phonenumber;
        String IDnumber;

        public users(String first_name, String last_name, String dateofbirth, String gendertype, String positive_negative, String vaccine_, String symptoms_, String phonenumber, String IDnumber) {
                this.first_name = first_name;
                this.last_name = last_name;
                this.dateofbirth = dateofbirth;
                this.gendertype = gendertype;
                this.positive_negative = positive_negative;
                this.vaccine_ = vaccine_;
                this.symptoms_ = symptoms_;
                this.phonenumber = phonenumber;
                this.IDnumber=IDnumber;
        }
        public users(){

        }

        public String getFirst_name() {
                return first_name;
        }

        public String getLast_name() {
                return last_name;
        }

        public String getDateofbirth() {
                return dateofbirth;
        }

        public String getGendertype() {
                return gendertype;
        }

        public String getPositive_negative() {
                return positive_negative;
        }

        public String getVaccine_() {
                return vaccine_;
        }

        public String getSymptoms_() {
                return symptoms_;
        }

        public String getPhonenumber() {
                return phonenumber;
        }

        public String getIDnumber(){
                return IDnumber;
        }
}

