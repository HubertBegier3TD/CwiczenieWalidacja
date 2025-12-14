import javax.swing.*;
import java.util.List;

public class NapAP extends JFrame {

    JButton startButton = new JButton("Start");
    JLabel statusLabel = new JLabel("gotowy");

    public NapAP() {
        setTitle("Naprawiona");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        startButton.setBounds(90, 20, 120, 30);
        statusLabel.setBounds(70, 70, 200, 30);

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(e -> {
            new SwingWorker<Void, String>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        publish("Pracuję... " + (i + 1) + "s");
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    statusLabel.setText(chunks.get(chunks.size() - 1));
                }

                @Override
                protected void done() {
                    statusLabel.setText("Zakończono pomyślnie!");
                }

            }.execute();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NapAP().setVisible(true));
    }
}
