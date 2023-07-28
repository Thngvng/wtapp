package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Adapters.HourlyAdapters;
import com.example.myapplication.Domains.Hourly;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterHourly;
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        setVariable();
        

    }

    private void setVariable() {
        TextView next7daysBtn= findViewById(R.id.nextBtn);
        next7daysBtn.setOnClickListener(view -> startActivities(new Intent(MainActivity.this, FutureActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items=new ArrayList<>();
        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("10 pm",29,"sun"));
        items.add(new Hourly("11 pm",30,"wind"));
        items.add(new Hourly("12 pm",31,"rainy"));
        items.add(new Hourly("1 am",32,"storm"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterHourly=new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);

    }
}