package com.example.firstjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConvertClicked(View v){
        EditText dollarText = (EditText) findViewById(R.id.editTextNumber);
        EditText poundText = (EditText) findViewById(R.id.editTextNumber2);

        if(dollarText.getText().toString().length() > 0){
            float dollars = Float.parseFloat(dollarText.getText().toString());
            float pounds = calculatePounds(dollars);
            poundText.setText(Float.toString(pounds));

        }else if(poundText.getText().toString().length() > 0){
            float pounds = Float.parseFloat(poundText.getText().toString());
            float dollars = calculateDollars(pounds);
            dollarText.setText(Float.toString(dollars));

        }else{
            //Pop up Invalid Data - Try Again
            Snackbar.make(v, "Invalid Data - Try Again",
                    Snackbar.LENGTH_SHORT).show();
        }
    }

    public void onClearClicked(View v){
        EditText dollarText = (EditText) findViewById(R.id.editTextNumber);
        EditText poundText = (EditText) findViewById(R.id.editTextNumber2);

        dollarText.getText().clear();
        poundText.getText().clear();
    }

    public void onDollarClicked(View v){
        EditText poundText = (EditText) findViewById(R.id.editTextNumber2);
        poundText.getText().clear();
    }

    public void onPoundClicked(View v){
        EditText dollarText = (EditText) findViewById(R.id.editTextNumber);
        dollarText.getText().clear();
    }

    public float calculateDollars(float pounds){
        return pounds/31;
    }

    public float calculatePounds(float dollars){
        return dollars*31;
    }
}