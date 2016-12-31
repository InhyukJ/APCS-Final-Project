import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Tama_Sprite extends JLabel implements ActionListener{
    private Timer animator;
    private ImageIcon defaultArray[];
    private int delay, totalFrames, currentFrame;
    
    public Tama_Sprite(){
        super(new ImageIcon("Mametchi-def0.png"));
       
    
    }
   
    
    public void animation(int d, int t, String action){
        delay = d;
        totalFrames = t;
        currentFrame = 0;
        defaultArray = new ImageIcon[totalFrames];
        for(int i = 0; i < defaultArray.length; i++){
            defaultArray[i] = new ImageIcon(action + i + ".png");
        }
         animator = new Timer(delay, this);   
         animator.start(); 
    }
    
    public void default_animation(){
        animation(300, 2, "Mametchi-def");
    }
    
    
     public void eating_animation(){
        animation(300, 3, "Mametchi-eating");
    }
    
    public void stop(){
        animator.stop();
        setIcon(new ImageIcon());
    }
    
    public void actionPerformed(ActionEvent e){
        if(currentFrame >= defaultArray.length){
            currentFrame = 0;
        }
       
        setIcon(defaultArray[currentFrame]);
         currentFrame++;
    }
    
       /*private static void createAndShowUI(int i) {
       JFrame frame = new JFrame("Mametchi Animation");
        Tama_Sprite tamagotchi = new Tama_Sprite();
        frame.getContentPane().add(tamagotchi);
        if (i == 1) tamagotchi.default_animation();
        if(i == 2) tamagotchi.eating_animation();
      frame.setPreferredSize(new Dimension(300,300));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
        
      }
    
    public static void main(String[] args){
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI(2);
         }
      }); 
    }*/
}