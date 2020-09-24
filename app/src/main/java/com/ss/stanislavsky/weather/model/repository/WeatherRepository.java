package com.ss.stanislavsky.weather.model.repository;

import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.stanislavsky.weather.model.data.CurrentWeather;
import com.ss.stanislavsky.weather.model.retrofit.OpenWeatherMapApi;
import com.ss.stanislavsky.weather.model.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private static OpenWeatherMapApi apiInterface;
    private static WeatherRepository weatherRepository;
    private CurrentWeather currentWeather = null;
    
    private WeatherRepository() {
        apiInterface = RetrofitService.getInstance().getApiInterface();
    }

    public static WeatherRepository getInstance() {
        if (weatherRepository == null) {
            weatherRepository = new WeatherRepository();
        }
        return weatherRepository;
    }

    public void getCurrentWeather(OnDataLoadCallback callback) {
        apiInterface.getCurrentWeather(
                RetrofitService.BASE_LATITUDE,
                RetrofitService.BASE_LONGITUDE,
                RetrofitService.API_KEY)
                .enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                if (response.isSuccessful()) {
                    currentWeather = response.body();
                    callback.onDataLoad(currentWeather);

                    Log.d("Response body: ", currentWeather.toString());
                } else {
                    callback.onFailure(response.message());

                    Log.d("Error massage: ", response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable t) {
                callback.onFailure(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    public interface OnDataLoadCallback {
        void onDataLoad(CurrentWeather currentWeather);
        void onFailure(String errorMessage);
    }
}
