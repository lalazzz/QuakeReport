package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Michelle Tan on 8/5/2017.
 */



public class EarthquakeInfoAdapter extends ArrayAdapter<EarthquakeInfo> {
    public EarthquakeInfoAdapter(Activity context, ArrayList<EarthquakeInfo> earthquakesinfo) {
        super(context, 0, earthquakesinfo);
    }
    //Creates the date and time method for simple date format retrieving from the dateobject and converter as follows
    //Return the formatted date string (i.e. "Mar 3, 1984" is LLL dd yyyy) from a Date object.
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    //Return the formatted date string (i.e. "4:30 PM") from a Date object.
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     * @param position The position in the list of data that are displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }
        EarthquakeInfo currentEinfo = getItem(position);

        // Find the TextView in the list.xml layout with the magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentEinfo.getmMagnitude());

        // Find the TextView in the list.xml layout with the ID coordinate
        TextView coordinatenTextView = (TextView) listItemView.findViewById(R.id.coordinate);
        coordinatenTextView.setText(currentEinfo.getmCoordinate());


        // Find the TextView in the list.xml layout with the ID location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(currentEinfo.getmLocation());


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEinfo.getmDateTime());
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 3 TextViews) that is shown in the ListView
        return listItemView;
    }


}
