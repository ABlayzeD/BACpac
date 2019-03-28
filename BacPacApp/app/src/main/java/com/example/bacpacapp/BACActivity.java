package com.example.bacpacapp;

import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.text.BreakIterator;

import static android.os.SystemClock.elapsedRealtime;
import static android.os.SystemClock.sleep;

public class BACActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);
        ProgressBar BACProgressBar = (ProgressBar) findViewById(R.id.BACprogress);
        BACProgressBar.setMax(500);



    }
    /*
    public class DelayTask extends AsyncTask<Void, Integer, String> {
        int count = 0;
        @Override
        protected String doInBackground(Integer... params) {
            for (; count <= params[0]; count++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Task Completed.";
        }
        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            txt.setText(result);
            btn.setText("Restart");
        }
        @Override
        protected void onPreExecute() {
            txt.setText("Task Starting...");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            txt.setText("Running..."+ values[0]);
            progressBar.setProgress(values[0]);
        }
    }
    }
    */

}
