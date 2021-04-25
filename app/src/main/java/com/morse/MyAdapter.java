package com.morse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class MyAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> rTitle = new ArrayList<>();
    List<String> rDescription;
    List<Integer> rImgs;

    MyAdapter(Context c, List<String> title, List<String> description, List<Integer> imgs) {
        super(c, R.layout.content_scrolling, R.id.textView1, title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = description;
        this.rImgs = imgs;
    }

    public void addAll(List<Channel> channels){
        for(Channel channel : channels){
            rTitle.add(channel.getName());
            rDescription.add(channel.getDescription());
            rImgs.add(channel.getImage());
        }
    }

    public void add(Channel channel){
        rTitle.add(channel.getName());
        rDescription.add(channel.getDescription());
        rImgs.add(channel.getImage());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.content_scrolling, parent, false);
        ImageView images = row.findViewById(R.id.image);
        TextView myTitle = row.findViewById(R.id.textView1);
        TextView myDescription = row.findViewById(R.id.textView2);

        // now set our resources on views
        images.setImageResource(rImgs.get(position));
        myTitle.setText(rTitle.get(position));
        myDescription.setText(rDescription.get(position));
        return row;
    }

    @Override
    public String getItem(int position){
        return rTitle.get(position);
    }
}

