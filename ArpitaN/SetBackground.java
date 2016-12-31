import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;


public class SetBackground
extends JPanel {
    public static final String BACKGROUND_URL = "https://d2xngy2dw7hums.cloudfront.net/media/photos/products/2015/01/01/pre_order_tamagotchi_4u_faceplate_1420044532_81fed84a.jpg";
    private BufferedImage backgroundImage;
    private BufferedImage btn1;
    private BufferedImage btn2;
    private BufferedImage btn3;
    private ImageIcon tamagotchi;
    private Dimension background;
    private URL backgroundimg = new URL("https://d2xngy2dw7hums.cloudfront.net/media/photos/products/2015/01/01/pre_order_tamagotchi_4u_faceplate_1420044532_81fed84a.jpg");
    public int btn1_choice;
    public int btn2_choice;
    public int btn3_choice;
    public boolean dark = false;
    public JLabel default_choice;
    public Button1 button1;

    public SetBackground() throws MalformedURLException, IOException {
        backgroundImage = ImageIO.read(this.backgroundimg);
        btn1 = ImageIO.read(new URL("http://www.clker.com/cliparts/a/9/3/e/1194984754884631372button-blue_benji_park_01.svg.med.png"));
        btn2 = ImageIO.read(new URL("http://www.clker.com/cliparts/4/8/d/d/11949847561597560220button-seagreen_benji_pa_01.svg.med.png"));
        btn3 = ImageIO.read(new URL("http://www.clker.com/cliparts/1/5/6/8/11949847551060334388button-purple_benji_park_01.svg.med.png"));
        tamagotchi = new ImageIcon("mode.png");
        Image image = this.tamagotchi.getImage().getScaledInstance(246, 240, Image.SCALE_SMOOTH);
        tamagotchi = new ImageIcon(image);
        setBackground(Color.white);
        background = new Dimension(500, 450);
        setPreferredSize(background);
        setLayout(null);
        default_choice = new JLabel(tamagotchi);
        add((Component)this.default_choice);
        default_choice.setBounds(124, 97, 246, 240);
        button1 = new Button1(btn1, this);
        add((Component)this.button1);
        JLabel jLabel = new JLabel(new ImageIcon(btn2.getScaledInstance(54, 53, Image.SCALE_SMOOTH)));
        add((Component)jLabel);
        jLabel.setBounds(220, 359, 54, 53);
        JLabel jLabel2 = new JLabel(new ImageIcon(btn3.getScaledInstance(54, 53, Image.SCALE_SMOOTH)));
        add((Component)jLabel2);
        jLabel2.setBounds(299, 340, 54, 53);
    }

    public static void makeDarker(BufferedImage bufferedImage) {
        for (int i = 0; i < bufferedImage.getWidth(); ++i) {
            for (int j = 0; j < bufferedImage.getHeight(); ++j) {
                int n = bufferedImage.getRGB(i, j);
                Color color = new Color(n);
                int n2 = (n >> 24) & 0xff ;
                int n3 = (n >> 16) & 0xff ;
                int n4 = (n >> 8) & 0xff ;
                int n5 = n & 0xff ;
                if (n3 >= 55) {
                    n3 -= 50;
                }
                if (n4 >= 55) {
                    n4 -= 50;
                }
                if (n5 >= 55) {
                    n5 -= 50;
                }
                color = new Color(n3, n4, n5);
                bufferedImage.setRGB(i, j, color.getRGB());
            }
        }
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.backgroundImage != null) {
            graphics.drawImage(this.backgroundImage.getScaledInstance(500, 450, 1), 0, 0, null);
        }
    }

    private static void createAndShowUI() {
        JFrame jFrame = new JFrame("OverLayImages");
        try {
            jFrame.getContentPane().add((Component)new SetBackground());
        }
        catch (MalformedURLException var1_1) {
            var1_1.printStackTrace();
            System.exit(1);
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
            System.exit(1);
        }
        jFrame.setDefaultCloseOperation(3);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] arrstring) {
       java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
    }
}