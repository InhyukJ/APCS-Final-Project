import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Button extends JLabel{
    public int btn_choice;
    public ImageIcon color;
    
    public Button(int x, int y, BufferedImage img){
        super(new ImageIcon(img.getScaledInstance(54, 53, Image.SCALE_SMOOTH)));
        color = new ImageIcon(img.getScaledInstance(54, 53, Image.SCALE_SMOOTH));
        
        setBounds(x, y, 54, 53);
        
        addMouseListener(new MouseAdapter() {
                         
                @Override
                public void mouseClicked(MouseEvent e){
                    btn_choice++;
                    actionCommand();
                }
            
                public void mousePressed(MouseEvent e){
                    ImageIcon darker;
                    Image newimg = color.getImage();
                    BufferedImage buffered = new BufferedImage(newimg.getWidth(null), newimg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    buffered.getGraphics().drawImage(newimg, 0, 0, null);
                    darker = new ImageIcon(buffered);
                    setIcon(darker);
                    SetBackground.makeDarker(buffered);
                }
    
                public void mouseReleased(MouseEvent e){
                    setIcon(color);
                }
        });
    
    }

    public abstract void actionCommand();



}