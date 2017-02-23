package lesson3.classwork.HTTPServer;

import java.util.List;

public interface Processor {
    byte[] process(byte[] data, List<String> headers);
}