package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UserInput2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input2);
        findViewById(R.id.answer16).setTag(0f);
        findViewById(R.id.answer17).setTag(10f);
        findViewById(R.id.answer18).setTag(20f);
        findViewById(R.id.answer19).setTag(30f);
        findViewById(R.id.answer20).setTag(40f);

        findViewById(R.id.answer21).setTag(0f);
        findViewById(R.id.answer22).setTag(10f);
        findViewById(R.id.answer23).setTag(20f);
        findViewById(R.id.answer24).setTag(30f);
        findViewById(R.id.answer25).setTag(40f);

        findViewById(R.id.answer26).setTag(0f);
        findViewById(R.id.answer27).setTag(10f);
        findViewById(R.id.answer28).setTag(20f);
        findViewById(R.id.answer29).setTag(30f);
        findViewById(R.id.answer30).setTag(40f);
    }

    public void facility(View view)
    {
        RadioGroup question1 = findViewById(R.id.radioGroup4);
        RadioButton answer1 = findViewById(question1.getCheckedRadioButtonId());
        Float a = (Float) answer1.getTag();
        EmissionCalculatorTable.calculateAndRecord("type_computer", a);

        RadioGroup question2 = findViewById(R.id.radioGroup5);
        RadioButton answer2 = findViewById(question2.getCheckedRadioButtonId());
        Float b = (Float) answer2.getTag();
        EmissionCalculatorTable.calculateAndRecord("type_phone", b);

        RadioGroup question3 = findViewById(R.id.radioGroup6);
        RadioButton answer3 = findViewById(question3.getCheckedRadioButtonId());
        Float c = (Float) answer3.getTag();
        EmissionCalculatorTable.calculateAndRecord("type_air_conditioning", c);


        Intent facility = new Intent(this, ResultsPage.class);
        startActivity(facility);
    }
}
