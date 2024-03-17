package utils;

import javax.swing.*;
import java.awt.*;

public class IconMaker {
    public static void getIcon(){
        Image image = new ImageIcon("dictionary.png").getImage();
        WindowsFrameObject.WINDOWS_APP_OBJECT.getObject().setIconImage(image);
    }
}
