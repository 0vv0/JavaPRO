package lesson2.hw.l2_1;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;

/**
 * Created by Oleksii.Sergiienko on 2/25/2017.
 */

public class TimeAdapter extends XmlAdapter<String, LocalTime> {
    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.toString();
    }

    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v);
    }

}

