package adepojugrace.dolly.domain.covidnews.services;


import adepojugrace.dolly.domain.covidnews.model.CovidNews;

import java.util.List;
import java.util.Optional;

public interface CovidNewsService {
    Optional<List<CovidNews>> requestNewsFromApi();
}
