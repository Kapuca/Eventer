package com.flayingfrog.eventer;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alejandro on 14/03/17.
 */

public class customView extends ArrayAdapter<Event> implements View.OnClickListener{

    private ArrayList<Event> data;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView date;
        TextView time;
        ImageView image;
        ImageView borrar;

    }

    public customView(ArrayList<Event> data, Context context) {
        super(context, R.layout.rowitem, data);
        this.data = data;
        this.mContext=context;

    }




    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Event event=(Event)object;

        switch (v.getId())
        {
            case R.id.image:
                Snackbar.make(v,event.theDesc(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;

            case R.id.borrar:
                data.remove(position);
                //SunetePreferateAdaptor.this.notifyDataSetChanged();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Event dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rowitem, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.borrar = (ImageView) convertView.findViewById(R.id.borrar);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.downup: R.anim.updown);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.name.setText(dataModel.theName());
        viewHolder.time.setText(dataModel.theTime());
        viewHolder.date.setText(dataModel.theDate());
        viewHolder.image.setOnClickListener(this);
        viewHolder.image.setTag(position);
        viewHolder.borrar.setOnClickListener(this);
        viewHolder.borrar.setTag(position);
        return convertView;
    }
}
