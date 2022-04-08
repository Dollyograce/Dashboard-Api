package adepojugrace.dolly.domain.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import java.util.List;


public class WeatherApiResponse {

    @JsonIgnore
    private Long weatherId;
    private Coordinate coord;
    private List<Weather> weather;
    private String base;
    private Integer visibility;
    private WeatherMain main;
    private Wind wind;
    private Cloud clouds;
    private Long dt;
    private WeatherSys sys;
    private Long timezone;
    private String name;
    private Integer cod;

    public WeatherApiResponse() {
    }

    public Long getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public WeatherSys getSys() {
        return sys;
    }

    public void setSys(WeatherSys sys) {
        this.sys = sys;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "WeatherApiResponse{" +
                "weatherId=" + weatherId +
                ", coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", visibility=" + visibility +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}