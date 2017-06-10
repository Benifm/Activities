package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected final int REG_CODE = 1;
    protected final int LOG_CODE = 2;
    String X1, X2, Y1, Y2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register = (Button) findViewById(R.id.register);
        Button login = (Button) findViewById(R.id.login);
        Button info = (Button) findViewById(R.id.info);
        Button exit = (Button) findViewById(R.id.out);


        Toast.makeText( this, "Welcome!", Toast.LENGTH_LONG).show();

        register.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent changeActivity = new Intent(MainActivity.this, Reg.class);
                startActivityForResult(changeActivity, REG_CODE);





        }


        });

        login.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent changeActivity = new Intent(MainActivity.this, Login.class);
                startActivityForResult(changeActivity, LOG_CODE);





            }


        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeActivity = new Intent(MainActivity.this, Info.class);
                startActivity( changeActivity);

            }
        });



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    @Override
    protected void onActivityResult(int req, int res, Intent data) {

        if (req == REG_CODE) {
            if (res == RESULT_OK) {
                String usernameset = data.getStringExtra("Username");
                String passwordset = data.getStringExtra("Password");
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show();
                X1 = usernameset;
                Y1 = passwordset;

            }
        }


        if (req == LOG_CODE) {
            if (res == RESULT_OK) {
                String usernamelog = data.getStringExtra("Username");
                String passwordlog = data.getStringExtra("Password");
                X2 = usernamelog;
                Y2 = passwordlog;
                if( X1.equals(X2)  && Y1.equals(Y2)){
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show();
            } else {
                    Toast.makeText(this, "Login unsuccessful!", Toast.LENGTH_LONG).show();
                }
        }
    }
    }





}
