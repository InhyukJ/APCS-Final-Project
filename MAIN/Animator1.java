import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;


/*
    This class just animates all the sprites "at once" (well really they just each change their image one by one)
    
*/

public class Animator1 {
    private Timer animator, poo_animator;
    private Tama_Sprite[] Sprites;
    private int delay;
    private Point[] coordinates;
    private boolean dark;
    private int xVel = 5;
    private int stopNumber;
    private SetBackground gui;
    private boolean isDone;
          
    public Animator1(Tama_Sprite[] sprites, int d, Point[] points, boolean darkness, SetBackground bg){
        gui = bg;
        delay = d;
        Sprites = sprites;
        coordinates = points;
        dark = darkness;
        for(int i = 0; i < Sprites.length; i++){
            Sprites[i].setBounds((int)coordinates[i].getX(), (int)coordinates[i].getY(), 60, 60);
        }
        stopNumber = 0;
        isDone = false;
    }
    
    public void animate(){
        dark = gui.dark;
        
        animator = new Timer(delay, null);
        poo_animator = new Timer(delay, null);
        for(int i = 0; i < Sprites.length; i++){
           
           if(Sprites[i].action.equals("digit")) {
               gui.main_screen.add(Sprites[i]);
               if(dark) darken(Sprites[0], Sprites[0].icon);
           }
            else {
                gui.default_choice.add(Sprites[i]);
                if(dark) darken(Sprites[0], Sprites[0].getImgArray()[0]);
            }
            
        }
        
        poo_animator.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {            
            animator.setDelay(delay);
            dark = gui.dark;
        
            for(int i = 0; i < Sprites.length; i++){
                
                
                if(Sprites[i].action.equals("poop")){
                    
                    ImageIcon[] imgArray = Sprites[i].getImgArray();
                    if(!(gui.isPooing)){
                        poo_animator.stop();
                        gui.default_choice.remove(Sprites[i]);
                        gui.repaint();
                    }
                }
            }
        }
        });
        
        animator.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {            
            animator.setDelay(delay);
            dark = gui.dark;
        
            for(int i = 0; i < Sprites.length; i++){
                
                
                if(Sprites[i].action.equals("digit")){
                   
                    ImageIcon[] imgArray = Sprites[i].getImgArray();
                    if(!(gui.isDigit)){
                        animator.stop();
                        
                        gui.main_screen.remove(Sprites[i]);
                        gui.repaint();
                        
                    }
                  //  if(dark) darken(Sprites[i], imgArray[Sprites[i].currentFrame]);
                    
                }
                
                else {
                ImageIcon[] imgArray = Sprites[i].getImgArray();
                if(Sprites[i].getCurrentFrame() >= imgArray.length){ 
                    if(Sprites[i].getStop() == 0) Sprites[i].currentFrame = 0;
                    else {animator.stop();
                         }
               
                }
           
        else{
            try {
                    Sprites[i].setIcon(imgArray[Sprites[i].currentFrame]);
                } catch (ArrayIndexOutOfBoundsException e){
                animator.stop();
                System.out.println("WTF");
                gui.default_choice.remove(Sprites[i]);
                gui.repaint();
               
            }
            
            if(dark) darken(Sprites[i], imgArray[Sprites[i].currentFrame]);
                
            if((Sprites[i].getStop() == 0) && !(gui.sleeping)) {
                
                int x = Sprites[i].getX();
                x += xVel;
             
                
                if(x > 150){
                    xVel *= -1;
                    x = 150;
                }
                else if(x < 40) {
                    xVel = 5;
                    x = 40;
                }
                x += xVel;
                
                Sprites[i].setLocation(new Point(x, Sprites[i].getY()));    
            }
        
                Sprites[i].currentFrame = (Sprites[i].currentFrame + 1);
         
            }
            }
            }
         }
        
        });
        
        if(Sprites[0].action.equals("poop")) poo_animator.start();
        else animator.start();
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
    
}