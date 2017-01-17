import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Stats implements ActionListener {
    public double age, weight, health, happy, discipline, hunger, hygiene;
    private Timer life;
    private boolean isAlive, isSick, isStarving, isHappy;
    private SetBackground bg;
    
    public Stats(SetBackground gui) {
    bg = gui;
	age = 0.0;
	weight = 5.0;

	health = 50.0;
	happy = 0.0;
	discipline = 2.0;
	hunger = 5.0; //if negative for too long, dies
	hygiene = 5.0; //between 10, -10, at certain range, slowly decreases health
	isAlive = true;
	isSick = false;
	isStarving = false;
	isHappy = true;
	life = new Timer(3000, this);
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
    public void setDiscipline(double d) {discipline = d;}
    public double getHunger() {return hunger;}
    public void setHunger(double h) {hunger = h;}
    public double getHygiene() {return hygiene;}
    public void setHygiene(double h) {hygiene = h;}

    public void start(){
        life.start();
        
    }
    public void actionPerformed(ActionEvent e) {
	setAge(getAge() + 0.25);
	setHunger(getHunger() - 0.05);
	if (getHealth() <= 0) isAlive = false;
	else isAlive = true;
	if (getHygiene() < -7.5) {
	    isSick = true;
	    setHealth(getHealth() - 0.5);
	}
	else isSick = false;
	if (getHunger() < -2) isStarving = true;
	else isStarving = false;
	if (getHappy() < 0) isHappy = false;
	else isHappy = true;
    setWeight(getWeight() + 0.10);
    
	//if isAlive is false, then dies
    }
    //Sprites stats
    
}
