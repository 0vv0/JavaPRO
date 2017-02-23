package lesson2.classwork.json.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {

        byte[] buf;
        try (RandomAccessFile f = new RandomAccessFile("src\\lesson2\\classwork\\json\\json.txt", "r")) {
            buf = new byte[(int) f.length()];
            f.read(buf);
        }

        String result = new String(buf);

        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(result, Person.class);

        System.out.print(person.name);
        System.out.print(person.address.city);
    }
}
