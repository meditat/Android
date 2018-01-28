package com.example.shiva.costom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context context;
    String[] names;
    String[] info;
    int[] images;


    public MyAdapter(Context context, String[] names, String[] info, int[] images) {
        this.context = context;
        this.names = names;
        this.info = info;
        this.images = images;
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
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.custom,viewGroup,false);
        TextView nameView=view.findViewById(R.id.mainInfo);
        TextView infoView=view.findViewById(R.id.subInfo);
        ImageView imageView=view.findViewById(R.id.imageView);

        nameView.setText(names[i]);
        infoView.setText(info[i]);
        imageView.setImageResource(images[i]);

        return view;
    }
}
