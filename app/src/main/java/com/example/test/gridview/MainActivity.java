package com.example.test.gridview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView myGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGrid = (GridView) findViewById(R.id.gridview);
        myGrid.setAdapter(new milAdapter(this));
    }
}

class SingleItem {
    int imageId;
    String countryName;

    SingleItem(int imageId, String countryName) {
        this.imageId = imageId;
        this.countryName = countryName;
    }
}


class milAdapter extends BaseAdapter {
    ArrayList<SingleItem> list;
    Context context;


    milAdapter(Context context) {
        this.context = context;
        list = new ArrayList<SingleItem>();
        Resources res = context.getResources();
        String[] countrynames = res.getStringArray(R.array.Country);
        int[] countryimages = {R.drawable.a, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};
        for (int i = 0; i < 10; i++) {
            SingleItem tempCountry = new SingleItem(countryimages[i], countrynames[i]);
            list.add(tempCountry);
        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class viewHolder {
        ImageView myCountry;

        viewHolder(View v) {
            myCountry = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        viewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new viewHolder(row);
            row.setTag(holder);

        }
        else {
            holder = (viewHolder) row.getTag();


        }
        SingleItem temp = list.get(position);
        holder.myCountry.setImageResource(temp.imageId);


        return row;
    }
}
