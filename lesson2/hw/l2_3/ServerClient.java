package lesson2.hw.l2_3;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Oleksii.Sergiienko on 2/27/2017.
 */
public class ServerClient implements Runnable {
    private Socket socket;
    private String path;

    public ServerClient(Socket socket, String path) {
        this.socket = socket;
        this.path = path;
    }

    public byte[] get() {
        byte[] arr = null;
        try (InputStream is = socket.getInputStream()) {
            arr = new byte[is.available()];
            is.read(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr != null ? arr : new byte[0];
    }

    @Override
    public void run() {

    }
}
