package com.example.android.rssreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String URL;
    public static final String FEED_URL = "FEED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_diario_libre).setOnClickListener(this);
        findViewById(R.id.btn_wired).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_diario_libre) {
            URL = "https://www.diariolibre.com/rss/portada.xml";

        } else {
            URL = "https://www.wired.com/feed/rss";

        }
        Intent intent = new Intent(getApplicationContext(),ListFeedActivity.class);
        intent.putExtra(FEED_URL, URL);
        startActivity(intent);


    }

}
