package view.components;

import view.WindowsFrame;
import utils.WindowsFrameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    // Create menu bar
    private final static JMenuBar menuBar = new JMenuBar();
    // Create menus
    private final static JMenu fileMenu = new JMenu("File");
    private final JMenu editMenu = new JMenu("Edit");
    private static final JMenu helpMenu = new JMenu("Help");
    private static final JMenu accountMenu = new JMenu("Account");
    // Create menu items
    private final JMenuItem openItem = new JMenuItem("Open");
    private static final JMenuItem saveItem = new JMenuItem("Save");
    private static final JMenuItem exitItem = new JMenuItem("Exit");
    // create search filed

    public static void createMenu(){
        // Add action listeners to menu items
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(windows, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                    windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    windows.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
//                System.exit(0);
            }
        });
        //
        menuBar.setBackground(Color.WHITE);
        //Set openItem size (height)
//        openItem.setPreferredSize(new Dimension(150,openItem.getPreferredSize().height));
        // Add menu items to menus
//        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        saveItem.setPreferredSize(new Dimension(150,saveItem.getPreferredSize().height));
        fileMenu.addSeparator(); // Add separator line
        fileMenu.add(exitItem);
        // Add menus to menu bar
        menuBar.add(fileMenu);
//        menuBar.add(editMenu);
        menuBar.add(helpMenu);
//        account bar
        menuBar.add(accountMenu);
        // Set menu bar to frame
        windows.setJMenuBar(menuBar);
    }
}
