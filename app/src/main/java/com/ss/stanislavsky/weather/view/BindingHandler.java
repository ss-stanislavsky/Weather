package com.ss.stanislavsky.weather.view;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;
import com.ss.stanislavsky.weather.viewmodel.WeatherViewModel;

public class BindingHandler {
    public void onWeatherLoad(WeatherViewModel viewModel) {
        viewModel.loadWeather();
    }

    @BindingAdapter({"app:url"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }
}
