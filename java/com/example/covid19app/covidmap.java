package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

  public class covidmap extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {


      CountryCodePicker countryCodePicker;
        TextView mtodaytotal, mtotal, mactive, mtodayactive, mrecovered, mtodayrecovered, mdeaths, mtodaydeaths;

        String country;
    TextView mfilter;
    Spinner spinner;
    String[] types={"cases","deaths","recovered","active"};
    private List<ModelClasstracker> modelClasstrackerList;
    private List<ModelClasstracker> modelClasstrackerList2;
    PieChart mpiechart;
    private RecyclerView recyclerView1;
    com.example.covid19app.Adaptertracker adaptertrack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidmap);
        getSupportActionBar().hide();
        //countryCodePicker=findViewById(R.id.ccp);
        mtodayactive=findViewById(R.id.todayactive);
        mactive=findViewById(R.id.activecase);
        mdeaths=findViewById(R.id.totaldeath);
        mtodaydeaths=findViewById(R.id.todaydeath);
        mrecovered=findViewById(R.id.recoveredcase);
        mtodayrecovered=findViewById(R.id.todayrecovered);
        mtotal=findViewById(R.id.totalcase);
        mtodaytotal=findViewById(R.id.todaytotal);
        mpiechart=findViewById(R.id.piechart);
        spinner=findViewById(R.id.spinner);
        mfilter=findViewById(R.id.filter);
        recyclerView1=findViewById(R.id.recyclerview1);
        modelClasstrackerList=new ArrayList<>();
        modelClasstrackerList2=new ArrayList<>();

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdaptertracker=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,types);
        arrayAdaptertracker.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdaptertracker);
        spinner.setSelection(0,true);

        ApiUtilitestracker.getTrackerInterface().getcountrydata().enqueue(new Callback<List<ModelClasstracker>>() {
            @Override
            public void onResponse(Call<List<ModelClasstracker>> call, Response<List<ModelClasstracker>> response) {
                modelClasstrackerList2.addAll(response.body());
               // adapter.notify
                adaptertrack.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ModelClasstracker>> call, Throwable t) {

            }
        });


        adaptertrack=new Adaptertracker(getApplicationContext(),modelClasstrackerList2);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(adaptertrack);

       countryCodePicker.setAutoDetectedCountry(true);
        country=countryCodePicker.getSelectedCountryName();
        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
           @Override
            public void onCountrySelected() {
               country=countryCodePicker.getSelectedCountryName();
                fetchdata();
            }
        });
            fetchdata();
    }

    private void fetchdata() {

        ApiUtilitestracker.getTrackerInterface().getcountrydata().enqueue(new Callback<List<ModelClasstracker>>() {
            @Override
            public void onResponse(Call<List<ModelClasstracker>> call, Response<List<ModelClasstracker>> response) {
                modelClasstrackerList.addAll(response.body());
                for (int i = 0; i <= modelClasstrackerList.size(); i++) {
                    if (modelClasstrackerList.get(i).getCountry().equals(country)) {
                        mactive.setText((modelClasstrackerList.get(i).getActive()));
                        mtodaydeaths.setText((modelClasstrackerList.get(i).getTodayDeaths()));
                        mtodayrecovered.setText((modelClasstrackerList.get(i).getTodayRecovered()));
                        mtodaytotal.setText((modelClasstrackerList.get(i).getTodayCases()));
                        mtotal.setText((modelClasstrackerList.get(i).getCases()));
                        mdeaths.setText((modelClasstrackerList.get(i).getDeaths()));
                        mrecovered.setText((modelClasstrackerList.get(i).getRecovered()));

                        int active, total, recovered, deaths;

                        active=Integer.parseInt(modelClasstrackerList.get(i).getActive());
                        total=Integer.parseInt(modelClasstrackerList.get(i).getCases());
                        recovered=Integer.parseInt(modelClasstrackerList.get(i).getRecovered());
                        deaths=Integer.parseInt(modelClasstrackerList.get(i).getDeaths());

                        updateGraph(active, total, recovered, deaths);



                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelClasstracker>> call, Throwable t) {

            }
        });
    }

    private void updateGraph(int active, int total, int recovered, int deaths) {

        mpiechart.clearChart();
        mpiechart.addPieSlice(new PieModel("Confirm", total,Color.parseColor("#FFB701)")));
        mpiechart.addPieSlice(new PieModel("Active", total,Color.parseColor("#FF4CAF50)")));
        mpiechart.addPieSlice(new PieModel("Recovered", total,Color.parseColor("#38ACCD)")));
        mpiechart.addPieSlice(new PieModel("Deaths", total,Color.parseColor("#F55c47)")));
        mpiechart.startAnimation();

    }





    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item=types[position];
        mfilter.setText(item);
        adaptertrack.filter(item);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}