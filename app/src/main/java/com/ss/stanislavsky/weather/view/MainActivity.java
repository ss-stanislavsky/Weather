package com.ss.stanislavsky.weather.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import com.ss.stanislavsky.weather.R;
import com.ss.stanislavsky.weather.databinding.ActivityMainBinding;
import com.ss.stanislavsky.weather.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeUI();

    }

    private void initializeUI() {
        WeatherViewModel weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // init SwipeToRefreshLayout
        binding.swipeToRefresh.setOnRefreshListener(weatherViewModel::loadWeather);
        weatherViewModel.isLoading().observe(this, binding.swipeToRefresh::setRefreshing);

        weatherViewModel.getCurrentWeatherLiveData().observe(this, (currentWeather -> {
            // init ImageView
            String url = "https://openweathermap.org/img/wn/" +
                    currentWeather.getWeather().get(0).getIcon() +
                    "@2x.png";
            Picasso.get().load(url).into(binding.image);

            // init place TextView
            binding.placeTv.setText(getString(R.string.place, currentWeather.getName() ,currentWeather.getSys().getCountry()));

            // init date TextView
            binding.dateTv.setText(currentWeather.getFormattedDate());

            // init weather description TextView
            binding.descriptionTv.setText(currentWeather.getWeather().get(0).getDescription());

            // init temperature TextView
            binding.tempTv.setText(currentWeather.getMain().getTempInCelsius());

            // init feels like temperature TextView
            binding.tempFeelsLikeTv.setText(currentWeather.getMain().getFeelsLikeTempInCelsius());

            // init feels like TextView
            if (currentWeather.getWeather() != null)
                binding.feelsLikeTv.setVisibility(View.VISIBLE);
        }));

        // init error toast
        weatherViewModel.getToastMessageLiveData().observe(this, message ->
                Toast.makeText(MainActivity.this,
                        getString(R.string.toast_get_data_error, message),
                        Toast.LENGTH_SHORT).show());

        // get weather data
        weatherViewModel.loadWeather();
    }
}