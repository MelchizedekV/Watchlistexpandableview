package com.example.watchlistexpandableview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> movie_List;
    HashMap<String,List<String>> Movie_Category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=findViewById(R.id.expandableListView);
        Movie_Category=DataProvider.getInfo();
        movie_List=new ArrayList<>(Movie_Category.keySet());
        ExpandableAdapter expandableAdapter=new ExpandableAdapter(this,movie_List,Movie_Category);
        expandableListView.setAdapter(expandableAdapter);
    }
}
