package lesson2.hw.l2_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Oleksii.Sergiienko on 2/24/2017.
 */
@XmlRootElement
public class Trains implements Iterable<Train> {
    private List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return trains;
    }

    @XmlElements(value = {@XmlElement(name = "train", type = Train.class)})
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public Trains add(Train train) {
        this.trains.add(train);
        return this;
    }

    public Trains add(List<Train> trains){
        this.trains.addAll(trains);
        return this;
    }

    public Trains remove(Train train) {
        this.trains.remove(train);
        return this;
    }

    public Trains remove(List<Train> trains){
        this.trains.removeAll(trains);
        return this;
    }

    public List<Train> filter(Predicate<Train> filter) {
        return trains.parallelStream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", \n");
        trains.stream().sorted((x, y) -> x.getDeparture().compareTo(y.getDeparture())).forEach(x -> sj.add(x.toString()));
        return sj.toString();
    }

    @Override
    public Iterator<Train> iterator() {
        return trains.iterator();
    }

    @Override
    public void forEach(Consumer<? super Train> action) {
        trains.forEach(action);
    }

    public void clearTimeTable() {
        trains.clear();
        ;
    }

    public void marshall(OutputStream writer) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Trains.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(this, writer);
    }

    public static Trains unmarshall(InputStream reader)
            throws JAXBException, ParserConfigurationException, SAXException, IOException {
        JAXBContext context = JAXBContext.newInstance(Trains.class);
        Unmarshaller um = context.createUnmarshaller();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(reader);
        Node node = doc.getFirstChild();
        return (Trains) um.unmarshal(node);
    }
}
