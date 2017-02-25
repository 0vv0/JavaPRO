package lesson2.hw.l2_1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Oleksii.Sergiienko on 2/24/2017.
 */
@XmlRootElement
public class Train implements Serializable {
    private String id;
    private String from;
    private String to;
    private LocalDate date;
    private LocalTime departure;

    public Train() {
    }

    public Train(String id, String from, String to, LocalDate date, LocalTime departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @XmlJavaTypeAdapter(TimeAdapter.class)
    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return departure + " \"" + from + "-" + to + "\", " + date;
    }
}
