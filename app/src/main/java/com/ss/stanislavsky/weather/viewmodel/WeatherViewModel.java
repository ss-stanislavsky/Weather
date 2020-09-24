package com.ss.stanislavsky.weather.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ss.stanislavsky.weather.model.data.CurrentWeather;
import com.ss.stanislavsky.weather.model.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository weatherRepository = WeatherRepository.getInstance();
    private MutableLiveData<CurrentWeather> currentWeatherLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private MutableLiveData<String> toastMessageLiveData = new MutableLiveData<>();

    public LiveData<CurrentWeather> getCurrentWeatherLiveData() {
        return currentWeatherLiveData;
    }
    public LiveData<Boolean> isLoading() {
        return isLoading;
    }
    public LiveData<String> getToastMessageLiveData() {
        return toastMessageLiveData;
    }

    public void loadWeather() {
        isLoading.setValue(true);
        weatherRepository.getCurrentWeather(new WeatherRepository.OnDataLoadCallback() {
            @Override
            public void onDataLoad(CurrentWeather currentWeather) {
                currentWeatherLiveData.setValue(currentWeather);
                isLoading.setValue(false);

                Log.d("in WeatherViewModel LD:",
                        currentWeatherLiveData.getValue() != null ?
                                currentWeatherLiveData.getValue().toString() :
                                "currentWeatherLiveData is null");
            }

            @Override
            public void onFailure(String errorMessage) {
                toastMessageLiveData.setValue(errorMessage);
                isLoading.setValue(false);
            }
        });
    }
}
