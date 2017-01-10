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
        
        
    public Button2(BufferedImage img, SetBackground bg){
        super(220, 359, img);
        panel = bg;
        btn1 = panel.button1;
        arrow = panel.arrow;
    }
    
    public void moveArrow(){
        if(arrow.getY() == 20){
            arrow.setLocation(arrow.getX(), 80);
            
        }
        else{
            arrow.setLocation(arrow.getX(), 20);
        }
    }
    public void actionCommand(){
        if(panel.arrow_exists){
        moveArrow();
      //  System.out.println(btn1.btn1_choice % 8);
        if(btn1.btn1_choice % 8 == 1){
            
            if(arrow.getY() == 20) panel.arrow_choice = "meal";
            if(arrow.getY() == 50) panel.arrow_choice = "snack";
        //System.out.println(panel.arrow_choice);
            }
            
        if(btn1.btn1_choice % 8 == 3){
            
            if(arrow.getY() == 20) panel.arrow_choice = "mini-game";
            if(arrow.getY() == 50) panel.arrow_choice = "reading";
        //System.out.println(panel.arrow_choice);
            }
            
         if(btn1.btn1_choice % 8 == 5){
            
            if(arrow.getY() == 20) panel.arrow_choice = "pill";
            if(arrow.getY() == 50) panel.arrow_choice = "syringe";
        //System.out.println(panel.arrow_choice);
            }    
        
        }
    }

}