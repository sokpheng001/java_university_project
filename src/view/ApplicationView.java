package view;

import utils.IconMaker;
import utils.WindowsFrameObject;
import view.components.Content;
import view.components.Footer;
import view.components.Menu;
import view.components.SearchArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationView {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    public ApplicationView(){
        windows.setLayout(new BorderLayout());
        //
        IconMaker.getIcon();
        //
        windows.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(windows, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    windows.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        //menu
        Menu.createMenu();
        //
        //search input
        windows.add(SearchArea.getSearchInput(), BorderLayout.BEFORE_FIRST_LINE);
//
//content
        windows.add(Content.dictionaryContent(), BorderLayout.CENTER);
        // footer of software
        windows.add(Footer.description(), BorderLayout.PAGE_END);
        //
        windows.setTitle("Royal University of Phnom Penh - Dictionary");
        windows.setSize(800,500);
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
    }
}