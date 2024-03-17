package view.components;

import view.WindowsFrame;
import utils.WindowsFrameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchArea {
    private final static WindowsFrame frame = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private final static JPanel panel = new JPanel();
    public final static JTextField searchField = new JTextField(30);
    private final static Dimension textFieldSize = searchField.getPreferredSize();
    private final static JButton searchButton = new JButton("Search");
    public static JPanel getSearchInput(){

        // Action listener for the search button
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText();
            // Perform search action with the searchText
//            JOptionPane.showMessageDialog(frame, "Searching for: " + searchText);
            System.out.println(searchText);
        });
//        search button

//      key listener
        searchField.addKeyListener(new KeyListener() {
                                       @Override
                                       public void keyTyped(KeyEvent e) {

                                       }
                                       @Override
                                       public void keyPressed(KeyEvent e) {
                                           if(e.getKeyCode()==KeyEvent.VK_ENTER){
//                                               JOptionPane.showMessageDialog(frame,searchField.getText());
                                           }
                                       }
                                       @Override
                                       public void keyReleased(KeyEvent e) {

                                       }
                                   }
        );
//         add more

        panel.add(searchField);
        panel.add(searchButton);
        //
        textFieldSize.height = 30;
        searchField.setPreferredSize(textFieldSize);
        //add placeholder to input text
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Enter text here")) {
                    searchField.setText(""); // Clear the text field when it gains focus
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
//                if (searchField.getText().isEmpty()) {
//                    searchField.setText("Enter text here..."); // Set placeholder text when it loses focus and is empty
//                }
            }
        });
        //
        //search button
        searchButton.setBackground(Color.lightGray);
//        searchButton.setBorder(null);
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchButton.setBackground(Color.LIGHT_GRAY);
                searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        //
//        frame.getContentPane().add(panel);
        //frame.pack(); // Adjusts the frame size to fit its components
        return panel;
    }
}
