package com.example.faustin_12.retrofitsample.adapter;

/**
 * Created by FAUSTIN-12 on 02/07/2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.faustin_12.retrofitsample.R;
import com.example.faustin_12.retrofitsample.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Article> articles;
    private Context mContext;

    public DataAdapter(Context context, ArrayList<Article> android) {
        this.articles = android;
        this.mContext = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(articles.get(i).getTitle());
        viewHolder.description.setText(articles.get(i).getDescription());
        viewHolder.time.setText(articles.get(i).getPubDate());
        viewHolder.author.setText(articles.get(i).getAuthor());

        if (articles.get(i).getEnclosure().getLink() == "")
            articles.get(i).getEnclosure().setLink("http://www.slate.com/content/dam/slate/articles/health_and_science/science/2015/07/150730_SCI_Cecil_lion.jpg.CROP.promo-xlarge2.jpg");

        Glide.with(mContext).load(articles.get(i).getEnclosure().getLink())
                .fallback(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(viewHolder.icom);

        //viewHolder.title.setText(articles.get(i).getTitle());
        //viewHolder.description.setText(articles.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title, description, time, author;
        private ImageView icom;
        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.list_item_title);
            description = (TextView)view.findViewById(R.id.list_item_description);
            time = (TextView)view.findViewById(R.id.time);
            author = (TextView)view.findViewById(R.id.author);
            icom = (ImageView) view.findViewById(R.id.list_item_icon);

        }
    }

}