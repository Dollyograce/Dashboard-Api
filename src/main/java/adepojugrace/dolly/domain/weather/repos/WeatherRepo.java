package adepojugrace.dolly.domain.weather.repos;

import adepojugrace.dolly.domain.weather.models.WeatherApiResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeatherRepo  {
    Optional<WeatherApiResponse> findByLatAndLon (String lat, String lon);
}
