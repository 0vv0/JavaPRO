package lesson2.homework.l2_1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 2/24/2017.
 */
@XmlRootElement(name = "root")
public class Trains implements Iterable<Train>{
    private List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return trains;
    }

    @XmlElements(value = {@XmlElement(type = Train.class)})
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public Trains add(Train train){
        this.trains.add(train);
        return this;
    }

    public Trains remove(Train train){
        this.trains.remove(train);
        return this;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", \n");
        trains.stream().sorted((x, y)->x.getDeparture().compareTo(y.getDeparture())).forEach(x->sj.add(x.toString()));
        return sj.toString();
    }

    @Override
    public Iterator<Train> iterator() {
        return trains.iterator();
    }
}
