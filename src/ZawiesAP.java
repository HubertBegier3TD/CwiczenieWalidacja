import javax.swing.*;

public class ZawiesAP extends JFrame {

    JButton startButton = new JButton("Start");
    JLabel statusLabel = new JLabel("gotowy");

    public ZawiesAP() {
        setTitle("zawies sie");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        startButton.setBounds(90, 20, 120, 30);
        statusLabel.setBounds(70, 70, 200, 30);

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                statusLabel.setText("czas: " + (i + 1) + "s");
            }
            statusLabel.setText("Zakończon");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ZawiesAP().setVisible(true));
    }
}
