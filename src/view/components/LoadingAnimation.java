package view.components;

import utils.WindowsFrameObject;
import view.WindowsFrame;

import javax.swing.*;
import java.util.List;

public class LoadingAnimation {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();

    private static JProgressBar jProgressBar;
    public static JProgressBar getLoading(){
        jProgressBar = new JProgressBar();
        jProgressBar.setStringPainted(true);
        return jProgressBar;
    }
    // Method to start the loading animation
    public static void startLoading() {
        // Create a SwingWorker for background tasks
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate a long-running task
                for (int i = 0; i <= 100; i++) {
                    // Update the progress
                    publish(i);
                    // Sleep to simulate work being done
                    Thread.sleep(50);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Update the progress bar with the latest progress value
                jProgressBar.setValue(chunks.getLast());
            }

            @Override
            protected void done() {
                // Task is complete, perform any final actions
                JOptionPane.showMessageDialog(windows,
                        "Loading complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        // Execute the SwingWorker
        worker.execute();
    }
}
