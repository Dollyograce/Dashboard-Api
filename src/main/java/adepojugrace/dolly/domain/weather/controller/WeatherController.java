package adepojugrace.dolly.domain.weather.controller;

import adepojugrace.dolly.domain.weather.models.WeatherApiResponse;
import adepojugrace.dolly.domain.weather.services.WeatherService;
import adepojugrace.dolly.domain.weather.services.WeatherServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("Http://localhost:3001")
@RestController
@RequestMapping("/weatherapi")

public class WeatherController {
    private Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private WeatherService weatherService;


    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("")
    public ResponseEntity<WeatherApiResponse> requestDataFromApi (@RequestParam(name="lon", required = false) String lon,
                                                                 @RequestParam(name="lat", required = false) String lat){
        Optional<WeatherApiResponse> response =  weatherService.requestDataFromApi(lat, lon);
        logger.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}




