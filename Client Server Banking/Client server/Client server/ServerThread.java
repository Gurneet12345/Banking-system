import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ServerThread(Socket socket) {
        this.connection = socket;
    }

    public void run() {
        try {
            setupStreams();
            processClientRequest();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void setupStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }

    private void processClientRequest() {
        String message = "You are now connected to the server!";
        sendMessage(message);

        do {
            try {
                message = (String) input.readObject();
                sendMessage("Server received: " + message);
            } catch (ClassNotFoundException | IOException e) {
                sendMessage("Unknown message type");
                break;
            }
        } while (!message.equals("CLIENT - END"));
    }

    private void sendMessage(String message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (output != null) output.close();
            if (input != null) input.close();
            if (connection != null) connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
