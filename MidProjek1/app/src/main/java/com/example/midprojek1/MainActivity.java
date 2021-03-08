package com.example.midprojek1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.midprojek1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mb;
    String tempUser = null;
    String tempPass = null;
    String username = "Not Found";
    String password = "Not Found";
    Integer ctr = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mb.getRoot();
        setContentView(view);

        mb.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tempUser = mb.etUsername.getEditableText().toString();
                tempPass = mb.etPassword.getEditableText().toString();

                Boolean CheckUser = tempUser.equals(username);
                Boolean CheckPass = tempPass.equals(password);



                if (tempUser.isEmpty() && tempPass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Insert Username and Password", Toast.LENGTH_SHORT).show();

                }else if(tempUser.isEmpty() && !tempPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Insert Username", Toast.LENGTH_SHORT).show();
                }else if(tempPass.isEmpty() && !tempUser.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Insert Password", Toast.LENGTH_SHORT).show();
                }

                if(CheckUser && CheckPass) {
                    Toast.makeText(MainActivity.this, "Wrong user or password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong user or password", Toast.LENGTH_SHORT).show();
                }

            }

        });

        mb.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), RegistrationActivity.class), 999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            username =  data.getStringExtra("username");
            password  =  data.getStringExtra("password");
        }

        mb.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,  MainPage.class);

                tempUser = mb.etUsername.getEditableText().toString();
                tempPass = mb.etPassword.getEditableText().toString();

                Boolean CheckUser = tempUser.equals(username);
                Boolean CheckPass = tempPass.equals(password);

                if (tempUser.isEmpty() && tempPass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Insert Username and Password", Toast.LENGTH_SHORT).show();

                }else if(tempUser.isEmpty() && !tempPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Insert Username", Toast.LENGTH_SHORT).show();
                }else if(tempPass.isEmpty() && !tempUser.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Insert Password", Toast.LENGTH_SHORT).show();
                }

                if(CheckUser && CheckPass) {
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "LOGIN FAILED!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

