package com.ujjwal.instagram.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ujjwal.instagram.LoginApi;
import com.ujjwal.instagram.R;
import com.ujjwal.instagram.Url;
import com.ujjwal.instagram.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnLoginWithFb;
    EditText username, password;
    TextView signup, forgot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        signup = findViewById(R.id.tvSignUp);
        forgot = findViewById(R.id.tvHelpSignIn);
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginWithFb = findViewById(R.id.btnLoginWithFb);

        signup.setOnClickListener(this);
        forgot.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnLoginWithFb.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvSignUp:
                openSignUp();
                break;
            case R.id.tvHelpSignIn:
                Toast.makeText(this, "Go to Change Password", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnLoginWithFb:
                Toast.makeText(this, "Login with facebook", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void login(){
        UserModel userLogin = new UserModel(username.getText().toString(), password.getText().toString());

        LoginApi loginApi = Url.getInstance().create(LoginApi.class);
        Call<Void> loginCall =loginApi.login(userLogin);

        loginCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                openDashBoard();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error " + t.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDashBoard(){
        Intent openDash = new Intent(this, MainActivity.class);
        startActivity(openDash);
    }

    public void openSignUp(){
        Intent openSignup = new Intent(this, RegisterActivity.class);
        startActivity(openSignup);
    }

}
