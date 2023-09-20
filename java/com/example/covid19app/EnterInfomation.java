package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnterInfomation extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
    EditText birth;
    EditText positive;
    EditText gender;
    EditText vaccine;
    EditText phone;
    EditText symptoms;
    EditText idnumber;
    Button Submit;

    FirebaseDatabase rootnode;
    DatabaseReference Covidreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_infomation);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        birth = findViewById(R.id.birth);
        gender = findViewById(R.id.gender);
        positive = findViewById(R.id.positive);
        vaccine = findViewById(R.id.vaccine);
        symptoms = findViewById(R.id.symptoms);
        phone = findViewById(R.id.phone);
        idnumber = findViewById(R.id.idnumber);

        Submit = findViewById(R.id.Submit);

        Covidreference = FirebaseDatabase.getInstance().getReference().child("users");

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertinformation();
            }

            private void insertinformation() {

                String first_name = firstname.getText().toString();
                String last_name = lastname.getText().toString();
                String dateofbirth = birth.getText().toString();
                String gendertype = gender.getText().toString();
                String positive_negative = positive.getText().toString();
                String vaccine_ = vaccine.getText().toString();
                String symptoms_ = symptoms.getText().toString();
                String phonenumber = phone.getText().toString();
                String IDnumber = idnumber.getText().toString();

                users Users = new users(first_name, last_name, dateofbirth, gendertype, positive_negative, vaccine_, symptoms_, phonenumber, IDnumber);

                rootnode = FirebaseDatabase.getInstance();
                Covidreference = rootnode.getReference("users");
                Covidreference.child(IDnumber).setValue(Users);

                //Covidreference.push().setValue(Users);
                Toast.makeText(EnterInfomation.this, "Entered!", Toast.LENGTH_SHORT).show();

            }
        });
    }



    }

