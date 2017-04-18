package com.example.sky_phase.mobattend;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SKY-PHASE on 4/16/2017.
 */

public class CustomAdapterToPopulate extends CursorAdapter {
    TextView namesearch, idsearch;
    private LayoutInflater mInflater;

    public CustomAdapterToPopulate(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.row_item_for_date_search,parent,false);
        ViewHolder holder = new ViewHolder();
        holder.namesearch = (TextView) view.findViewById(R.id.name);
        holder.idsearch = (TextView) view.findViewById(R.id.type);
        holder.image = (ImageView)view.findViewById(R.id.item_info);
        view.setTag(holder);




        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.namesearch.setText(cursor.getString(cursor.getColumnIndex("student_name")));
        holder.idsearch.setText(cursor.getString(cursor.getColumnIndex("student_id")));

    }
    static  class ViewHolder{
        TextView namesearch;
        TextView idsearch;
        ImageView image;
    }
}
