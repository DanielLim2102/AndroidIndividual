package com.example.danie.daniel2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danie on 26/11/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Content> mData;

    public RecyclerViewAdapter(Context mContext, List<Content> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_content_title.setText(mData.get(position).getTitle());
        holder.img_content_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //passing data to the content activity
                Intent intent = new Intent(mContext,Content_Activity.class);
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Category", mData.get(position).getCategory());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Serving", mData.get(position).getServing());
                intent.putExtra("Difficulty", mData.get(position).getDifficulty());
                intent.putExtra("Prep", mData.get(position).getPrep());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                mContext.startActivity(intent);
            //    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(RecyclerViewAdapter.this,ViewCompat.getTransitionName(m));
             //   mContext.startActivity(intent,options.toBundle());
            }
        });



    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
//    public void filterlist(ArrayList<Content> filteredlist){
//        mData = filteredlist;
//        notifyDataSetChanged();
//
//    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_content_title;
        ImageView img_content_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_content_title = (TextView) itemView.findViewById(R.id.content_title_id);
            img_content_thumbnail = (ImageView) itemView.findViewById(R.id.content_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
