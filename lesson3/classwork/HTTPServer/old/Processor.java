package lesson3.classwork.HTTPServer.old;

import java.util.List;

public interface Processor {
    byte[] process(byte[] data, List<String> headers);
}