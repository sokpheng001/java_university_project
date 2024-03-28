package view.components;

import repository.DataStoreMap;
import view.WindowsFrame;
import utils.WindowsFrameObject;

import javax.swing.*;
import java.awt.*;

public class Footer {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private final static JPanel descriptionPlace = new JPanel();
    public static JPanel description(){
        String numberOfWord = null;
        long word  = (long) DataStoreMap.words.size();
        if(word>=1000 && word<1000000){
            numberOfWord = STR."\{String.valueOf(word/1000)}K";
        }else if(word>=1000000){
            numberOfWord = STR."\{String.valueOf(word/1000000)}M";
        }else {
            numberOfWord = STR."\{String.valueOf(word)}";
        }
        JLabel jLabel = new JLabel(STR."Copyright - RUPP - 2024. Dictionary with \{numberOfWord} words");
        descriptionPlace.add(jLabel);
        descriptionPlace.setBackground(Color.LIGHT_GRAY);
        return descriptionPlace;
    }
}
