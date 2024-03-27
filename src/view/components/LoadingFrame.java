package view.components;

import repository.DataList;
import repository.DataStore;
import repository.DataStoreMap;
import utils.WindowsFrameObject;
import view.ApplicationView;
import view.WindowsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Objects;


public class LoadingFrame {

    // Create a progress bar
    private static final JProgressBar progressBar = new JProgressBar();
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private final static JPanel panel = new JPanel();
    private final static JDialog loadingForm = new JDialog();

    public static void open(){
        // add icon to loading form
        loadingForm.setIconImage(
                new ImageIcon("dictionary.png").getImage()
        );
        loadingForm.setTitle("Reading words...");
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
        loadingForm.setLayout(new BorderLayout());
        loadingForm.add(progressBar, BorderLayout.CENTER);
//        panel.add(startButton, BorderLayout.SOUTH);
        startLoading();
        loadingForm.setSize(300, 65);
        loadingForm.setLocationRelativeTo(windows); // Center on parent frame
//        frame.add(panel);
//        frame.setVisible(true);
//
        loadingForm.setVisible(true);
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
//                DataStore.getAllWords().forEach((k, v)->{
//                    DataList.lists.add(k);
//                });
                // read object data from file
                Objects.requireNonNull(DataStore.readObjectFromFile()).forEach(e->{
                    DataList.lists.add(e.getWord());
                    DataStoreMap.words.put(e.getWord(),e.getDescription());
                }
                );
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
                    Thread.sleep(10);
//                    read words from file

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
                loadingForm.setVisible(false);
//                panel.setVisible(false);
                ApplicationView.show();// call dictionary
            }
        };
        // Execute the SwingWorker
        worker.execute();
    }
    public static void close(){
        loadingForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("No closing");
                windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
