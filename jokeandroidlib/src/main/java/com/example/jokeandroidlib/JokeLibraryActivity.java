package com.example.jokeandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeLibraryActivity extends AppCompatActivity {

    private static final String JOKE = "joke";
    private String joke;
    private String LOG_TAG = JokeLibraryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        if (getIntent() != null) {
            Intent intent = getIntent();
            joke = intent.getStringExtra(JOKE);
        }
        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }
}
