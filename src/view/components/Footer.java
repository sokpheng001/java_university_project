package view.components;

import view.WindowsFrame;
import utils.WindowsFrameObject;

import javax.swing.*;
import java.awt.*;

public class Footer {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private final static JPanel descriptionPlace = new JPanel();
    public static JPanel description(){
        JLabel jLabel = new JLabel("Copyright - RUPP - 2024");
        descriptionPlace.add(jLabel);
        descriptionPlace.setBackground(Color.LIGHT_GRAY);
        return descriptionPlace;
    }
}
