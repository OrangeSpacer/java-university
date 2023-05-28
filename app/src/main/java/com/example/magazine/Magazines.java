package com.example.magazine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Magazines extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;
    private List<Shop> shopList;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazines);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new DatabaseHelper(this);
        shopList = db.getAllShops();
        shopAdapter = new ShopAdapter(this, shopList);
        recyclerView.setAdapter(shopAdapter);
    }

}