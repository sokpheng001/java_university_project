package view.components.subFrame;

import javax.swing.*;
import java.lang.runtime.TemplateRuntime;

public class InternalFrame1{
    public static JInternalFrame getSubFrame(){
        JInternalFrame jInternalFrame = new JInternalFrame("Save Words",true,true,true,true);
        jInternalFrame.setVisible(true);
        return jInternalFrame;
    }
}
