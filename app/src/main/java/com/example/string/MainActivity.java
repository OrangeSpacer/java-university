package com.example.string;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button reverseBtn = findViewById(R.id.btn_reverse);
        Button deleteVowelsBtn = findViewById(R.id.delete_vowels);
        Button changeRegisterBtn = findViewById(R.id.change_register_even);
        EditText editText = findViewById(R.id.editText);
        TextView textViewFirst = findViewById(R.id.text);

        reverseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("string_app_tag", "Click reverse btn");
                Editable newWord = editText.getText();
                textViewFirst.setText(new StringBuilder(newWord).reverse().toString());
            }
        });
        deleteVowelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("string_app_tag", "Click delete vowels btn");
                Editable newWord = editText.getText();
                textViewFirst.setText(newWord.toString().replaceAll("[AEIOUaeiou]", ""));
            }
        });
        changeRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("string_app_tag", "Click change register btn");
                String newWord = editText.getText().toString();
                StringBuilder sb = new StringBuilder(newWord);
                for(int i = 0;i < sb.length(); i++) {
                    char c = sb.charAt(i);
                    if(i%2 == 0 && Character.isLetter(c)) {
                        sb.setCharAt(i , Character.toUpperCase(c));
                    }
                }
                textViewFirst.setText(sb.toString());
            }
        });


    }
}