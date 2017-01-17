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
    private Button2 btn2;
    
    public Button3 (BufferedImage img, SetBackground bg){
        super(299, 340, img);
        panel = bg;
        btn3_choice = "";
        btn1 = bg.button1;
        setting = panel.main_screen;
        arrow = panel.arrow;
        btn2 = bg.button2;
        
    }
    public static void darken(JLabel main_screen, ImageIcon screen_img){
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
	
    // 1 ----------------------------------------------------------------------------------------------
       
        if(panel.main_screen_choice == 70) {
            System.out.println("heyo");
           // panel.main_screen_choice = 0;
            panel.isDigit = false;
        }
        
        if((btn1.btn1_choice % 8) == 1 && (!(panel.arrow_exists) || panel.main_screen_choice != 1)){
            if(!(panel.sleeping)) btn3_choice = "mode1_choice.png";
	       else btn3_choice = "sleeping_alert.png";
	       Tama_Actions.remove_animation(panel); //removes default animation
	       ImageIcon mode1choice = new ImageIcon (btn3_choice); //ImageIcon "mode1_choice" & make 
	       panel.main_screen.setIcon(new ImageIcon (btn3_choice));
	       panel.default_choice.add(panel.main_screen); //It adds the choice panels
	       panel.main_screen_choice = 1; 
	       if(panel.dark) darken(setting, mode1choice); //darken if option is pressed
	       panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	       panel.main_screen.add(panel.arrow);
	       panel.arrow_exists = true;
	       panel.arrow.setBounds(35, 20, 30, 30); //Keep this
	
	}
        
        else if((btn1.btn1_choice % 8) == 1 && ((panel.arrow_exists) && panel.main_screen_choice == 1)){
            if(arrow.getY() == 20) panel.arrow_choice = "meal";
            else if(arrow.getY() != 20) panel.arrow_choice = "snack";
	       
	    
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
               if (!(panel.sleeping)) Tama_Actions.eating_animation(panel, panel.arrow_choice);
                 else{
                        panel.setStart();
                        Tama_Actions.default_animation(panel, true); 
                    }
                }
                
            }
            
               
  // 2 --------------------------------------------------------------------------------------------------              
        
	else if((btn1.btn1_choice % 8) == 2 && (!(panel.arrow_exists) || panel.main_screen_choice != 2)){ 
	    if(!(panel.sleeping)) btn3_choice = "mode2_choice.png";
        else btn3_choice = "sleeping_alert.png";
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode2choice = new ImageIcon (btn3_choice); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon (btn3_choice));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 2; 
	    if(panel.dark) darken(setting, mode2choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(10, 20, 30, 30); //Keep this
	   
	}
        
	else if((btn1.btn1_choice % 8) == 2 && ((panel.arrow_exists) && panel.main_screen_choice == 2)){ 
	    
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                
               if(!(panel.sleeping)) Tama_Actions.showering_animation(panel);
                else{
                        panel.setStart();
                        Tama_Actions.default_animation(panel, true); 
                    }
                }
               
            }
     
        
 // 3 ---------------------------------------------------------------------------------------------------       
        
	else if((btn1.btn1_choice % 8) == 3 && (!(panel.arrow_exists) && panel.main_screen_choice == 10)){ 
	    ImageIcon gamechoice = new ImageIcon ("r_p_s.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("r_p_s.png"));
	   // panel.default_choice.add(panel.main_screen); //It adds the choice panels
	   // panel.main_screen_choice = 10; 
	    if(panel.dark) darken(setting, gamechoice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(35, 25, 30, 30); //Keep this
	    btn2.game_mode = true;
	}
        
    else if((btn1.btn1_choice % 8) == 3 && ((panel.arrow_exists) && panel.main_screen_choice == 10)){ 
            btn2.game_mode = false;
	       if(arrow.getY() == 25) panel.arrow_choice = "rock";
	        else if(arrow.getY() == 40) panel.arrow_choice = "paper";
            else if(arrow.getY() == 60) panel.arrow_choice = "scissors";
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                Tama_Actions.game_animation(panel, panel.arrow_choice);
            }
            
	}
	
    else if((btn1.btn1_choice % 8) == 3 && (!(panel.arrow_exists) || panel.main_screen_choice != 3 || panel.main_screen_choice == 0)){ 
	    if(!(panel.sleeping)) btn3_choice = "mode3_choice.png";
        else btn3_choice = "sleeping_alert.png";
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode3choice = new ImageIcon (btn3_choice); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon (btn3_choice));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 3; 
	    if(panel.dark) darken(setting, mode3choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(35, 20, 30, 30); //Keep this
	    
	}
        
	else if((btn1.btn1_choice % 8) == 3 && ((panel.arrow_exists) && panel.main_screen_choice == 3)){ 
	        if(arrow.getY() == 20) panel.arrow_choice = "game";
	        else if(arrow.getY() != 20) panel.arrow_choice = "scold";
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                
                if(!(panel.sleeping)){
                    if(panel.arrow_choice.equals("scold")) Tama_Actions.scolding_animation(panel);
                    else if(panel.arrow_choice.equals("game")){
                        ImageIcon gamechoice = new ImageIcon ("game_intro.png"); //ImageIcon "mode1_choice" & make 
	                   panel.main_screen.setIcon(new ImageIcon ("game_intro.png"));
	                   panel.default_choice.add(panel.main_screen); //It adds the choice panels
	                   panel.main_screen_choice = 10; 
	                   if(panel.dark) darken(setting, gamechoice); //darken if option is pressed
	                   panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
                        
                    }
            }
                 else{
                        panel.setStart();
                        Tama_Actions.default_animation(panel, true); 
                    }      
        } 
        
    }
                
     // 5  -------------------------------------------------------------------------------------------------
	
        
	else if((btn1.btn1_choice % 8) == 5 && (!(panel.arrow_exists) || panel.main_screen_choice != 5)){ 
	    if(!(panel.sleeping)) btn3_choice = "mode5_choice.png";
        else btn3_choice = "sleeping_alert.png";
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode5choice = new ImageIcon (btn3_choice); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ((btn3_choice)));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 5; 
	    if(panel.dark) darken(setting, mode5choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(35, 20, 30, 30); //Keep this
	    
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
                
              if(!(panel.sleeping)) Tama_Actions.healing_animation(panel, panel.arrow_choice);
                else {
                        panel.setStart();
                        Tama_Actions.default_animation(panel, true); 
                    }
                }
                
            }
            
         
