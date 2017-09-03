package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Michelle Tan on 8/5/2017.
 * The adapter is use to assign the different properties that is shown in the list.
 * As well as the methods for formatting the data retrieve from the JSON.
 * This is more like the middle step for transferring or categorising the data to the desired views.
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

    //Return the formatted magnitude string showing 1 decimal place (i.e. "3.2") from a decimal magnitude value.
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    //Define the getMagnitudeColor() helper method and use switch for each different range of magnitude to specific colors
    // int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1); for one magnitude
    private int getmMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        //Round a number downward to its nearest floor integer (e.g. 1.5 -> 1)
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        //the returned color will be styled for the specified Context's theme.
        //ContextCompat getColor() to convert the color resource ID into an actual integer color value,
        //and return the result as the return value of the getMagnitudeColor() helper method
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     * This is to assigned the formatted data using the method listed above into the display list view.
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
        EarthquakeInfo currentEInfo = getItem(position);

        // Find the TextView in the list.xml layout with the magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEInfo.getmMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeTextView.setText(formattedMagnitude);

        // Find the TextView in the list.xml layout with the ID coordinate
        TextView coordinateTextView = (TextView) listItemView.findViewById(R.id.coordinate);
        coordinateTextView.setText(currentEInfo.getmCoordinate());


        // Find the TextView in the list.xml layout with the ID location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(currentEInfo.getmLocation());


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEInfo.getmDateTime());
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

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getmMagnitudeColor(currentEInfo.getmMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        // Return the whole list item layout (containing 3 TextViews) that is shown in the ListView
        return listItemView;
    }


}
