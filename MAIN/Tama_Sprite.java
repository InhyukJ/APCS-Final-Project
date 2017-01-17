import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/*
    This class sets up any sprite to be animated
    Its main function is to put all of its animated frames into an imageArray.
    I guess it's kind of useless but it keeps it organized.
*/

public class Tama_Sprite extends JLabel{
    
    private ImageIcon[] defaultArray;
    public int totalFrames, currentFrame, stopFrame;
    public String action;
    public ImageIcon icon;
          
    public Tama_Sprite(ImageIcon img, int t, int stop, String action){
        super(img);
        
        icon = img;
        totalFrames = t;
        currentFrame = 0;
        stopFrame = stop;
        defaultArray = new ImageIcon[totalFrames];
        for(int i = 0; i < defaultArray.length; i++){
            defaultArray[i] = new ImageIcon(action + i + ".png");
        }
        this.action = action;
    }
    
    public ImageIcon[] getImgArray(){
        ImageIcon[] imgArray = new ImageIcon[totalFrames];
        for(int i = 0; i < imgArray.length; i++){
            imgArray[i] = new ImageIcon(defaultArray[i].getImage());
        }
        return imgArray;
    }
    
    public int getCurrentFrame(){
        return currentFrame;
    }
    
   // public void setCurrentFrame(int i){
    //    currentFrame = i;
   // }
    
    public int getStop(){
        return stopFrame;
    }
}