// 6 ------------------------------------------------------------------------------------------------------        
	
	else if((btn1.btn1_choice % 8) == 6 && (!(panel.arrow_exists) | panel.main_screen_choice != 6)){
	    btn3_choice = "mode6_choice.png";
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode6choice = new ImageIcon ((btn3_choice)); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ((btn3_choice)));
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
              
            }  
        }
        
// 4 ----------------------------------------------------
        
        
    else if((btn1.btn1_choice % 8) == 4 && (!(panel.arrow_exists) || panel.main_screen_choice != 4)){ 
        ImageIcon sleep = new ImageIcon();
	   
	    Tama_Actions.remove_animation(panel); //removes default animation
	    
	   
        if(!(panel.sleeping)) btn3_choice = "sleep.png";
        else if (panel.sleeping) btn3_choice = "wake.png";
        sleep = new ImageIcon (btn3_choice); //ImageIcon "mode1_choice" & make
	   
	   panel.main_screen.setIcon(new ImageIcon (btn3_choice));
	   
	   panel.default_choice.add(panel.main_screen); //It adds the choice panels
	   panel.main_screen_choice = 4; 
	   if(panel.dark) darken(setting, sleep); //darken if option is pressed
	   panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	   panel.main_screen.add(panel.arrow);
	   panel.arrow_exists = true;
	   panel.arrow.setBounds(10, 20, 30, 30); //Keep this
	  
	}
        
	else if((btn1.btn1_choice % 8) == 4 && ((panel.arrow_exists) && panel.main_screen_choice == 4)){ 
         panel.sleeping = !(panel.sleeping);
	    //The code checks that the user made a choice
            panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                
		      if(panel.sleeping)Tama_Actions.sleeping_animation(panel, true);
                else if (!(panel.sleeping)) Tama_Actions.sleeping_animation(panel, false);
                //System.out.println("done");
                
            }
	}
        
// 8  -------------------------------------------------------------------------------------------------
	
	else if((btn1.btn1_choice % 8) == 0 && (!(panel.arrow_exists) || panel.main_screen_choice != 8)){ 
	   panel.isPooing = false;//Keep this
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode8choice = new ImageIcon ("mode8_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode8_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 8; 
	    if(panel.dark) darken(setting, mode8choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(10, 20, 30, 30);
        
	    
	}
        
	else if((btn1.btn1_choice % 8) == 0 && ((panel.arrow_exists) && panel.main_screen_choice == 8)){ 
	    
	       panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                
                Tama_Actions.pooping_animation(panel);
                //panel.isPooing = true;
                System.out.println("done");
            }
        }
        
    // 7 ------------------------------------------------------------------------------------------------
        
        else if((btn1.btn1_choice % 8) == 7 && (!(panel.arrow_exists) || panel.main_screen_choice != 7)){ 
	   
	    Tama_Actions.remove_animation(panel); //removes default animation
	    ImageIcon mode8choice = new ImageIcon ("mode7_choice.png"); //ImageIcon "mode1_choice" & make 
	    panel.main_screen.setIcon(new ImageIcon ("mode7_choice.png"));
	    panel.default_choice.add(panel.main_screen); //It adds the choice panels
	    panel.main_screen_choice = 7; 
	    if(panel.dark) darken(setting, mode8choice); //darken if option is pressed
	    panel.main_screen.setBounds(3, 50, 230, 130); //Keep this
	    panel.main_screen.add(panel.arrow);
	    panel.arrow_exists = true;
	    panel.arrow.setBounds(20, 20, 30, 30);
        
	    
	}
        
	else if((btn1.btn1_choice % 8) == 7 && ((panel.arrow_exists) && panel.main_screen_choice == 7)){ 
	    
            if(arrow.getY() == 20) panel.arrow_choice = "age";
	       else if(arrow.getY() != 20) panel.arrow_choice = "meters";
        
	       System.out.println(panel.arrow_choice);
	       panel.main_screen.remove(panel.arrow);
            panel.repaint();
            panel.arrow_exists = false;
            panel.default_choice.remove(panel.main_screen);
            panel.main_screen_choice = 0;
            panel.repaint();
            if(!(panel.arrow_exists)){
                panel.isDigit = true;
                if(panel.arrow_choice.equals("age")) Tama_Actions.display_age(panel);
                else if(panel.arrow_choice.equals("meters")) Tama_Actions.display_meters(panel);
            }
        }
        
        
    }
    
}      