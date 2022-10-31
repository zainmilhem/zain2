package com.example.zainapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editEmail,editPassword;
    Button buttonLogin,buttonsignup;
    TextView textViewresult;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editTextTextEmailAddress);
        editPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonsignup = findViewById(R.id.buttonsignup);

        sharedPreferences = getSharedPreferences("user_info",0);
    }
    public void login(View view){
        //this line gets the registered email and password, in case no user was registered empty string is returned
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");

        String etEmail = editEmail.getText().toString();
        String etPass = editPassword.getText().toString();

        if (email.equals(etEmail) && password.equals(etPass)){
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Error! wrong email or password", Toast.LENGTH_LONG).show();
        }
    }
    public void signup(View view){

        Intent i_signup = new Intent(this,SignupActivity.class);
        startActivity(i_signup);

        String etEmail = editEmail.getText().toString();
        String etPass = editPassword.getText().toString();
        //saves the email value in the prefrences and commits the file
        sharedPreferences.edit().putString("email",etEmail).apply();
        sharedPreferences.edit().putString("pasword",etPass).apply();

    }


}