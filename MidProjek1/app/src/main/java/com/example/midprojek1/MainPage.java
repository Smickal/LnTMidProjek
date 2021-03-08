package com.example.midprojek1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.midprojek1.databinding.ActivityMainPageBinding;

public class MainPage extends AppCompatActivity {
    ActivityMainPageBinding pb;
    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pb = ActivityMainPageBinding.inflate(getLayoutInflater());
        View view = pb.getRoot();
        setContentView(view);

        pb.btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}