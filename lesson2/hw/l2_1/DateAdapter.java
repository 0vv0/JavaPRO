package lesson2.hw.l2_1;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Created by Oleksii.Sergiienko on 2/25/2017.
 */

public class DateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

}

