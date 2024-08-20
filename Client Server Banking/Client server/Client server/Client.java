import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {

    private JPanel panel;
    private JTextArea area;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private boolean flag = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }

    public Client() {
        super("Client");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                flag = false;
                closeDown();
            }
        });

        panel = new JPanel();
        add(panel);

        launch();
    }

    public void launch() {
        panel.removeAll();
        panel.setLayout(new FlowLayout());

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/anime.png")));  // Ensure this path is correct
        background.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setOpaque(false);

        JLabel user = new JLabel("Username:");
        top.add(user);

        JTextField username = new JTextField(20);
        top.add(username);

        JLabel pass = new JLabel("Password:");
        top.add(pass);

        JPasswordField password = new JPasswordField(20);
        top.add(password);

        JButton loginButton = new JButton("Login");
        top.add(loginButton);

        loginButton.addActionListener(e -> connectToServer());

        panel.add(top);
        panel.add(background, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    void connectToServer() {
        try {
            connection = new Socket(InetAddress.getByName("127.0.0.1"), 1337); // Ensure the IP and port are correct
            setupStreams();
            while (flag) {
                processMessages();
            }
        } catch (IOException e) {
            showMessage("Connection failed: " + e.getMessage());
        }
    }

    private void setupStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }

    private void processMessages() throws IOException {
        try {
            String message;
            while ((message = (String) input.readObject()) != null) {
                showMessage(message);
            }
        } catch (ClassNotFoundException e) {
            showMessage("Unknown object type received");
        }
    }

    private void showMessage(final String message) {
        SwingUtilities.invokeLater(() -> area.append(message + "\n"));
    }

    private void closeDown() {
        try {
            if (output != null) output.close();
            if (input != null) input.close();
            if (connection != null) connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
