import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Tama_Actions{
    //    public Tama_Sprite(ImageIcon img, int t, int stop, String action){
    public static void default_animation(SetBackground gui, boolean run){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite main_tamagotchi = gui.def_sprite;
        if(!run) gui.setStop();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Point[] coordinate = {new Point(50, 100)};
        Animator1 default_animator = new Animator1(mySpriteArray, 300, coordinate, gui.dark, gui);
        default_animator.animate();
        System.out.println("heeyyy");
        
    }
    
    public static void remove_animation(SetBackground gui){
        default_animation(gui, false);
        gui.default_choice.remove(gui.def_sprite);
        gui.repaint();
    }

    public static void eating_animation(SetBackground gui, String food){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite meal_sprite;
        //gui.def_sprite = 
        Tama_Sprite eating_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-eating0.png"), 3, 200, "Mametchi-eating"); 
         int i = (int)(Math.random() * 3);
      
        if(food.equals("meal")){
        String meal = ("meal" + i + "_");
         
            meal_sprite = new Tama_Sprite(new ImageIcon("meal" + i + "_" + "0.png"), 3, 200, ("meal" + i + "_"));
        }
        else{
            String snack = "snack" + i + "_";
            meal_sprite = new Tama_Sprite(new ImageIcon(snack + "0.png"), 3, 200, snack);
            
        }
        Tama_Sprite main_tamagotchi = gui.def_sprite;
       gui.setStart();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Tama_Sprite[] mySpriteArray1 = {eating_tamagotchi, meal_sprite};

        Point[] coordinate = {new Point(50, 100)};
        Point[] coordinates = {new Point(80, 100), new Point(10, 100)};
        Animator eating = new Animator(mySpriteArray1, mySpriteArray,  500, coordinates, coordinate, gui.dark, gui);
        eating.animate();
    }
    
     public static void showering_animation(SetBackground gui){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite shower_sprite;
        //gui.def_sprite = 
        Tama_Sprite showering_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-showering0.png"), 3, 200, "Mametchi-showering"); 
      
         
        shower_sprite = new Tama_Sprite(new ImageIcon("shower-head0.png"), 3, 200, ("shower-head"));
       
        Tama_Sprite main_tamagotchi = gui.def_sprite;
        gui.setStart();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Tama_Sprite[] mySpriteArray1 = {showering_tamagotchi, shower_sprite};

        Point[] coordinate = {new Point(50, 100)};
        Point[] coordinates = {new Point(80, 110), new Point(100, 50)};
        Animator shower = new Animator(mySpriteArray1, mySpriteArray,  500, coordinates, coordinate, gui.dark, gui);
        shower.animate();
    }
    
     public static void healing_animation(SetBackground gui, String medicine){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite medicine_sprite;
        //gui.def_sprite = 
        Tama_Sprite healing_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-healing0.png"), 4, 200, "Mametchi-healing"); 
        
        System.out.println(gui.arrow_choice + "yoo");
        if(medicine.equals("pill")){
            medicine_sprite = new Tama_Sprite(new ImageIcon("pill0.png"), 4, 200, "pill");
        }
        else{
            
            medicine_sprite = new Tama_Sprite(new ImageIcon("syringe0.png"), 4, 200, "syringe");
            
        }
        Tama_Sprite main_tamagotchi = gui.def_sprite;
       gui.setStart();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Tama_Sprite[] mySpriteArray1 = {healing_tamagotchi, medicine_sprite};

        Point[] coordinate = {new Point(50, 100)};
        Point[] coordinates = {new Point(80, 110), new Point(100, 50)};
        Animator eating = new Animator(mySpriteArray1, mySpriteArray,  500, coordinates, coordinate, gui.dark, gui);
        eating.animate();
    }

    // Put more animation sequences here:
    //first make the actual sprites you want to animate on a photo editor and name it like I did for some of the frames
    //declare each sprite
    //make a sprite array
    //make an array of coordinates
    //add it to gui
    //make an Animator instance
    //call animate() method
}
