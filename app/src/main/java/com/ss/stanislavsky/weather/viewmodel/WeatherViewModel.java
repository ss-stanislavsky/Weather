package com.ss.stanislavsky.weather.viewmodel;

import android.util.Log;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ss.stanislavsky.weather.model.data.CurrentWeather;
import com.ss.stanislavsky.weather.model.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository weatherRepository = WeatherRepository.getInstance();
    private MutableLiveData<CurrentWeather> liveData = new MutableLiveData<>();
    private final ObservableBoolean isLoading = new ObservableBoolean(false);

    public LiveData<CurrentWeather> getLiveData() {
        return liveData;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void loadWeather() {
        isLoading.set(true);
        weatherRepository.getCurrentWeather((currentWeather) -> {
                liveData.setValue(currentWeather);
                isLoading.set(false);

                Log.d("in WeatherViewModel LD:",
                        liveData.getValue() != null ?
                                liveData.getValue().toString() :
                                "currentWeatherLiveData is null");
        });
    }
}
