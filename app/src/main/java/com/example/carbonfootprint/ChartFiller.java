package com.example.carbonfootprint;

import android.content.Context;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;


/*
Class for filling up charts with data from hashtables
 */
public class ChartFiller {

    public static int[] colorset(){
        return new int[]{R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent};
    }

    public static PieData fillPieChart(Hashtable<String,Integer> ht, Context context){
        PieData output = new PieData();
        ArrayList<PieEntry> stats = new ArrayList<>();
        Iterator<String> iterator = ht.keySet().iterator();
        while(iterator.hasNext()){ String key = iterator.next();
            Integer value = ht.get(key);
            stats.add(new PieEntry(value,key));
        }
    PieDataSet dset = new PieDataSet(stats,"");
        dset.setColors(colorset(),context);
        output.setDataSet(dset);

        return(output);
    }

    public static BarData fillBarChart(Hashtable<String,Integer> ht,Context context){
        BarData output = new BarData();
        Iterator<String> iterator = ht.keySet().iterator();
        int i;
        i=0;
        while(iterator.hasNext()){ String key = iterator.next();
            Integer value = ht.get(key);
            ArrayList<BarEntry> stats = new ArrayList<>();
            stats.add(new BarEntry(i,(Integer) value));
            BarDataSet dset = new BarDataSet(stats, key);
            int n = i % colorset().length;
            int[] color = new int[]{colorset()[n]};
            dset.setColors(color,context);
            output.addDataSet(dset);
            i++;}
        return(output);
    }
}
