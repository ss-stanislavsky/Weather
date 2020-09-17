package com.ss.stanislavsky.weather.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.ss.stanislavsky.weather.R;
import com.ss.stanislavsky.weather.databinding.ActivityMainBinding;
import com.ss.stanislavsky.weather.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherViewModel weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        BindingHandler handler = new BindingHandler();

        binding.setLifecycleOwner(this);
        binding.setViewModel(weatherViewModel);
        binding.setHandler(handler);

        weatherViewModel.loadWeather();

        //binding.swipeToRefresh.setRefreshing(true);

        Picasso.get().load("http://openweathermap.org/img/wn/10n@2x.png").into(binding.image);

    }
}