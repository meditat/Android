package com.example.shiva.facebookclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] names;
    int[] profileImage;
    int[] time;
    String[] mainPost;
    String[] whoLiked;
    int[] mainPostImage;

    public CustomAdapter(Context context, String[] names, int[] profileImage, int[] time, String[] mainPost, String[] whoLiked, int[] mainPostImage) {
        this.context = context;
        this.names = names;
        this.profileImage = profileImage;
        this.time = time;
        this.mainPost = mainPost;
        this.whoLiked = whoLiked;
        this.mainPostImage = mainPostImage;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.custom ,viewGroup , false);
        TextView name = view.findViewById(R.id.name);
        TextView time = view.findViewById(R.id.timeInfo);
        ImageView profileImage = view.findViewById(R.id.profileImage);
        TextView mainPost = view.findViewById(R.id.textPost);
        ImageView mainPostImage = view.findViewById(R.id.mainPostImage);
        TextView whoLiked = view.findViewById(R.id.liker);
        TextView commentNum = view.findViewById(R.id.commentNumber);

        name.setText(names[i]);
        time.setText(this.time[i] +context.getString(R.string.hours_ago));
        profileImage.setImageResource(this.profileImage[i]);
        mainPost.setText(this.mainPost[i]);
        mainPostImage.setImageResource(this.mainPostImage[i]);
        whoLiked.setText(this.whoLiked[i]);
        commentNum.setText(this.time[i]+" Comments");
        return view;
    }
}
