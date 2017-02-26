package lesson2.hw.l2_1;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Oleksii.Sergiienko on 2/24/2017.
 */
public class TrainsRunner {
    private static final String DIR = "src\\lesson2\\hw\\l2_1\\";
    private static final String FILENAME = DIR + "trains.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Trains trains = new Trains();
        trains = add4trains(trains);
        System.out.println("4 trains\n" + trains);

        trains.remove(trains.filter(x -> x.getId().equals("2")));
        System.out.println("3 trains\n" + trains);

        trains.marshall(new FileOutputStream(FILENAME));
        trains.clearTimeTable();
        System.out.println("0 trains" + trains);

        trains = Trains.unmarshall(new FileInputStream(FILENAME));
        System.out.println("3 trains\n" + trains);

        int fromHour = 15;
        int tillHour = 19;
        System.out.println("\ntoday, in (" + fromHour + ", " + tillHour + ")");
        Trains filteredTrains = new Trains();
        filteredTrains.add(trains.filter(
                x -> x.getDate().equals(LocalDate.now())
                        && x.getDeparture().isAfter(LocalTime.of(fromHour, 0))
                        && x.getDeparture().isBefore(LocalTime.of(tillHour, 0))));
        System.out.println(filteredTrains);

//        Написать код для добавления новых роездов в существующий xml
        Train train = new Train("11", "Kyiv", "Bucuresti", LocalDate.now(), LocalTime.of(15, 1));
        Trains
                .unmarshall(new FileInputStream(FILENAME))
                .add(train)
                .marshall(new FileOutputStream(FILENAME));
    }

    public static Trains add4trains(Trains trains) {
        Train train1 = new Train("1", "Kyiv", "Odessa", LocalDate.now(), LocalTime.of(15, 00));

        Train train2 = new Train();
        train2.setId("2");
        train2.setFrom("Odessa");
        train2.setTo("Kyiv");
        train2.setDate(LocalDate.parse("2017-02-24"));
        train2.setDeparture(LocalTime.of(11, 10));

        Train train3 = new Train("3", "Kyiv", "Zhmerinka", LocalDate.now(), LocalTime.of(16, 00));
        Train train4 = new Train("4", "Zhmerinka", "Kyiv", LocalDate.now(), LocalTime.of(17, 20));

        trains = new Trains();
        trains.add(train1).add(train2);
        trains.add(train3).add(train4);
        return trains;
    }

    public void addTrain(String filename) throws ParserConfigurationException, SAXException {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

    }
}
