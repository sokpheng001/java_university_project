package view.components;

import repository.DataList;
import repository.DataStore;
import utils.WindowsFrameObject;
import view.ApplicationView;
import view.WindowsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.List;


public class LoadingFrame {

    // Create a progress bar
    private static final JProgressBar progressBar = new JProgressBar();

    private final static  JFrame frame = new JFrame("Opening Dictionary");
    private final static JPanel panel = new JPanel();



    public static void open(){
        frame.setSize(300, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(
                new ImageIcon("dictionary.png").getImage()
        );
        progressBar.setStringPainted(true); // Display the percentage
//        progressBar.setMinimum(0);
//        progressBar.setMaximum(100);

        // Create a button to start the progress
        JButton startButton = new JButton("Start Loading");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startLoading();
            }

        });

        // Create a panel to hold the progress bar and button
        panel.setLayout(new BorderLayout());
        panel.add(progressBar, BorderLayout.CENTER);
//        panel.add(startButton, BorderLayout.SOUTH);
        startLoading();
        frame.add(panel);
        frame.setVisible(true);
    }
    // Method to simulate loading progress
// Method to start the loading animation
    private static void startLoading() {
        // Create a SwingWorker for background tasks
        // Simulate a long-running task
        // Check if the task is cancelled
        // Update the progress
        // Sleep to simulate work being done
        // Update the progress bar with the latest progress value
        // Task is complete, perform any final actions
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate a long-running task
                for (int i = 0; i <= 100; i++) {
                    // Check if the task is cancelled
                    if (isCancelled()) {
                        break;
                    }
                    // Update the progress
                    publish(i);
                    setProgress(i);
//                    System.out.println(getProgress());
                    // Sleep to simulate work being done
                    Thread.sleep(50);
//                    read words from file
                    DataStore.getAllWords().forEach((k, v)->{
                        DataList.lists.add(k);
                    });

                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Update the progress bar with the latest progress value
                progressBar.setValue(chunks.getLast());
            }

            @Override
            protected void done() {
                // Task is complete, perform any final actions
//                JOptionPane.showMessageDialog(frame,
//                        "Loading complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
//                panel.setVisible(false);
                ApplicationView.show();
            }
        };
        // Execute the SwingWorker
        worker.execute();
    }
}
