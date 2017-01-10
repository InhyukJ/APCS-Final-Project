import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public  class Button3 extends Button{
    private SetBackground panel;
    private String btn3_choice;
    private Button1 btn1;
    private JLabel arrow, setting;
    
    public Button3 (BufferedImage img, SetBackground bg){
        super(299, 340, img);
        panel = bg;
        btn3_choice = "";
        btn1 = bg.button1;
        setting = panel.main_screen;
        arrow = panel.arrow;
        
    }
    public void darken(JLabel main_screen, ImageIcon screen_img){
       ImageIcon darker;
       Image newimg = screen_img.getImage();
     BufferedImage buffered = new BufferedImage(newimg.getWidth(null), newimg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      buffered.getGraphics().drawImage(newimg, 0, 0, null);
        darker = new ImageIcon(buffered);
        main_screen.setIcon(darker);
        SetBackground.makeDarker(buffered);  
    }
    public void actionCommand(){
            JLabel arrow = panel.arrow;
            JLabel setting = panel.main_screen;
            
        if((btn1.btn1_choice % 8) == 1 && (!(panel.arrow_exists) || panel.main_screen_choice != 1)){ 
                System.out.println("EATING");
                Tama_Actions.remove_animation(panel); //removes default animation
                ImageIcon mode1choice = new ImageIcon ("mode1_choice.png"); //ImageIcon "mode1_choice" & make 
                panel.main_screen.setIcon(new ImageIcon ("mode1_choice.png"));
                panel.default_choice.add(panel.main_screen); //It adds the choice panels
                panel.main_screen_choice = 1; 
                if(panel.dark) darken(setting, mode1choice); //darken if option is pressed
                panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
                panel.main_screen.add(panel.arrow);
                panel.arrow_exists = true;
                panel.arrow.setBounds(35, 20, 30, 30); //Keep this
                //panel.default_choice.repaint();
            }
        
        else if((btn1.btn1_choice % 8) == 1 && ((panel.arrow_exists) && panel.main_screen_choice == 1)){ //The code checks that the user made a choice
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                //panel.default_choice.setIcon(new ImageIcon ("mode.png"));
               // btn1.button_disable();
                Tama_Actions.eating_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
                                     }
            
        }

	else if((btn1.btn1_choice % 8) == 3 && (!(panel.arrow_exists) || panel.main_screen_choice != 3)){ 
        System.out.println("GAMES");
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode3choice = new ImageIcon ("mode3_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode3_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 3; 
	    if(panel.dark) darken(setting, mode3choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(35, 20, 30, 30); //Keep this
	    //panel.default_choice.repaint();
	}
        
      else if((btn1.btn1_choice % 8) == 3 && ((panel.arrow_exists) && panel.main_screen_choice == 3)){ 
          //The code checks that the user made a choice
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                //panel.default_choice.setIcon(new ImageIcon ("mode.png"));
               // btn1.button_disable();
                //Tama_Actions.eating_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
            }
            
        }   

	else if((btn1.btn1_choice % 8) == 5 && (!(panel.arrow_exists) || panel.main_screen_choice != 5)){ 
        System.out.println("HEALING");
        Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode5choice = new ImageIcon ("mode5_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode5_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 5; 
	    if(panel.dark) darken(setting, mode5choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(35, 20, 30, 30); //Keep this
	    //panel.default_choice.repaint();
	}
        
    else if((btn1.btn1_choice % 8) == 5 && ((panel.arrow_exists) && panel.main_screen_choice == 5)){ //The code checks that the user made a choice
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                //panel.default_choice.setIcon(new ImageIcon ("mode.png"));
               // btn1.button_disable();
                //Tama_Actions.eating_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
            }
            
        } 

	else if((btn1.btn1_choice % 8) == 6 && (!(panel.arrow_exists) | panel.main_screen_choice != 6)){
         System.out.println("LIGHTS");
        Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode5choice = new ImageIcon ("mode6_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode6_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 6; 
	    if(panel.dark) darken(setting, mode6choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(35, 20, 30, 30); //Keep this
	    //panel.default_choice.repaint();
	}
    
      else if((btn1.btn1_choice % 8) == 6 && ((panel.arrow_exists) && panel.main_screen_choice == 6)){ //The code checks that the user made a choice
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                //panel.default_choice.setIcon(new ImageIcon ("mode.png"));
               // btn1.button_disable();
                //Tama_Actions.eating_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
            }
            
        }
    }
    
}            //reminder: make this so the middle button's btn_choice variable is only affected by the location of the arrow
                //make the blue button only work if the current 
