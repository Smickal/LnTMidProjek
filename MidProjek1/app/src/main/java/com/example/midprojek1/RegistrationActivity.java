package com.example.midprojek1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.midprojek1.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding rb;
    String username;
    String email;
    String password;


    String tempUser;
    String tempEmail;
    String tempPass;
    String tempConfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rb = ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view = rb.getRoot();
        setContentView(view);

        rb.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);

                tempUser = rb.etUsername.getEditableText().toString();
                tempEmail = rb.etEmail.getEditableText().toString();
                tempPass = rb.etPassword.getEditableText().toString();
                tempConfPass = rb.etConfPass.getEditableText().toString();

                Boolean checkPass = false;
                Boolean checkUser = false;
                Boolean checkEmail = false;

                if (tempUser.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please Insert Username", Toast.LENGTH_SHORT).show();
                    checkUser = false;
                } else {
                    checkUser = true;
                }

                if (tempConfPass.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please Insert Confirmation Password", Toast.LENGTH_SHORT).show();
                    checkPass = false;
                }

                if (tempPass.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please Insert Password", Toast.LENGTH_SHORT).show();
                    checkPass = false;
                }
                if (tempEmail.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please Insert Email", Toast.LENGTH_SHORT).show();
                    checkEmail = false;
                } else {
                    checkEmail = true;
                }

                checkPass = tempPass.equals(tempConfPass);
                if(!checkPass){
                    Toast.makeText(RegistrationActivity.this, "Your password isn't same", Toast.LENGTH_SHORT).show();
                }

                if(checkEmail && checkPass  && checkUser){
                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    password = tempPass;
                    email = tempEmail;
                    username = tempUser;
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    intent.putExtra("email", email);
                    setResult(RESULT_OK,intent);
                    finish();
                }


            }
        });
    }
}