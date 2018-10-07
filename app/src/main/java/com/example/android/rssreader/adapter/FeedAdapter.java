package com.example.android.rssreader.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.rssreader.R;
import com.prof.rssparser.Article;

import java.util.ArrayList;

public class FeedAdapter extends ArrayAdapter<Article> {
    public FeedAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Article> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Article article = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.article_list_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.txt_title)).setText(article.getTitle());
        ((TextView) convertView.findViewById(R.id.txt_pub_date)).setText(article.getTitle());
        return convertView;

    }
}
