package com.example.mishu.vitasourcedevelop.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.mishu.vitasourcedevelop.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.emailEt) EditText emailEt;
    @Bind(R.id.passwordEt) EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.signInBt)
    public void signIn(){
       if(emailEt.getText().toString().equals("admin"))
       {
           startActivity(new Intent(MainActivity.this,Admin.class));
       }
        else if(emailEt.getText().toString().equals("leader"))
        {
            startActivity(new Intent(MainActivity.this,TeamLeader.class));
        }
       else if(emailEt.getText().toString().equals("employe"))
       {
           startActivity(new Intent(MainActivity.this,Employe.class));
       }
    }
}
