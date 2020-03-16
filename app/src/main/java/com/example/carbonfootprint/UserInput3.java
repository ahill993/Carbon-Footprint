package com.example.carbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UserInput3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input3);
    }

    public void results(View view)
    {
        Intent result = new Intent(this, ResultsPage.class);
        startActivity(result);
    }
}
