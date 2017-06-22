package com.example.android.quakereport;

/**
 * Created by Michelle Tan on 8/5/2017.
 */

public class EarthquakeInfo {
    // Magnitude of the Earthquakes (e.g. 2.3,2.7, 3.0,3.6, 4.0,5.4)
    private String mMagnitude;
    //Location of the Earthquakes occur
    private String mCoordinate;
    //Location of the Earthquakes occur
    private String mLocation;
    //Date and Time of the Earthquakes occur
    private long mDateTime;

    /**Creating a Earthquake object to retrieve the information
    *@param magnitude is the number of magnitude
    *@param location that shows the located earthquakes
    *@param dateTime that the quakes was recorded
     **/
    public EarthquakeInfo(String magnitude, String coordinate , String location, long dateTime){
        mMagnitude=magnitude;
        mCoordinate=coordinate;
        mLocation=location;
        mDateTime=dateTime;
    }

    public String getmMagnitude(){
        return mMagnitude;
    }
    public String getmCoordinate(){
        return mCoordinate;
    }
    public String getmLocation(){return mLocation;}
    public long getmDateTime(){
        return mDateTime;
    }
}
