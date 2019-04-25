package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.jokeandroidlib.JokeLibraryActivity;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.TaskCompleteListener {

    private static final String JOKE = "joke";
    private ProgressBar spinner;

    private String LOG_TAG = MainActivity.class.getSimpleName();
    private Button button;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.instructions_text_view);
        button = findViewById(R.id.button);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);

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

    public void jokeTeller(View view) {
        new EndpointsAsyncTask(this).execute(this);
        tv.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTaskComplete(String result) {
        Intent intent = new Intent(this, JokeLibraryActivity.class);
        intent.putExtra(JOKE, result);
        startActivity(intent);
        spinner.setVisibility(View.GONE);
    }


}
