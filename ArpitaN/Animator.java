import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;


/*
    This class just animates all the sprites "at once" (well really they just each change their image one by one)
    
*/

public class Animator implements ActionListener {
    private Timer animator;
    private Tama_Sprite[] Sprites;
    private int delay;
    private Point[] coordinates;
          
    public Animator(Tama_Sprite[] sprites, int d, Point[] points){
        delay = d;
        Sprites = sprites;
        coordinates = points;
        for(int i = 0; i < Sprites.length; i++){
            Sprites[i].setBounds(coordinates[i].getX(), coordinates[i].getY(), 30, 30);
        }
    }
    
    public void animate(){
         animator = new Timer(delay, this);   
         animator.start();   
    }
    
    public void stop(int i){
        if(animator.isRunning() && i == (Sprites.length - 1)) animator.stop();
    }
    
    public void actionPerformed(ActionEvent e){
       int xVel = 5;
        
        for(int i = 0; i < Sprites.length; i++){
            ImageIcon[] imgArray = Sprites[i].getImgArray();
            
            if(Sprites[i].getCurrentFrame() >= imgArray.length){ 
                if(Sprites[i].getStop() == 0) Sprites[i].setCurrentFrame(0);
            else {
                    animator.setDelay(Sprites[i].getStop());
                    stop(i);
                    Sprites[i].setIcon(new ImageIcon());
                }
            }
        Sprites[i].setIcon(imgArray[Sprites[i].getCurrentFrame()]);
         
            if(Sprites[i].getStop() == 0) {
            if(Sprites[i].getX() >= 300 || Sprites[i].getX() <= 130) {
                xVel *= -1;
            }
            
            Sprites[i].setLocation(new Point(getX() + xVel, getY()));
        }
        
            Sprites[i].setCurrentFrame(Sprites[i].getCurrentFrame() + 1);
        } 
   }
}