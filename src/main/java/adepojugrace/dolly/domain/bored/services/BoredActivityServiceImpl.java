package adepojugrace.dolly.domain.bored.services;

import adepojugrace.dolly.domain.bored.model.BoredActivity;
import adepojugrace.dolly.domain.covidnews.services.CovidNewsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class BoredActivityServiceImpl implements BoredActivityService {

    private Logger logger = LoggerFactory.getLogger(BoredActivityServiceImpl.class);

    private RestTemplate restTemplate;

    public BoredActivityServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct //Can only see data from Api when running with PostConstruct?
    public void setup() {
        requestActivityFromApi();
    }


    @Override
    public BoredActivity requestActivityFromApi() {
            String uri = String.format("http://www.boredapi.com/api/activity");
            ResponseEntity<BoredActivity> response = restTemplate.exchange(uri, HttpMethod.GET, null, BoredActivity.class);
            BoredActivity activityResponse = response.getBody();
            logger.info(String.valueOf(activityResponse));
            return activityResponse;
        }
    }
