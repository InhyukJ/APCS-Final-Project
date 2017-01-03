import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;


/*
    This class just animates all the sprites "at once" (well really they just each change their image one by one)
    
*/

public class Animator {
    //private Timer animator;
    private Tama_Sprite[] Sprites;
    private int delay;
    private Point[] coordinates;
    private boolean dark;
    private int xVel = 5;
    private int stopNumber;
    //private final Timer animator;
          
    public Animator(Tama_Sprite[] sprites, int d, Point[] points, boolean darkness){
        delay = d;
        Sprites = sprites;
        coordinates = points;
        dark = darkness;
        for(int i = 0; i < Sprites.length; i++){
            Sprites[i].setBounds((int)coordinates[i].getX(), (int)coordinates[i].getY(), 60, 60);
        }
        stopNumber = 0;
    }
    
    public void animate(){
         //animator = new Timer(delay, this);  
        Timer animator = new Timer(delay, null);
        animator.start();

        animator.addActionListener(new ActionListener() {
            
    public void actionPerformed(ActionEvent evt) {
       
        for(int i = 0; i < Sprites.length; i++){
            ImageIcon[] imgArray = Sprites[i].getImgArray();
            if(Sprites[i].getCurrentFrame() >= imgArray.length){ 
                if(Sprites[i].getStop() == 0) Sprites[i].currentFrame = 0;
            else {
                    stopNumber++;
                    System.out.println(stopNumber == Sprites.length);
                    if(stopNumber == Sprites.length) animator.stop();
                    System.out.println(animator.isRunning());

                    return;
                }
            }
            
           Sprites[i].setIcon(imgArray[Sprites[i].currentFrame]);
            
            if(dark) darken(Sprites[i], imgArray[Sprites[i].currentFrame]);
                
            if(Sprites[i].getStop() == 0) {
                
                int x = Sprites[i].getX();
                x += xVel;
             
                
            if(x > 180){
                xVel *= -1;
                x = 180;
            }
            else if(x < 20) {
                xVel = 5;
                x = 20;
            }
            x += xVel;
                
          Sprites[i].setLocation(new Point(x, Sprites[i].getY()));    
        }
        
            Sprites[i].currentFrame = (Sprites[i].currentFrame + 1);}
         
    }
});
        
    }
    
    
    public void darken(Tama_Sprite sprite, ImageIcon icon){
            ImageIcon darker;
            Image newimg = icon.getImage();
                    BufferedImage buffered = new BufferedImage(newimg.getWidth(null), newimg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    buffered.getGraphics().drawImage(newimg, 0, 0, null);
                    darker = new ImageIcon(buffered);
                    sprite.setIcon(darker);
                    SetBackground.makeDarker(buffered);
    }
    
    //public void actionPerformed(ActionEvent e){
       
   //}
}