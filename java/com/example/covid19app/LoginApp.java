package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);

        TextView username=(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.password);

        Button loginbtn= (Button) findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("fischbachiscool") && password.getText().toString().equals("admin")) {
                    Toast.makeText(LoginApp.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(LoginApp.this, search.class);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginApp.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();

            }

        });


    }
}