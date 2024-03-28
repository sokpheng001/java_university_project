package view.components;

import view.WindowsFrame;
import utils.WindowsFrameObject;
import view.components.subFrame.InternalFrame1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    // Create menu bar
    private final static JMenuBar menuBar = new JMenuBar();
    // Create menus
    private final static JMenu fileMenu = new JMenu("File");
    private static final JMenu helpMenu = new JMenu("Help");
    private static final JMenu accountMenu = new JMenu("Account");
    // Create menu items
    private final JMenuItem openItem = new JMenuItem("Open");
    private static final JMenuItem saveItem = new JMenuItem("Save");
    private final static JMenuItem addNewWord = new JMenuItem("Add New Word");
    private static final JMenuItem exitItem = new JMenuItem("Exit");
    // create search filed
    public static void createMenu(){
        //add cursor
        handCursor(fileMenu);
        handCursor(helpMenu);
        handCursor(accountMenu);
        handCursor(saveItem);
        handCursor(exitItem);
        handCursor(addNewWord);
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
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                handle when click save
            }
        });
        fileMenu.addSeparator(); // Add separator line
        fileMenu.add(addNewWord);
        addNewWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewWordForm.open();
            }
        });
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
    private static void handCursor(JComponent jMenu){
        jMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jMenu.setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //                check

            }
        });
    }
}
