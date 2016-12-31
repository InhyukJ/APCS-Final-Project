import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Tama_Actions{
    //    public Tama_Sprite(ImageIcon img, int t, int stop, String action){
    public static default_animation(SetBackground gui){
        Tama_Sprite main_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-def0.png"), 2, 0, "Mametchi-def");
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        gui.add(main_tamagotchi);
        Point[] coordinate = {new Point(200, 200)}
        Animator default = new Animator(mySpriteArray, 1000, coordinate);
        default.animate();
    }

    public static eating_animation(SetBackground gui, String food){
        Tama_Sprite meal_sprite;
        Tama_Sprite eating_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-eating0.png"), 3, 200, "Mametchi-eating");
         int i = (int)(Math.random() * 3);
        if(food.equals("meal")){
            String meal = "meal" + i + "_";
            meal_sprite = new Tama_Sprite(new ImageIcon(meal + "0.png"), 3, 200, meal);
        }
        else{
            String snack = "snack" + i + "_";
            meal_sprite = new Tama_Sprite(new ImageIcon(snack + "0.png"), 3, 200, snack);
        }
        
        Tama_Sprite[] mySpriteArray = {eating_tamagotchi, meal_sprite};
        gui.add(meal_sprite);
        gui.add(eating_tamagotchi);
        Point[] coordinates = {new Point(240, 200), new Point()};
        Animator eating = new Animator(mySpriteArray, 1000, coordinates);
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




}