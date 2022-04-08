package adepojugrace.dolly;

import adepojugrace.dolly.domain.weather.models.WeatherApiResponse;
import adepojugrace.dolly.domain.weather.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DashboardServerApiApplication implements CommandLineRunner {
	private static Logger log = LoggerFactory.getLogger(DashboardServerApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DashboardServerApiApplication.class, args);
	}


	@Autowired
	private WeatherService weatherService;

	@Override
	public void run(String... args) throws Exception {
		Optional<WeatherApiResponse> reponse = weatherService.requestDataFromApi("39.7447", "-75.5484");
		if(reponse.isEmpty()){
			log.info("No Beuno");
			return;
		}
		WeatherApiResponse data = reponse.get();
		log.info(data.toString());
	}
}

