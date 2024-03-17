package view;

import utils.IconMaker;
import view.components.Menu;
import view.components.SearchInputBox;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    public MainView(){
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
        SearchInputBox.getSearchInput();
        //
        windows.setTitle("Dictionary");
        windows.setSize(800,500);
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
    }
}