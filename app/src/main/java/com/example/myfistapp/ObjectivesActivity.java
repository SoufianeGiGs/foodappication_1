package com.example.myfistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ObjectivesActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private TextView healthStatusTextView;
    private TextView proteinNeedsTextView;
    private TextView calorieNeedsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectives);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        ageEditText = findViewById(R.id.ageEditText);
        healthStatusTextView = findViewById(R.id.healthStatusTextView);
        proteinNeedsTextView = findViewById(R.id.proteinNeedsTextView);
        calorieNeedsTextView = findViewById(R.id.calorieNeedsTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResults();
            }
        });
    }

    private void calculateAndDisplayResults() {
        // Get user input
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString());
        int age = Integer.parseInt(ageEditText.getText().toString());

        // Calculate BMI (Body Mass Index)
        double bmi = calculateBMI(weight, height);
        Log.d("BMI", "BMI: " + bmi);

        // Determine health status based on BMI
        String healthStatus = getHealthStatus(bmi);
        healthStatusTextView.setText("Health Status: " + healthStatus);
        Log.d("HealthStatus", "Health Status: " + healthStatus);

        // Calculate protein and calorie needs
        double proteinNeeds = calculateProteinNeeds(weight);
        double calorieNeeds = calculateCalorieNeeds(weight, height, age);

        proteinNeedsTextView.setText("Protein Needs: " + proteinNeeds + " grams per day");
        Log.d("ProteinNeeds", "Protein Needs: " + proteinNeeds);

        calorieNeedsTextView.setText("Calorie Needs: " + calorieNeeds + " calories per day");
        Log.d("CalorieNeeds", "Calorie Needs: " + calorieNeeds);
    }


    private double calculateBMI(double weight, double height) {
        // Convert height to meters
        double heightInMeters = height / 100; // Assuming height is in centimeters
        // Calculate BMI using weight (kg) and height (m)
        return weight / (heightInMeters * heightInMeters);
    }


    private String getHealthStatus(double bmi) {
        // Determine health status based on BMI
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private double calculateProteinNeeds(double weight) {
        return Double.parseDouble(new DecimalFormat("#.##").format(weight*0.8));
    }

    private double calculateCalorieNeeds(double weight, double height, int age) {
        double result = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        return Double.parseDouble(new DecimalFormat("#.##").format(result));
    }

}
