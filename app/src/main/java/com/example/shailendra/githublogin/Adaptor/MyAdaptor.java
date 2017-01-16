package com.example.shailendra.githublogin.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shailendra.githublogin.Model.RepositraryDetails;
import com.example.shailendra.githublogin.R;

import java.util.List;

/**
 * Created by shailendra on 1/15/2017.
 */

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {

    private List<RepositraryDetails> repositraryList;
    RepositraryDetails repositraryDetails;
    Context context;
    int newPosition;
    final public ListItemClickListener listItemClickListener;

    public  interface ListItemClickListener{
        void onItemClick(String url);
    }
    public MyAdaptor(Context context,List<RepositraryDetails> repositraryList,ListItemClickListener listItemClickListener) {
        this.context = context;
        this.listItemClickListener = listItemClickListener;
        this.repositraryList = repositraryList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repositaryrow, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        newPosition = position;
        repositraryDetails = repositraryList.get(position);
        holder.name.setText(repositraryDetails.getFull_name());
        holder.desc.setText(repositraryDetails.getDesc());
        holder.url.setText(repositraryDetails.getUrl());


    }

    @Override
    public int getItemCount() {
        return repositraryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, desc, url;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_name);
            desc = (TextView) view.findViewById(R.id.tv_desc);
            url = (TextView) view.findViewById(R.id.tv_url);
            cardView = (CardView) view.findViewById(R.id.cardView);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            repositraryDetails = repositraryList.get(newPosition);
            String url = repositraryDetails.getUrl();
            listItemClickListener.onItemClick(url);
        }
    }
}

