package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jokeandroidlib.JokeLibraryActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask.TaskCompleteListener;

import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity implements TaskCompleteListener {

    private static final String JOKE = "joke";
    private AdView mAdView;
    private ProgressBar spinner;
    private EndpointsAsyncTask.TaskCompleteListener listener;
    private String LOG_TAG = MainActivity.class.getSimpleName();
    private Button button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.instructions_text_view);
        button = findViewById(R.id.button);

        MobileAds.initialize(this, "ca-app-pub-3191327484745759~7293798133");
        spinner = (ProgressBar) findViewById(R.id.progressBar1);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void jokeTeller(View v) {
        new EndpointsAsyncTask(this).execute(this);

        spinner.setVisibility(View.VISIBLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTaskComplete(String result) {
        Intent intent = new Intent(this, JokeLibraryActivity.class);
        intent.putExtra(JOKE, result);
        Log.v(LOG_TAG, "joke is " + result + " " + intent);
        startActivity(intent);
        spinner.setVisibility(View.GONE);
    }


}