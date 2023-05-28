package com.example.magazine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput;
    private EditText addressInput;
    private EditText openTimeInput;
    private EditText closeTimeInput;

    private Button createBtn;
    private Button nextBtn;

    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.name);
        addressInput = findViewById(R.id.address);
        openTimeInput = findViewById(R.id.openTime);
        closeTimeInput = findViewById(R.id.closeTime);
        createBtn = findViewById(R.id.create);
        nextBtn = findViewById(R.id.next);


        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nameInput.getText().toString().isEmpty() && !addressInput.getText().toString().isEmpty() && !openTimeInput.getText().toString().isEmpty() && !closeTimeInput.getText().toString().isEmpty()){
                    saveShop();
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(() -> {
                    try{
                        Intent intent = new Intent(MainActivity.this, Magazines.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

            }
        });

        db = new DatabaseHelper(this);
    }

    private void saveShop() {
        String name = nameInput.getText().toString();
        String address = addressInput.getText().toString();
        String openTime = openTimeInput.getText().toString();
        String closeTime = closeTimeInput.getText().toString();

        long newRow = db.insertShop(name,address,openTime,closeTime);


        if (newRow != -1) {
            nameInput.setText("");
            addressInput.setText("");
            closeTimeInput.setText("");
            openTimeInput.setText("");
        }

        db.close();
    }
}