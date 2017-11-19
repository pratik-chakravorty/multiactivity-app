package com.pratik.cardviews;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        this.setTitle("Movie List");

        //Initialize the Listview
        list = (ListView)findViewById(R.id.listView);

        //create an arrayList to add in the image URls and the Card Title
        ArrayList<Cards> arrayList = new ArrayList<>();

        //passing data to the custom list adapter
        arrayList.add(new Cards(R.drawable.dark_knight,"Dark Knight","9.0"));
        arrayList.add(new Cards(R.drawable.yourname,"Your Name","8.3"));
        arrayList.add(new Cards(R.drawable.inception,"Inception","8.8"));
        arrayList.add(new Cards(R.drawable.johnwick,"John Wick","7.3"));
        arrayList.add(new Cards(R.drawable.avengers,"Avengers","8.1"));
        arrayList.add(new Cards(R.drawable.starwars,"Star Wars:Force Awaken","8.1"));


        //creating a custom list adapter object
        CustomListAdapter adapter = new CustomListAdapter(this,R.layout.activity_main,arrayList);
        list.setAdapter(adapter);



    }
}
