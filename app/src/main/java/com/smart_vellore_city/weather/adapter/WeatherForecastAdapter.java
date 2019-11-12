package com.smart_vellore_city.weather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart_vellore_city.Common.Common;
import com.smart_vellore_city.R;
import com.smart_vellore_city.weather.ViewHolder.WeatherForecastViewHolder;
import com.smart_vellore_city.weather.weatherforecast.WeatherForecastResult;
import com.squareup.picasso.Picasso;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastViewHolder> {
    private Context context;
    private WeatherForecastResult weatherForecastResult;

    public WeatherForecastAdapter(Context context, WeatherForecastResult weatherForecastResult) {
        this.context = context;
        this.weatherForecastResult = weatherForecastResult;
    }

    @NonNull
    @Override
    public WeatherForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast, parent, false);

        return new WeatherForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherForecastViewHolder holder, int position) {
        Picasso.with(context).load(new StringBuilder("https://openweathermap.org/img/w/")
                .append(weatherForecastResult.list.get(position).weather.get(0).getIcon()).append(".png").toString())
                .into(holder.img_weather);
        holder.txt_date.setText(new StringBuilder(Common.convertUnixToDate(weatherForecastResult.list.get(position).dt)));

        holder.txt_description.setText(new StringBuilder(weatherForecastResult.list.get(position).weather.get(0).getDescription()).toString().toUpperCase());

        holder.txt_temperature.setText(new StringBuilder(String.valueOf(weatherForecastResult.list.get(position).main.getTemp()))
                .append("°C").toString());


    }

    @Override
    public int getItemCount() {
        return weatherForecastResult.list.size();
    }
}
