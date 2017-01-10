import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Animator {
    private Timer animator;
    private Timer animator2;
    private Tama_Sprite[] sprites;
    private Tama_Sprite[] sprites2;
    private int delay;
    private Point[] coordinates;
    private Point[] coordinates2;
    private boolean dark;
    private int xVel = 5;
    private int stopNumber;
    private SetBackground gui;
    private boolean isDone;
    private boolean stopAnimator;

   
    
    public Animator(Tama_Sprite[] sprites, Tama_Sprite[] sprites2, int d, Point[] points, Point[] points2, boolean darkness, SetBackground bg){
        gui = bg;
        delay = d;
        this.sprites = sprites;
        this.sprites2 = sprites2;
        coordinates = points;
	coordinates2 = points2;
        dark = darkness;
        for(int i = 0; i < sprites.length; i++){
            sprites[i].setBounds((int)coordinates[i].getX(), (int)coordinates[i].getY(), 60, 60);
        }
	for(int i = 0; i < sprites2.length; i++){
            sprites2[i].setBounds((int)coordinates2[i].getX(), (int)coordinates2[i].getY(), 60, 60);
        }
        stopNumber = 0;
        isDone = false;
    }
    
    public void animateHelper(int deez, Tama_Sprite[] Sprites) {
      
	for(int i = 0; i < Sprites.length; i++){
	    ImageIcon[] imgArray = Sprites[i].getImgArray();
	    if(Sprites[i].getCurrentFrame() >= imgArray.length){
            //System.out.println("hey");
		if(Sprites[i].getStop() == 0) Sprites[i].currentFrame = 0;
		else {
		    if (deez == 1) {
                gui.default_choice.remove(Sprites[i]);
                gui.repaint();
			animator.stop();
			gui.default_choice.add(sprites2[0]);
			animator2.start();
			System.out.println("\n\n\n");
		    }
		    else if (deez == 2) {
			animator2.stop();
		    }
		}
	    }
	    
	    else{
		try {
		    Sprites[i].setIcon(imgArray[Sprites[i].currentFrame]);
                } catch (ArrayIndexOutOfBoundsException e){
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
    }
    
    public void animate(){
	
	//animator = new Timer(delay, this);  
        animator = new Timer(delay, null); //Initializes timer
	animator2 = new Timer(delay, null);
	stopAnimator = false;
        for(int i = 0; i < sprites.length; i++){ //adds all the imgs to GUI
            gui.default_choice.add(sprites[i]);
        }
        animator.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {            
		    animator.setDelay(1000);
		    animateHelper(1, sprites);
		}
	    });
	
	animator2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    animateHelper(2, sprites2);
		}
	    });
        
	animator.start();
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
