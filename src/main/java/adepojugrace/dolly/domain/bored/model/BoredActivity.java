package adepojugrace.dolly.domain.bored.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BoredActivity {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    private String activity;
    private String type;
    private Integer participants;
    private String link;

    public BoredActivity() {
    }


    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BoredActivity{" +
                "activity='" + activity + '\'' +
                ", type='" + type + '\'' +
                ", participants=" + participants +
                ", link='" + link + '\'' +
                '}';
    }
}
