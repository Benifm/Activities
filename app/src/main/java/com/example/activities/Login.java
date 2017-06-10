package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button ok = (Button) findViewById(R.id.logOk);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.usernamelog);
                EditText password = (EditText) findViewById(R.id.passwordlog);

                String field1 = username.getText().toString();
                String field2 = password.getText().toString();

                if( !field1.isEmpty()  && !field2.isEmpty()) {
                    Intent data = getIntent();
                    data.putExtra("Username" , field1);
                    data.putExtra("Password" , field2);
                    setResult( RESULT_OK, data);
                    finish();
                }

                else {

                    username.setText("Please enter a username");
                    password.setText("And password");

                }
            }
        });


    }
}
