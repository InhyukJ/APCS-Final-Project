import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Stats implements ActionListener {
    private double age, weight, health, happy, discipline, hunger, hygiene;
    private Timer life;

    public Stats() {
	age = 0.0;
	weight = 5.0;
	
	hunger = 0.0; //if negative for too long, dies
	smarts = 1.0; //as smarts are increased, can "learn" to do things
	energy = 5.0; //between 10, -10, can decrease with activities, at certain range, decreases hunger
	hygiene = 5.0; //between 10, -10, at certain range, slowly decreases health
	active = 0.0; //can decrease weight(?)
	happy = 0.0; //

	life = new Timer(this, 1000);
    }

    //Accessors
    public double getAge() {return age;}
    public void setAge(double a) {age = a;}
    public double getWeight() {return weight;}
    public void setWeight(double w) {weight = w;}
    public double getHealth() {return health;}
    public void setHealth(double h) {health = h;}
    public double getHappy() {return happy;}
    public void setHappy(double h) {happy = h;}
    public double getDiscipline() {return discipline;}
    public void setDiscipline(double d) {displine = d;}
    public double getHunger() {return hunger;}
    public void setHunger(double h) {hunger = h;}
    public double getHygiene() {return hygiene;}
    public void setHygiene(double h) {hygiene = h;}

    public void actionPerformed(ActionEvent e) {
	setAge(getAge() + 0.25);
	setHunger(getHunger() - 0.05);
    }
    //Sprites stats
    /*
    public void getOlder() {setAge(getAge() + 1.0);}
    public void eating() {
	if (getHealth() + 3.0)
	setHealth(getHealth() + )
    */
    
}
