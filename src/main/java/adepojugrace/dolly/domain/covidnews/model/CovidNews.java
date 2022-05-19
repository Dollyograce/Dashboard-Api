package adepojugrace.dolly.domain.covidnews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class CovidNews {


    private String title;
    private String url;
    @JsonIgnore
    private String st;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return "CovidNews{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", st='" + st + '\'' +
                '}';
    }
}
