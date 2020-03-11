package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import java.util.Hashtable;
import java.util.Iterator;

import static java.lang.Integer.valueOf;

public class ResultsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenheight = displayMetrics.heightPixels;
        int screenwidth = displayMetrics.widthPixels;

        Hashtable<String, Integer> emissionStats = new Hashtable();
        emissionStats.put("Car", 100);
        emissionStats.put("Plane", 200);
        emissionStats.put("Volcano Lair", 50);
        emissionStats.put("Mobile Apps", 75);

        addPie(emissionStats, screenwidth, screenheight);
        addBar(emissionStats, screenwidth, screenheight);
        addTable(emissionStats, screenwidth, screenheight);

        addTotal(emissionStats);


    }

    private void addPie(Hashtable ht, int screenwidth, int screenheight) {
        PieChart pie = new PieChart(this);
        pie.setData(ChartFiller.fillPieChart(ht, this));
        pie.setMinimumWidth(screenwidth);
        pie.setMinimumHeight(screenheight / 2);

        LinearLayout container = findViewById(R.id.layout);
        container.addView(pie);
    }

    private void addBar(Hashtable ht, int screenwidth, int screenheight) {
        BarChart bar = new BarChart(this);
        bar.setData(ChartFiller.fillBarChart(ht, this));
        bar.setMinimumWidth(screenwidth);
        bar.setMinimumHeight(screenheight / 2);
        LinearLayout container = findViewById(R.id.layout);
        container.addView(bar);
    }

    private void addTable(Hashtable<String, Integer> ht, int screenwidth, int screenheight) {
        TableLayout table = new TableLayout(this);
        Iterator<String> iterator = ht.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = ht.get(key);
            TableRow row = new TableRow(this);
            TextView label = new TextView(this);
            TextView number = new TextView(this);
            label.setText(key);

            number.setText(value.toString());
            row.addView(label);
            row.addView(number);
            table.addView(row);
        }
        LinearLayout container = findViewById(R.id.layout);
        container.addView(table);
    }

    private void addTotal(Hashtable<String, Integer> ht) {
        double n = 0;
        Iterator<String> iterator = ht.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = ht.get(key);
            n = n + value;
        }
        TextView label = findViewById(R.id.textTotal);
        label.setText("Total CO2 Emissions: " +n+ "kg");
    }
}