package adepojugrace.dolly.domain.covidnews.services;

import adepojugrace.dolly.domain.covidnews.model.CovidNews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CovidNewsServiceImpl implements CovidNewsService {

    private Logger logger = LoggerFactory.getLogger(CovidNewsServiceImpl.class);

    private RestTemplate restTemplate;

    @Value("${covidnews.api.host}")
    private String host;

    @Value("${covidnews.api.key}")
    private String key;

    public CovidNewsServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct //Can only see data from Api when running with PostConstruct?
    public void setup(){
        requestNewsFromApi();
    }

    @Override
    public Optional<List<CovidNews>> requestNewsFromApi() {
        try {
            String uri = "https://covid-news2.p.rapidapi.com/news";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-RapidAPI-Host", host);
            httpHeaders.set("X-RapidAPI-Key", key);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<ArrayList<CovidNews>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
            ArrayList<CovidNews> covidNews = response.getBody();
            logger.info(covidNews.get(1).toString());
            return Optional.of(covidNews);
        } catch (HttpClientErrorException ex) {
            return Optional.empty();
        }
    }
}
