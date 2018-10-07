package com.example.android.rssreader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.android.rssreader.adapter.FeedAdapter;
import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;

public class ListFeedActivity extends AppCompatActivity {

    public static final String KEY = "WEB_VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_feed);
        String url = getIntent().getExtras().getString(MainActivity.FEED_URL);
        Parser parser = new Parser();
        final ListView listView = findViewById(R.id.list_feed);
//        final ProgressBar progressBar = findViewById(R.id.progress_bar);
//        final ProgressBar progressBar = findViewById(R.id.progress_bar);

        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> arrayList) {

//                progressBar.setVisibility(View.GONE);
                listView.setAdapter(new FeedAdapter(getApplicationContext(), R.layout.activity_list_feed, arrayList));
            }

            @Override
            public void onError() {

            }
        });
        parser.execute(url);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Article article = (Article) parent.getItemAtPosition(position);
                if ((position + 1) % 2 == 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getLink()));
                    startActivity(browserIntent);

                } else {
                    Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                    intent.putExtra(KEY, article.getLink());
                    startActivity(intent);
                }
            }
        });
    }

}
