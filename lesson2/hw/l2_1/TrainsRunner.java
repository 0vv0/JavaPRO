package lesson2.hw.l2_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Oleksii.Sergiienko on 2/24/2017.
 */
public class TrainsRunner {
    private Trains trains;
    private static final String DIR = "src\\lesson2\\hw\\l2_1\\";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        TrainsRunner trainsRunner = new TrainsRunner();
        trainsRunner.add4trains();
        System.out.println("4 trains\n" + trainsRunner.getTrains());

        trainsRunner.removeTrain("2");
        System.out.println("3 trains\n" +trainsRunner.getTrains());

        trainsRunner.marshall();
        trainsRunner.forgetAllTimeTable();
        System.out.println("0 trains" + trainsRunner.getTrains());

        trainsRunner.unmarshall();
        System.out.println("3 trains\n" +trainsRunner.getTrains());

        System.out.println("\ntoday, from 15 till 19");
        trainsRunner.getTrains().getTrains().stream()
                .filter(x->
                        x.getDate().equals(LocalDate.now())
                        &&x.getDeparture().isAfter(LocalTime.of(15,00))
                        &&x.getDeparture().isBefore(LocalTime.of(19,00))
                ).forEach(x-> System.out.println(x));


    }

    public Trains getTrains(){
        return trains;
    }

    public void add4trains(){
        Train train1 = new Train("1", "Kyiv", "Odessa", LocalDate.now(), LocalTime.of(15, 00));

        Train train2 = new Train();
        train2.setId("2");
        train2.setFrom("Odessa");
        train2.setTo("Kyiv");
        train2.setDate(LocalDate.now());
        train2.setDeparture(LocalTime.of(11, 10));

        Train train3 = new Train("3", "Kyiv", "Zhmerinka", LocalDate.now(), LocalTime.of(16,00));
        Train train4 = new Train("4", "Zhmerinka", "Kyiv", LocalDate.parse("2017-02-24"), LocalTime.of(17,20));

        trains = new Trains();
        trains.add(train1).add(train2);
        trains.add(train3).add(train4);
    }

    public void removeTrain(String id){
        for(Train train:trains.getTrains()){
            if(train.getId().equals(id)){trains.remove(train);break;}
        }
    }

    public void marshall() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Trains.class);
        Marshaller m = context.createMarshaller();

        try(FileWriter file = new FileWriter(DIR + "trains.xml")) {
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(trains, file);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void unmarshall() throws JAXBException, ParserConfigurationException, SAXException {
        JAXBContext context = JAXBContext.newInstance(Trains.class);
        Unmarshaller um = context.createUnmarshaller();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = documentBuilder.parse(new File(DIR + "trains.xml"));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        Node node = doc.getFirstChild();
        trains = (Trains)um.unmarshal(node);
    }

    public void forgetAllTimeTable(){
        trains = new Trains();
    }
}
