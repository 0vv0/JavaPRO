package lesson1.l1_2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
@SaveTo(path = "file.txt")
public class TextContainer {
    String text = "my text here";

    @Saver
    public void save(String path){
        try (FileWriter fw = new FileWriter(path)){
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
