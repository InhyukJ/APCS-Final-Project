import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

/*
    
*/

public  class Button2 extends Button{
    private SetBackground panel;
    private Button1 btn1;
    private JLabel arrow;
    public boolean game_mode = false;
        
        
    public Button2(BufferedImage img, SetBackground bg){
        super(220, 359, img);
        panel = bg;
        btn1 = panel.button1;
        arrow = panel.arrow;
    }
    
    public void moveArrow(){
        
        if(game_mode){
            if(arrow.getY() == 30){
                arrow.setLocation(arrow.getX(), 70);
            }
            else if(arrow.getY() == 70){
                arrow.setLocation(arrow.getX(), 90);
            }
            else if(arrow.getY() == 90){
                arrow.setLocation(arrow.getX(), 30);
            }
        }
        
        else {
            if(arrow.getY() == 20){
            arrow.setLocation(arrow.getX(), 80);
            
        }
        else{
            arrow.setLocation(arrow.getX(), 20);
        }}
    }
    public void actionCommand(){
        if(panel.arrow_exists && (btn1.btn1_choice != 4 && btn1.btn1_choice != 2 && !(panel.sleeping))){
        moveArrow();
        }
    }

}