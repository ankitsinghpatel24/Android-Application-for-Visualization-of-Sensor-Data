package com.example.visualizationofsensordata;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Activity24 extends AppCompatActivity {

    private TextView max_temp, avg_temp, min_temp;

    private LineChart mchart;
    private LineDataSet set1;
    private LineData data;
    private ArrayList<ILineDataSet> dataSets;
    private float compare, u, max, avg, min1, max1 = 0f;
    private float u1 = 1f;
    private float min = 3000f;
    private float compare2 = 3001f;
    private int change = 0;
    private Activity activity = getParent();

    private Boolean endloop = true;

    private final String  node = "node1";
    private final String path = "http://10.117.156.20:521/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_24);


//linechart
        mchart = findViewById(R.id.chart1);
        mchart.setDragEnabled(true);
        mchart.setScaleEnabled(false);
        mchart.getAxisRight().setEnabled(false);
        //YAxis yAxis =mchart.getAxisLeft();
        //yAxis.setAxisMaximum(25);
        //yAxis.setAxisMinimum(5);
        mchart.getXAxis().setEnabled(false);
        mchart.setDrawBorders(true);
        mchart.setDescription(null);

        ArrayList<Entry> yvalues = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Do your task
                String dummy = "dii";
                RequestBody formbody = new FormBody.Builder().add("sample", dummy).build();
                Request request = new Request.Builder().url(path + node).post(formbody).build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // Toast.makeText(v.getContext(), "server down", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String g = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                float u = Float.valueOf(g);
                                compare = u;
                                compare2 = compare;
                                yvalues.add(new Entry(change, u));
                                change = change + 1;
                                LineDataSet set1 = new LineDataSet(yvalues, "Temperature °C");
                                // set1.setFillAlpha(110);
                                set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                                set1.setCubicIntensity(0.2f);
                                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                                dataSets.add(set1);
                                mchart.moveViewToX(500);
                                LineData data = new LineData(dataSets);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    set1.setColors(Color.LTGRAY);
                                }
                                mchart.setScaleEnabled(true);
                                mchart.setPinchZoom(true);
                                mchart.setVisibleXRangeMaximum(25);
                                mchart.getCenterOfView();
                                mchart.moveViewTo(change, u, YAxis.AxisDependency.LEFT);
                                mchart.notifyDataSetChanged();
                                mchart.invalidate();
                                set1.setLineWidth(2f);
                                set1.setValueTextSize(0);
                                set1.setDrawCircles(false);
                                mchart.setData(data);

                            }
                        });
                        response.close();

                    }
                });

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1500);
    }

}



