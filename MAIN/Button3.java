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
	// ImageIcon sleep;
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
        
        else if((btn1.btn1_choice % 8) == 1 && ((panel.arrow_exists) && panel.main_screen_choice == 1)){
            if(arrow.getY() == 20) panel.arrow_choice = "meal";
            else if(arrow.getY() != 20) panel.arrow_choice = "snack";
	    System.out.println(panel.arrow_choice);
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
                Tama_Actions.eating_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
            }
            
        }
        
	else if((btn1.btn1_choice % 8) == 2 && (!(panel.arrow_exists) || panel.main_screen_choice != 2)){ 
	    System.out.println("SHOWERING");
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode2choice = new ImageIcon ("mode2_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode2_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 2; 
	    if(panel.dark) darken(setting, mode2choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(20, 20, 30, 30); //Keep this
	    //panel.default_choice.repaint();
	}
        
	else if((btn1.btn1_choice % 8) == 2 && ((panel.arrow_exists) && panel.main_screen_choice == 2)){ 
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
                Tama_Actions.showering_animation(panel);
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
            if(arrow.getY() == 20) panel.arrow_choice = "pill";
	    else if(arrow.getY() != 20) panel.arrow_choice = "syringe";
	    System.out.println(panel.arrow_choice);
	    
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                //panel.default_choice.setIcon(new ImageIcon ("mode.png"));
		// btn1.button_disable();
                Tama_Actions.healing_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
            }
            
        } 
	
	else if((btn1.btn1_choice % 8) == 6 && (!(panel.arrow_exists) | panel.main_screen_choice != 6)){
	    System.out.println("LIGHTS");
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode6choice = new ImageIcon ("mode6_choice.png"); //ImageIcon "mode1_choice" & make 
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
            if(arrow.getY() == 20) panel.arrow_choice = "on";
	    else if(arrow.getY() != 20) panel.arrow_choice = "off";
            if(panel.arrow_choice.equals("on")) panel.dark = false;
            else if(panel.arrow_choice.equals("off")) panel.dark = true;
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
		btn1.darken(new ImageIcon("mode" + (btn1.btn1_choice % 8) + ".png"));
		panel.setStart();
                Tama_Actions.default_animation(panel, true); 
                
                //panel.default_choice.setIcon(new ImageIcon ("mode.png"));
		// btn1.button_disable();
                //Tama_Actions.eating_animation(panel, panel.arrow_choice);
                System.out.println("done");
                
            }
            
        }
        
        else if((btn1.btn1_choice % 8) == 4 && (!(panel.arrow_exists) || panel.main_screen_choice != 4)){ 
            ImageIcon sleep = new ImageIcon();
	    if(panel.sleeping) System.out.println("WAKE");
	    else if(!(panel.sleeping)) System.out.println("SLEEP");
	    Tama_Actions.remove_animation(panel); //removes default animation
	    
	    panel.sleeping = !(panel.sleeping);
           if(panel.sleeping) sleep = new ImageIcon ("sleep.png"); //ImageIcon "mode1_choice" & make
	   else if (!(panel.sleeping)) sleep = new ImageIcon("wake.png");
	   if(panel.sleeping) panel.main_screen.setIcon(new ImageIcon ("sleep.png"));
	   else if (!(panel.sleeping)) panel.main_screen.setIcon(new ImageIcon("wake.png"));
	   panel.default_choice.add(panel.main_screen); //It adds the choice panels
	   panel.main_screen_choice = 4; 
	   if(panel.dark) darken(setting, sleep); //darken if option is pressed
	   panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	   panel.main_screen.add(panel.arrow);
	   panel.arrow_exists = true;
	   panel.arrow.setBounds(10, 20, 30, 30); //Keep this
	   //panel.default_choice.repaint();
	}
        
	else if((btn1.btn1_choice % 8) == 4 && ((panel.arrow_exists) && panel.main_screen_choice == 4)){ 
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
		if(panel.sleeping)Tama_Actions.sleeping_animation(panel, true);
                else if (!(panel.sleeping)) Tama_Actions.sleeping_animation(panel, false);
                System.out.println("done");
                
            }
	}
	
	else if((btn1.btn1_choice % 8) == 8 && (!(panel.arrow_exists) || panel.main_screen_choice != 8)){ 
	    System.out.println("POOPING");
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode8choice = new ImageIcon ("mode8_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode8_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 8; 
	    if(panel.dark) darken(setting, mode8choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(20, 20, 30, 30); //Keep this
	    //panel.default_choice.repaint();
	}
        
	else if((btn1.btn1_choice % 8) == 8 && ((panel.arrow_exists) && panel.main_screen_choice == 8)){ 
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
                Tama_Actions.pooping_animation(panel);
                System.out.println("done");
		
            }
	    
	}    
    }    
}            //reminder: make this so the middle button's btn_choice variable is only affected by the location of the arrow
//make the blue button only work if the current 
