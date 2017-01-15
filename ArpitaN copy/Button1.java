import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

/*
    
*/

public  class Button1 extends Button{
    public SetBackground panel;
    public int btn1_choice;
    public ImageIcon panel_bg;
    public Button1(BufferedImage img, SetBackground bg){
        super(141, 340, img);
        panel = bg;
        btn1_choice = btn_choice;
        
    }
    
    public void actionCommand(){
            btn1_choice++;
           // System.out.println(btn1_choice);
            panel_bg = new ImageIcon("mode" + (btn1_choice % 8) + ".png");
    //    if(btn1_choice % 8 == 6) panel.dark = !(panel.dark);
            darken(panel_bg);
    }
    
    public void darken(ImageIcon panel_bg){
    Image newimg = panel_bg.getImage().getScaledInstance(246, 240, Image.SCALE_SMOOTH);
             panel.default_choice.setIcon(new ImageIcon(newimg));
            BufferedImage buffered = new BufferedImage(newimg.getWidth(null), newimg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            buffered.getGraphics().drawImage(newimg, 0, 0, null);
            ImageIcon darker = new ImageIcon(buffered);
            panel.default_choice.setIcon(darker);
            
            if(panel.dark) SetBackground.makeDarker(buffered);

    }
}