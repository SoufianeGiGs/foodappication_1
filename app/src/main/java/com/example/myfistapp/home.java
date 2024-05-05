package com.example.myfistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class home extends AppCompatActivity {

    ImageView x1;
    ImageView x2;
    ImageView x3;
    Button x4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        if (username != null) {
            TextView welcomeText = findViewById(R.id.nameUser);
            welcomeText.setText("Welcome, " + username + "!");
        }
        x1=findViewById(R.id.tswira3);
        x2=findViewById(R.id.tswira2);
        x3=findViewById(R.id.tswira1);
        x4=findViewById(R.id.mealButton2);
        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, settings.class);
                intent.putExtra("username", username);
                startActivity(intent);
                                 }
                             }


        );
        x2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent = new Intent(home.this, ObjectivesActivity.class);
                                      startActivity(intent);
                                  }
                              }


        );
        x3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent = new Intent(home.this, FoodActivity.class);
                                      startActivity(intent);
                                  }
                              }


        );
        x4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent = new Intent(home.this, Meals.class);
                                      startActivity(intent);
                                  }
                              }


        );


    }
}