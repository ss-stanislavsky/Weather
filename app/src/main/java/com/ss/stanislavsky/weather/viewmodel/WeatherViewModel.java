package com.ss.stanislavsky.weather.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ss.stanislavsky.weather.model.CurrentWeather;
import com.ss.stanislavsky.weather.model.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository weatherRepository = WeatherRepository.getInstance();
    private MutableLiveData<CurrentWeather> currentWeatherLiveData = new MutableLiveData<>();
    private final ObservableBoolean isLoading = new ObservableBoolean(false);

    public void loadWeather() {
        isLoading.set(true);
        weatherRepository.getCurrentWeather((currentWeather) -> {
                currentWeatherLiveData.setValue(currentWeather);
                isLoading.set(false);
        });
    }
}
