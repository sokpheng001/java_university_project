package view.components;

import utils.WindowsFrameObject;
import view.WindowsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class LoadingAnimation {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private static SwingWorker<Void, Integer> worker;
    private static JProgressBar jProgressBar;
    public static void getLoading(){
        jProgressBar = new JProgressBar(0,100);
        jProgressBar.setStringPainted(true);
        // Add a window listener to handle frame closure
        windows.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Check if the SwingWorker is running and cancel it if necessary
                if (worker != null && !worker.isDone()) {
                    worker.cancel(true);
                }
            }
        });
//        startLoading();
        windows.add(jProgressBar, BorderLayout.CENTER);
    }
    // Method to start the loading animation
// Method to start the loading animation
    private static void startLoading() {
        // Create a SwingWorker for background tasks
        worker = new SwingWorker<Void, Integer>() {
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
                    System.out.println(getProgress());
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
