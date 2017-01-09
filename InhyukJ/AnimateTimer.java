import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class AnimateTimer {
    private Timer animator;
    private Timer animator2;
    private Tama_Sprite[] Sprites;
    private int delay;
    private Point[] coordinates;
    private boolean dark;
    private int xVel = 5;
    private int stopNumber;
    private SetBackground gui;
    private boolean isDone;
    private boolean stopAnimator;
    
    public Animator(Tama_Sprite[] sprites, int d, Point[] points, boolean darkness, SetBackground bg){
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
	
         //animator = new Timer(delay, this);  
        animator = new Timer(delay, null); //Initializes timer
	animator2 = new Timer(delay, null);
	stopAnimator = false;
        for(int i = 0; i < Sprites.length; i++){ //adds all the imgs to GUI
            gui.default_choice.add(Sprites[i]);
        }
        animator.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {            
            //animator.setDelay(delay);
	    if (!stopAnimator) animator.start();
            for(int i = 0; i < Sprites.length; i++){
                ImageIcon[] imgArray = Sprites[i].getImgArray();
                if(Sprites[i].getCurrentFrame() >= imgArray.length){ 
                    if(Sprites[i].getStop() == 0) Sprites[i].currentFrame = 0;
                    else {animator.stop();
			animator2.start();
                    System.out.println("\n\n\n");
                         }
                //    else {isDone = true;
                 //   animator.setRepeats(false);}
                }
           
		else{
		    System.out.println("lol");
		    try {
			Sprites[i].setIcon(imgArray[Sprites[i].currentFrame]);
                } catch (ArrayIndexOutOfBoundsException e){
			//animator.stop();
			System.out.println("WTF");
			gui.default_choice.remove(Sprites[i]);
			gui.repaint();
			
		    }
		    
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
		    
		    Sprites[i].currentFrame = (Sprites[i].currentFrame + 1);
		    
		}
            }
	    // System.out.println(isDone);
	}
		
	    });
        
	animator.start();
        //animator.setRepeats(false);
    }
    
    public void stop(){
        if(isDone) animator.setRepeats(false);
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
