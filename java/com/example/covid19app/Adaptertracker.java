package com.example.covid19app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.text.NumberFormat;
import java.util.List;

public class Adaptertracker extends RecyclerView.Adapter<Adaptertracker.ViewHolder> {

    int m=1;
    Context context;
    List<ModelClasstracker> countryList;

    public Adaptertracker(Context context, List<ModelClasstracker> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public Adaptertracker.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_itemtracker,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptertracker.ViewHolder holder, int position) {

        ModelClasstracker modelClasstracker=countryList.get(position);
        if(m==1){
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClasstracker.getCases())));
        }
        else if(m==2){
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClasstracker.getRecovered())));
        }
        else if(m==3){
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClasstracker.getDeaths())));
        }
        else {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClasstracker.getActive())));

        }

        holder.country.setText(modelClasstracker.getCountry());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cases, country;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cases=itemView.findViewById(R.id.countrycase);
            country=itemView.findViewById(R.id.countryname);
        }
    }

    public void filter(String charText){
        if(charText.equals("cases")){
            m=1;
        }
        else if (charText.equals("recovered")){
            m=2;
        }
        else if(charText.equals("deaths")){
            m=3;
        }
        else {
            m=4;
        }
        notifyDataSetChanged();
    }


}
