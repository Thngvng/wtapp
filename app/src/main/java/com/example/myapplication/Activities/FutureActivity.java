package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapters.FutureAdapter;
import com.example.myapplication.Domains.FutureDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterTomorrow;
public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
       ConstraintLayout backBtn=findViewById(R.id.backBtn);
       backBtn.setOnClickListener(view -> startActivities(new Intent[]{new Intent(FutureActivity.this, MainActivity.class)}));

    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();
        items.add(new FutureDomain("Sat","storm","Storm",30,25));
        items.add(new FutureDomain("Sun","cloudy","Cloudy",29,26));
        items.add(new FutureDomain("Mon","windy","Windy",31,27));
        items.add(new FutureDomain("Tue","cloudy sunny","Cloudy sunny",32,24));
        items.add(new FutureDomain("Wen","sunny","Sun",33,22));
        items.add(new FutureDomain("Thu","rainy","Rainy",29,23));


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        adapterTomorrow=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}