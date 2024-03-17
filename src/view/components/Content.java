package view.components;

import view.WindowsFrame;
import view.WindowsFrameObject;

import javax.swing.*;
import java.awt.*;

public class Content{
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private final static JPanel content = new JPanel(new GridLayout(0,2));
    public static JPanel dictionaryContent(){
        content.setBackground(Color.WHITE);
        JLabel jLabel = new JLabel("Content");
        jLabel.setHorizontalAlignment(2);
        content.add(jLabel);
        return content;
    }
}
