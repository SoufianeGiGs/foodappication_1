package com.example.myfistapp;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageView x;
    private EditText nameEditText, phoneEditText, emailEditText, passwordEditText,confirmEditpassword;

    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);
        dbHelper = new DbHelper(this);
        x = findViewById(R.id.imageView2);
        nameEditText = findViewById(R.id.Name);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmEditpassword=findViewById(R.id.confirm_password);



        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirm_password = confirmEditpassword.getText().toString();

                if (name.equals("") || phone.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity2.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
                    return; // Exit the function if any field is empty
                }

                if (!password.equals(confirm_password)) {
                    Toast.makeText(MainActivity2.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                    return; // Exit the function if passwords don't match
                }

                if (dbHelper.checkUsername(name)) {
                    Toast.makeText(MainActivity2.this, "Username already Exists.", Toast.LENGTH_LONG).show();
                    return; // Exit the function if username exists
                }

                // Insert data into database only if all checks pass
                boolean check = dbHelper.insertData(name, phone, email, password);
                if (check) {
                    Toast.makeText(MainActivity2.this, "Registration successful!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "User registration failed, try again!", Toast.LENGTH_LONG).show();
                }
            }
        });





    }}