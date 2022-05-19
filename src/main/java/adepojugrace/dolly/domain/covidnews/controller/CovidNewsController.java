package adepojugrace.dolly.domain.covidnews.controller;

import adepojugrace.dolly.domain.covidnews.model.CovidNews;
import adepojugrace.dolly.domain.covidnews.services.CovidNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("covidnews")

public class CovidNewsController {

    private static Logger logger = LoggerFactory.getLogger(CovidNewsController.class);

    private CovidNewsService covidNewsService;

    public CovidNewsController(CovidNewsService covidNewsService){
        this.covidNewsService = covidNewsService;
    }

    @GetMapping("")
    public ResponseEntity<List<CovidNews>> requestNews (){
        Optional<List<CovidNews>> response = covidNewsService.requestNewsFromApi();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}





