package adepojugrace.dolly.domain.weather.models;

public class Cloud {
    private Integer all;

    public Cloud() {
    }

    public Cloud(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Cloud{" +
                "all=" + all +
                '}';
    }
}
