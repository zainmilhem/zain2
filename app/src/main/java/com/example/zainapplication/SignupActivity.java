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

public class SignupActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnSignup, btnCancel;
    private TextView tvWelcome;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmail = findViewById(R.id.editTextTextEmailAddress2);
        etPassword = findViewById(R.id.editTextTextPassword2);
        btnSignup = findViewById(R.id.button2);
        btnCancel = findViewById(R.id.button3);

        preferences = getSharedPreferences("Userinfo",0);
    }

    public void signup2(View view) {
        String input_email = etEmail.getText().toString();
        String input_password = etPassword.getText().toString();
        if (input_email.length()>0){
            //open preferences file
            SharedPreferences.Editor editor = preferences.edit();
            //save key,value data
            editor.putString("username", input_email);
            editor.putString("password", input_password);

            editor.apply();
            Toast.makeText(this,"User signed up!", Toast.LENGTH_LONG).show();
            Intent intent_main = new Intent(this,MainActivity.class);
            startActivity(intent_main);
        }else{
            Toast.makeText(this,"Empty values, please try again!", Toast.LENGTH_SHORT).show();
        }

    }


    public void cancel(View view) {
        Intent intent_main = new Intent(this,MainActivity.class);
        startActivity(intent_main);
    }
}