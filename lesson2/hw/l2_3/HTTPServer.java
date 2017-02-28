package lesson2.hw.l2_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Oleksii.Sergiienko on 2/26/2017.
 */
public class HTTPServer extends Thread {
    private int port;
    private String path;

    public HTTPServer(int port, String path) {
        this.port = port;
        this.path = path;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            while (!isInterrupted()){
//                wait while smbd will try to connect to us and attach it to socket
                Socket socket = serverSocket.accept();
                ServerClient server = new ServerClient(socket, path);
                executorService.submit(server);
                Thread.sleep(50);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
