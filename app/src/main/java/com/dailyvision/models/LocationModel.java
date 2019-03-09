package com.dailyvision.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by ssharma on 09,March,2019
 **/

@IgnoreExtraProperties
public class LocationModel {

    public String city;
    public Double latitude;
    public Double longitude;

   public LocationModel(String cityName, Double lat, Double lon){
        city = cityName;
        latitude = lat;
        longitude = lon;
    }

}
