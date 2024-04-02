package view.components.mouseHover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HandCursorHandler {
    public static void handCursorOnButton(JComponent jButton){
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
