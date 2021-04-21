package com.brijlathia.mobilequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import android.widget.EditText;

import com.brijlathia.mobilequiz.helper.Backgroundworker;

public class Login extends AppCompatActivity {
    EditText etusername, etpassword, etusertype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusername=(EditText)findViewById(R.id.usertxt);
        etpassword=(EditText)findViewById(R.id.passtxt);
    }
    public void OnLogin(View view)
    {
        String username=etusername.getText().toString();
        String password=etpassword.getText().toString();
        String type="login";
        Backgroundworker backgroundworker = new Backgroundworker(this);
        backgroundworker.execute(type, username, password);
        if(view.getId() == R.id.signinbtn)
        {
            Intent k =new Intent(Login.this, MainActivity.class);
            startActivity(k);
        }
    }
    public void OnButtonClick(View v)
    {
        if(v.getId() == R.id.signupbtn)
        {
            Intent i = new Intent(Login.this, Register.class);
            startActivity(i);
        }
    }

}
