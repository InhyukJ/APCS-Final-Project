import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Tama_Actions{
    //    public Tama_Sprite(ImageIcon img, int t, int stop, String action){
    public static void default_animation(SetBackground gui){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite main_tamagotchi = gui.def_sprite;
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        tama_setting.add(main_tamagotchi);
        Point[] coordinate = {new Point(50, 100)};
        Animator default_animator = new Animator(mySpriteArray, 300, coordinate, gui.dark);
        default_animator.animate();
        
    }
    
    public static void remove_animation(SetBackground gui){
        JLabel tama_setting = gui.default_choice;
        tama_setting.remove(gui.def_sprite);
        gui.default_choice.repaint();
    }

    public static void eating_animation(SetBackground gui, String food){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite meal_sprite;
        gui.def_sprite = new Tama_Sprite(new ImageIcon("Mametchi-eating0.png"), 3, 200, "Mametchi-eating"); 
        Tama_Sprite eating_tamagotchi = gui.def_sprite; 
         int i = (int)(Math.random() * 3);
       // System.out.println((int)(Math.random() * 3));
        if(food.equals("meal")){
        String meal = ("meal" + i + "_");
          //System.out.println(meal);
            meal_sprite = new Tama_Sprite(new ImageIcon("meal" + i + "_" + "0.png"), 3, 200, ("meal" + i + "_"));
        }
        else{
            String snack = "snack" + i + "_";
            meal_sprite = new Tama_Sprite(new ImageIcon(snack + "0.png"), 3, 200, snack);
        }
        
        Tama_Sprite[] mySpriteArray = {eating_tamagotchi, meal_sprite};
        tama_setting.add(meal_sprite);
        tama_setting.add(eating_tamagotchi);
        Point[] coordinates = {new Point(50, 70), new Point(10, 50)};
        Animator eating = new Animator(mySpriteArray, 1000, coordinates, gui.dark);
        eating.animate();
        System.out.println("is animating");
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