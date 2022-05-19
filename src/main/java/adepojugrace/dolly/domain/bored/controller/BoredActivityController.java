package adepojugrace.dolly.domain.bored.controller;

import adepojugrace.dolly.domain.bored.model.BoredActivity;
import adepojugrace.dolly.domain.bored.services.BoredActivityService;
import adepojugrace.dolly.domain.weather.controller.WeatherController;
import adepojugrace.dolly.domain.weather.models.WeatherApiResponse;
import adepojugrace.dolly.domain.weather.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("boredactivity")
public class BoredActivityController {

    private Logger logger = LoggerFactory.getLogger(BoredActivityController.class);
    private BoredActivityService boredActivityService;


    @Autowired
    public BoredActivityController(BoredActivityService boredActivityService) {
        this.boredActivityService = boredActivityService;
    }


    @GetMapping("")
    public ResponseEntity<BoredActivity> requestActivity() {
        BoredActivity response = boredActivityService.requestActivityFromApi();
        logger.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}


