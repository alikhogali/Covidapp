package com.example.covid19app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter{

        private Activity mContext;

        List<users> usersList;

    public ListAdapter(Activity mContext, List<users> usersList) {

        super(mContext, R.layout.list_item, usersList);
        this.mContext = mContext;
        this.usersList = usersList;
}
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item, null, true);

        TextView idnumber = listItemView.findViewById(R.id.idnumber);
        TextView firstname = listItemView.findViewById(R.id.firstname);
        TextView lastname = listItemView.findViewById(R.id.lastname);
        TextView birth = listItemView.findViewById(R.id.birth);
        TextView gender = listItemView.findViewById(R.id.gender);
        TextView positive = listItemView.findViewById(R.id.positive);
        TextView vaccine = listItemView.findViewById(R.id.vaccine);
        TextView symptoms = listItemView.findViewById(R.id.symptoms);
        TextView phone = listItemView.findViewById(R.id.phone);

        users users = usersList.get(position);

        idnumber.setText(users.getIDnumber());
        firstname.setText(users.getFirst_name());
        lastname.setText(users.getLast_name());
        birth.setText(users.getDateofbirth());
        gender.setText(users.getGendertype());
        positive.setText(users.getPositive_negative());
        vaccine.setText(users.getVaccine_());
        symptoms.setText(users.getSymptoms_());
        phone.setText(users.getPhonenumber());

        return listItemView;
    }



    }