package com.example.myfistapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myfistapp.databinding.ActivitySettingsBinding;

public class settings extends AppCompatActivity {

    private DbHelper dbHelper;
    private TextView nameTextView;
    private TextView phoneTextView;
    private TextView emailTextView;
    private TextView passwordTextView;
    private ImageView x;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        dbHelper = new DbHelper(this);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        x = findViewById(R.id.imageView2);
        nameTextView = findViewById(R.id.Name);
        phoneTextView = findViewById(R.id.phone);
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);

        // Retrieve values from database and set them in TextViews
        String name = dbHelper.getNameForUser(username);
        String phone = dbHelper.getPhoneForUser(username);
        String email = dbHelper.getEmailForUser(username);
        String password = dbHelper.getPasswordForUser(username);

        nameTextView.setText(name);
        phoneTextView.setText(phone);
        emailTextView.setText(email);
        passwordTextView.setText(password);

        Button updateButton = findViewById(R.id.button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserInfo();
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, home.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });}

    private void updateUserInfo() {
        String newName = nameTextView.getText().toString();
        String newPhone = phoneTextView.getText().toString();
        String newEmail = emailTextView.getText().toString();
        String newPassword = passwordTextView.getText().toString();

        boolean updated = dbHelper.updateUser(username, newName, newPhone, newEmail, newPassword);
        if (updated) {
            Snackbar.make(findViewById(android.R.id.content), "User information updated successfully", Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Failed to update user information", Snackbar.LENGTH_SHORT).show();
        }
    }
}
