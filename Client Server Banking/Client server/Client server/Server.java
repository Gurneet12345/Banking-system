import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Server extends JFrame {

    private ExecutorService pool;
    private ServerSocket server;
    private Socket connection;
    private JTextArea area;
    private JPanel panel;

    public Server() {
        super("Server");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        panel = new JPanel();
        add(panel);
        area = new JTextArea();
        panel.add(area);

        pool = Executors.newCachedThreadPool();
    }

    public void startRunning() {
        try {
            server = new ServerSocket(1337, 100);
            while (true) {
                try {
                    waitForConnection();
                } catch (EOFException eofException) {
                    showMessage("Server ended the connection! \n");
                }
            }
        } catch (IOException ioException) {
            showMessage("Server failed: " + ioException.getMessage());
        } finally {
            closeDown();
        }
    }

    private void waitForConnection() throws IOException {
        showMessage("Waiting for connections... \n");
        connection = server.accept();
        pool.execute(new ServerThread(connection));
        showMessage("Now connected to " + connection.getInetAddress().getHostName() + "\n");
    }

    private void showMessage(final String message) {
        SwingUtilities.invokeLater(() -> area.append(message));
    }

    private void closeDown() {
        try {
            if (server != null) server.close();
            if (connection != null) connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
