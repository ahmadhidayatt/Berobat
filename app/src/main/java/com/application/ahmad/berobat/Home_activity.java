package com.application.ahmad.berobat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by ahmad on 20/10/17.
 */

public class Home_activity extends AppCompatActivity {
    private ImageButton home;
    private ImageButton login;
    private ImageButton regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        home=(ImageButton)findViewById(R.id.home);
        login=(ImageButton)findViewById(R.id.login);
        regist=(ImageButton)findViewById(R.id.registration);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("home");
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("login");
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("register");
            }
        });


    }

   public void move (String type){
       Intent mainIntent = new Intent(Home_activity.this,MainActivity.class);
       Bundle extras = new Bundle();
       extras.putString("type", type);
       mainIntent.putExtras(extras);
       Home_activity.this.startActivity(mainIntent);
       Home_activity.this.finish();
    }



}
