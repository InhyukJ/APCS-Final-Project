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
        Animator1 default_animator = new Animator1(mySpriteArray, 100, coordinate, gui.dark, gui);
        default_animator.animate();
        System.out.println("heeyyy");
        
    }
    
    public static void remove_animation(SetBackground gui){
        default_animation(gui, false);
        gui.default_choice.remove(gui.def_sprite);
        gui.repaint();
    }
    
    public static void poo(SetBackground gui){
        System.out.println("yo");
        Tama_Sprite pooping_sprite = new Tama_Sprite(new ImageIcon("poop0.png"), 1, 200, ("poop"));
        Tama_Sprite[] mySpriteArray = {pooping_sprite};
        Point[] coordinate = {new Point((int)(Math.random() * 100), (int)(Math.random() * 100))};
        Animator1 default_animator = new Animator1(mySpriteArray, 100, coordinate, gui.dark, gui);
        default_animator.animate();
    }

    public static void eating_animation(SetBackground gui, String food){
        gui.poop += 1;
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
        Animator eating = new Animator(mySpriteArray1, mySpriteArray, 800, coordinates, coordinate, gui.dark, gui);
        eating.animate();
        if(gui.poop > 0 && gui.poop % 5 == 0){
            Tama_Actions.poo(gui);
        }
	
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
        Animator shower = new Animator(mySpriteArray1, mySpriteArray,  800, coordinates, coordinate, gui.dark, gui);
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
        Point[] coordinates = {new Point(90, 110), new Point(30, 100)};
        Animator eating = new Animator(mySpriteArray1, mySpriteArray,  800, coordinates, coordinate, gui.dark, gui);
        eating.animate();
    }

    public static void sleeping_animation(SetBackground gui, boolean sleeping) {
        Tama_Sprite living_tamagotchi =   new Tama_Sprite(new ImageIcon("Mametchi-def0.png"), 2, 0, "Mametchi-def");
        Tama_Sprite sleeping_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-sleeping0.png"), 2, 0, "Mametchi-sleeping");
        if(sleeping)gui.def_sprite = sleeping_tamagotchi;
        else if (!(sleeping)) gui.def_sprite = living_tamagotchi;
        default_animation(gui, true);
    }

    public static void pooping_animation(SetBackground gui){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite pooping_sprite;
        //gui.def_sprite = 
        Tama_Sprite pooping_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi_pooping0.png"), 4, 200, "Mametchi_pooping"); 
      
         
        pooping_sprite = new Tama_Sprite(new ImageIcon("flush0.png"), 4, 200, ("flush"));
       
        Tama_Sprite main_tamagotchi = gui.def_sprite;
        gui.setStart();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Tama_Sprite[] mySpriteArray1 = {pooping_tamagotchi, pooping_sprite};

        Point[] coordinate = {new Point(50, 100)};
        Point[] coordinates = {new Point(80, 110), new Point(100, 50)};
        Animator pooping = new Animator(mySpriteArray1, mySpriteArray,  800, coordinates, coordinate, gui.dark, gui);
        pooping.animate();
    }
    
     public static void scolding_animation(SetBackground gui){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite scolding_sprite;
        
        Tama_Sprite sad_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-sad0.png"), 2, 200, "Mametchi-sad"); 
            
        scolding_sprite = new Tama_Sprite(new ImageIcon("scold0.png"), 2, 200, "scold");
         
        Tama_Sprite main_tamagotchi = gui.def_sprite;
        gui.setStart();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Tama_Sprite[] mySpriteArray1 = {sad_tamagotchi, scolding_sprite};

        Point[] coordinate = {new Point(50, 100)};
        Point[] coordinates = {new Point(90, 110), new Point(30, 100)};
        Animator scolding = new Animator(mySpriteArray1, mySpriteArray,  1500, coordinates, coordinate, gui.dark, gui);
        scolding.animate();
    }
    
    public static void game_animation(SetBackground gui, String rps){
        JLabel tama_setting = gui.default_choice;
        Tama_Sprite game_sprite;
        Tama_Sprite result_sprite;
        
        Tama_Sprite game_tamagotchi = new Tama_Sprite(new ImageIcon("Mametchi-def0.png"), 2, 200, "Mametchi-def"); 
            
        int i = ((int)(Math.random() * 100) % 3);
        System.out.println((Math.random() * 100));
        game_sprite = new Tama_Sprite(new ImageIcon("game" + i + "-0.png"), 2, 200, ("game" + i + "-"));
        
        if ((i == 1 && rps.equals("paper")) || (i == 2 && rps.equals("scissors")) || (i == 0 && rps.equals("rock"))){
            result_sprite = new Tama_Sprite(new ImageIcon("win0.png"), 2, 200, "win");
        }
        
        else if((i == 0 && rps.equals("scissors"))|| (i == 1 && rps.equals("rock")) || (i == 2 && rps.equals("paper"))){
            result_sprite = new Tama_Sprite(new ImageIcon("tie0.png"), 2, 200, "tie");
        }
        
        else{
            result_sprite = new Tama_Sprite(new ImageIcon("lose0.png"), 2, 200, "lose");
        }
        
        Tama_Sprite main_tamagotchi = gui.def_sprite;
        gui.setStart();
        Tama_Sprite[] mySpriteArray = {main_tamagotchi};
        Tama_Sprite[] mySpriteArray1 = {game_tamagotchi, game_sprite, result_sprite};

        Point[] coordinate = {new Point(50, 100)};
        Point[] coordinates = {new Point(90, 110), new Point(30, 50), new Point(20, 100)};
        Animator game = new Animator(mySpriteArray1, mySpriteArray,  1000, coordinates, coordinate, gui.dark, gui);
        game.animate();
    }
    
    
    
}
