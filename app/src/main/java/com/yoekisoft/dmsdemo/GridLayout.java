package com.yoekisoft.dmsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridLayout extends AppCompatActivity {
    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich","Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich"

    };

  private final Integer android_image_urls[] = {
            /* "http://api.learn2crack.com/android/images/donut.png",
             "http://api.learn2crack.com/android/images/eclair.png",
             "http://api.learn2crack.com/android/images/froyo.png",
             "http://api.learn2crack.com/android/images/ginger.png",
             "http://api.learn2crack.com/android/images/honey.png",
             "http://api.learn2crack.com/android/images/icecream.png",
             "http://api.learn2crack.com/android/images/jellybean.png",
             "http://api.learn2crack.com/android/images/kitkat.png",
             "http://api.learn2crack.com/android/images/lollipop.png",
             "http://api.learn2crack.com/android/images/marshmallow.png"*/
        R.drawable.ic_add_item,
         R.drawable.ic_number,
         R.drawable.ic_add_item,
        R.drawable.ic_number,
         R.drawable.ic_add_item,
         R.drawable.ic_number,
          R.drawable.ic_add_item,
          R.drawable.ic_number,
          R.drawable.ic_add_item,
          R.drawable.ic_number,
          R.drawable.ic_add_item,
          R.drawable.ic_number,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);


        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3,RecyclerView.VERTICAL,true);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<modelgrid> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), androidVersions);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<modelgrid> prepareData() {

        ArrayList<modelgrid> android_version = new ArrayList<>();
        for (int i = 0; i < android_version_names.length; i++) {
            modelgrid androidVersion = new modelgrid();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}



