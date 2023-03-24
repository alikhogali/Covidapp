package com.example.covid19app;
//declaring the package of this class.

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
// importing the necessary classes for this implementation.

public class CovidNews extends RecyclerView.Adapter<CovidNews.ViewHolder> {
    //This class is responsible for providing the data to the RecyclerView.
    private ArrayList<Card> cardArrayList;
    //declare a private ArrayList cardArrayList to hold the data to be displayed in the RecyclerView
    private Context context;
    //Context context to be used for retrieving resources.
    @NonNull
    @Override
    public CovidNews.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);
        return new CovidNews.ViewHolder(view);
        //creates a new View and then creates a new ViewHolder object with this view.
    }

    @Override
    public void onBindViewHolder(@NonNull CovidNews.ViewHolder holder, int position) {
        Card Card = cardArrayList.get(position);
        holder.subtitleTV.setText(Card.getDescription());
        holder.titleTV.setText(Card.getTitle());
        Picasso.get().load(Card.getUrlToImage()).into(holder.newsIV);
        //sets the title and subtitle TextViews to the corresponding
        // data in the Card object and loads the image using the Picasso library.

    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV, subtitleTV;
        private ImageView newsIV;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            titleTV = itemView.findViewById(R.id.NewsHeading);
            subtitleTV = itemView.findViewById(R.id.NewsSubtitle);
            newsIV = itemView.findViewById(R.id.NewsImage);

        }
    }
}
