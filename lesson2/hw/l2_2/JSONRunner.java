package lesson2.hw.l2_2;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksii.Sergiienko on 2/25/2017.
 */
public class JSONRunner {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Oleksii");
        person.setSurname("Sergiienko");
        List<String> phones = new ArrayList<>();
        phones.add("+380664408879");
        phones.add("test_phone");
        person.setPhones(phones);
        List<String> sites = new ArrayList<>();
        sites.add("localhost");
        sites.add("127.0.0.1");
        person.setSites(sites);
        person.setAddress(new Address("Ukraine", "Kyiv", "Malynovskoho"));

        Gson gson = new Gson();
        System.out.println(person);
        try (FileWriter fw = new FileWriter("src\\lesson2\\hw\\l2_2\\person.json")) {
            fw.write(gson.toJson(person));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        Person personFromJSON = null;
        try (FileReader fr = new FileReader("src\\lesson2\\hw\\l2_2\\json.data.txt")) {
            personFromJSON = gson.fromJson(fr, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(personFromJSON!=null) {
            System.out.println(personFromJSON);
        }
    }
}
