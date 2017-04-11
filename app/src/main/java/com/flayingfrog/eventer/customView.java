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

import com.flayingfrog.eventer.Event;
import com.flayingfrog.eventer.R;

import java.util.ArrayList;

/**
 * Created by alejandro on 14/03/17.
 */

public class customView extends ArrayAdapter<Event> implements View.OnClickListener{

    private ArrayList<Event> data;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView info;
        TextView name;
        TextView description;
        TextView date;
        ImageView image;
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
                Snackbar.make(v,event.theInfo(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
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
            viewHolder.info = (TextView) convertView.findViewById(R.id.info);
            //viewHolder.description = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);

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
        //viewHolder.description.setText(dataModel.theDesc());
        viewHolder.date.setText(dataModel.theDate());
        viewHolder.image.setOnClickListener(this);
        viewHolder.image.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
