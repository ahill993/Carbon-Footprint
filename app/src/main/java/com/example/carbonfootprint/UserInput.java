package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UserInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        findViewById(R.id.answer).setTag(0f);
        findViewById(R.id.answer2).setTag(10f);
        findViewById(R.id.answer3).setTag(20f);
        findViewById(R.id.answer4).setTag(30f);
        findViewById(R.id.answer5).setTag(40f);

        findViewById(R.id.answer6).setTag(0f);
        findViewById(R.id.answer7).setTag(10f);
        findViewById(R.id.answer8).setTag(20f);
        findViewById(R.id.answer9).setTag(30f);
        findViewById(R.id.answer10).setTag(40f);

        findViewById(R.id.answer11).setTag(0f);
        findViewById(R.id.answer12).setTag(10f);
        findViewById(R.id.answer13).setTag(20f);
        findViewById(R.id.answer14).setTag(30f);
        findViewById(R.id.answer15).setTag(40f);
    }

    public void electric(View view)
    {
       RadioGroup question1 = findViewById(R.id.radioGroup);
        RadioButton answer1 = findViewById(question1.getCheckedRadioButtonId());
        Float a = (Float) answer1.getTag();
        EmissionCalculatorTable.calculateAndRecord("type_plane", a);

        RadioGroup question2 = findViewById(R.id.radioGroup2);
        RadioButton answer2 = findViewById(question2.getCheckedRadioButtonId());
        Float b = (Float) answer2.getTag();
        EmissionCalculatorTable.calculateAndRecord("type_car", b);

        RadioGroup question3 = findViewById(R.id.radioGroup2);
        RadioButton answer3 = findViewById(question3.getCheckedRadioButtonId());
        Float c = (Float) answer3.getTag();
        EmissionCalculatorTable.calculateAndRecord("type_train", c);

        Intent next = new Intent(this, UserInput2.class);
        startActivity(next);
    }
}
