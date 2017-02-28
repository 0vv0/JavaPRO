package lesson2.hw.l2_3;

/**
 * Created by Oleksii.Sergiienko on 2/27/2017.
 */
public class Main {
    public static void main(String[] args) {
        final HTTPServer server = new HTTPServer(8080, "C:\\temp");
        server.start();
        System.out.println("Server started...");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                server.interrupt();
                System.out.println("Server stopping...");
            }
        });
    }
}
