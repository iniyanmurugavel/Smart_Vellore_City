package com.smart_vellore_city.Retrofit;


import com.smart_vellore_city.weather.pojo.WeatherResult;
import com.smart_vellore_city.weather.weatherforecast.WeatherForecastResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOpenWeatherMap {

    @GET("weather?")
    Observable<WeatherResult> getWeatherByLatLng
            (@Query("lat") double lat, @Query("lon") double lng,
             @Query("appid") String appid, @Query("units") String unit);



    @GET("forecast?")
    Observable<WeatherForecastResult> getWeatherForecastResultLatLng
            (@Query("lat") double lat, @Query("lon") double lng,
             @Query("appid") String appid, @Query("units") String unit);
}
 