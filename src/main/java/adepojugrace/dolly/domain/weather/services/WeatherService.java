package adepojugrace.dolly.domain.weather.services;

import adepojugrace.dolly.domain.weather.models.WeatherApiResponse;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherApiResponse> requestDataFromApi(String lat, String lon);
}
