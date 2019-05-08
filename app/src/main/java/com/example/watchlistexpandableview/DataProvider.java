package com.example.watchlistexpandableview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProvider
{
    public static HashMap<String,List<String>> getInfo() {
        HashMap<String, List<String>> Movies_Details = new HashMap<>();
        List<String> Action_Movies = new ArrayList<String>();
        Action_Movies.add("Theri");
        Action_Movies.add("Mangatha");
        Action_Movies.add("Petta");
        List<String> Comedy_Movies = new ArrayList<>();
        Comedy_Movies.add("SMS");
        Comedy_Movies.add("VSOP");
        Comedy_Movies.add("Maan Karatae");

        Movies_Details.put("Action_Movies",Action_Movies);
        Movies_Details.put("Comedy_Movies",Comedy_Movies);
        return Movies_Details;
    }
}
