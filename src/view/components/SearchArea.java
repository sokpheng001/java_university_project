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
    private static JButton previousButton;
    private static JButton nextButton;
    private final static JButton printButton = new JButton("Print");
    public static JPanel getSearchInput(){
//        add cursor to button print
        handCursorOnButton(printButton);
        printButton.setName("print button");
//        previous button
        ImageIcon previousIcon = new ImageIcon("previous.png");
        Image scaledPreviousImg = previousIcon.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        previousIcon = new ImageIcon(scaledPreviousImg);
        previousButton = new JButton(previousIcon);
        previousButton.setName("previous button");
        // Set cursor to hand cursor when mouse enters the button area
        handCursorOnButton(previousButton);
        //
//        next button
        ImageIcon nextIcon = new ImageIcon("next.png");
        Image scaledNextImg = nextIcon.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        nextIcon = new ImageIcon(scaledNextImg);
        nextButton = new JButton(nextIcon);
        nextButton.setName("next button");
        // Set cursor to hand cursor when mouse enters the button area
        handCursorOnButton(nextButton);
        // Action listener for the search button
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText();
            // Perform search action with the searchText
//            JOptionPane.showMessageDialog(frame, "Searching for: " + searchText);
            System.out.println(searchText);
        });
//        search button

//      key listener
//         add more
        panel.add(previousButton);
        panel.add(searchField);
        panel.add(nextButton);
        panel.add(printButton);
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
    private static void handCursorOnButton(JButton jButton){
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton.setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //                check which button - next / previous
                if(jButton.getName().equalsIgnoreCase("next button")){
                    System.out.println("This is next button");
                }else if(jButton.getName().equalsIgnoreCase("previous button")){
                    System.out.println("This is previous button");
                }
            }
        });
    }
}
