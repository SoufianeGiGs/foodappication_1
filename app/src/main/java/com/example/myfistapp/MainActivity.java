package com.example.myfistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username1;
    EditText password1;
    TextView y;
     ImageView x;
     DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new DbHelper(this);
        username1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        x = findViewById(R.id.imageView2);
        y=findViewById(R.id.register_link);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = username1.getText().toString();
                String password = password1.getText().toString();

                if (dbHelper.checkuserlogin(username,password)) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, home.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}
