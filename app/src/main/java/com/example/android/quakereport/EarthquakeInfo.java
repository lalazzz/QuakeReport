package com.example.android.quakereport;

/**
 * Created by Michelle Tan on 8/5/2017.
 * This is created to verify that the information is return in the correct data type.
 */

public class EarthquakeInfo {
    // Magnitude of the Earthquakes (e.g. 2.3,2.7, 3.0,3.6, 4.0,5.4)
    private double mMagnitude;
    //Location of the Earthquakes occur
    private String mCoordinate;
    //Location of the Earthquakes occur
    private String mLocation;
    //Date and Time of the Earthquakes occur
    private long mDateTime;
    //Url of the earthquake occurs
    private String mUrl;


    /**Creating a Earthquake object to retrieve the information and checking its type
     * @param magnitude is the number of magnitude
     * @param location that shows the located earthquakes
     * @param dateTime that the quakes was recorded
     * @param url is the website URL to find more details about the earthquake
     **/

    public EarthquakeInfo(double magnitude, String coordinate , String location, long dateTime,String url){
        mMagnitude=magnitude;
        mCoordinate=coordinate;
        mLocation=location;
        mDateTime=dateTime;
        mUrl=url;
    }

    public double getmMagnitude(){
        return mMagnitude;
    }
    public String getmCoordinate(){
        return mCoordinate;
    }
    public String getmLocation(){return mLocation;}
    public long getmDateTime(){
        return mDateTime;
    }
    public String getmUrl(){return mUrl;}
}
