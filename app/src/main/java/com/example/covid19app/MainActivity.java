package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button enterbutton1;
    Button mapbutton1;
    Button searchbutton1;
    Button newsbutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterbutton1=(Button)findViewById(R.id.enterbutton);
        mapbutton1=(Button)findViewById(R.id.mapbutton);
        searchbutton1=(Button)findViewById(R.id.searchbutton);
        newsbutton1=(Button)findViewById(R.id.newsbutton);

        enterbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EnterInfomation.class);
                startActivity(intent);
            }
        });

        mapbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,covidmap.class);
                startActivity(intent);
            }
        });

        searchbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, search.class);
                startActivity(intent);
            }
        });

        newsbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, CovidNews.class);
                 startActivity(intent);
            }
        });



    }
}