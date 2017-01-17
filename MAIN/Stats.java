import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Stats implements ActionListener {
    public double age, weight, health, happy, discipline, hunger, hygiene;
    private int ticker;
    private Timer life;
    private boolean isAlive, isSick, isStarving, isHappy;
    private ImageIcon dead;
    private SetBackground bg;
    
    public Stats(SetBackground gui) {
	bg = gui;
	age = 0.0;
	weight = 5.0;

	health = 5.0;
	happy = 0.0;
	discipline = 2.0;
	hunger = 5.0; //if negative for too long, dies
	hygiene = 5.0; //between 10, -10, at certain range, slowly decreases health
	ticker = 1;
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
    public int getTicker() {return ticker;}
    public void setTicker(int t) {ticker = t;}

    public void start(){
        life.start();
        
    }

    public void eating() {
	setWeight(getWeight()+0.1);
	setHunger(getHunger()-0.5);
	setHappy(getHappy()+0.5);
    }

    public void showering() {
	setHygiene(getHygiene()+1.0);
    }

    public void playing() {
	setHappy(getHappy()+1.0);
	setHealth(getHealth()+0.5);
	setDiscipline(getDiscipline()-0.5);
	setWeight(getWeight()-0.5);
    }

    public void scolding() {
	setDiscipline(getDiscipline()+1.5);
	setHappy(getHappy()-0.5);
    }

    public void sleeping() {
	setHappy(getHappy() + 0.5);
	setHealth(getHealth()+2.5);
    }

    public void healing() {
	setHealth(getHealth()+4.0);
    }

    public void pooping() {
	setDiscipline(getDiscipline() + 1.0);
    setHygiene(getHygiene() + 0.5);
    }
    

    
    public void actionPerformed(ActionEvent e) {
	setAge(getAge() + 0.25);
	setWeight(getWeight()+0.1);
        
    if (getTicker() % 5 == 0){
        setHealth (getHealth() - 0.4);
    }
	if (getTicker() % 3 == 0){
	    setHunger(getHunger() + 0.5);
	    setHygiene(getHygiene()-0.5);
        
	}
	setTicker(getTicker() + 1);
	
	if (getHealth() <= 0) {
	    isAlive = false;
	    life.stop();
	    bg.remove(bg.default_choice);
	    bg.repaint();
	    bg.add(bg.dead_screen);
	}
	else isAlive = true;
	if (getHealth() <= 1.5) {
	    isSick = true;
	    setHygiene(getHygiene()-1.0);
	}
	else isSick = false;
	if (getHunger() < 0) isStarving = true;
	else isStarving = false;
	if (getHappy() < 0) isHappy = false;
	else isHappy = true;
	
	if (getHealth() >= 4.0) setHealth(4.0);
	if (getHealth() <= 0.0) setHealth(0.0);
	if (getHappy() >= 4.0) setHappy(4.0);
	if (getHappy() <= 0.0) setHappy(0.0);
	if (getDiscipline() >= 4.0) setDiscipline(4.0);
	if (getDiscipline() <= 0.0) setDiscipline(0.0);
	if (getHunger() >= 4.0) setHunger(4.0);
	if (getHunger() <= 0.0) setHunger(0.0);
	if (getHygiene() >= 4.0) setHygiene(4.0);
	if (getHygiene() <= 0.0) setHygiene(0.0);
    
    System.out.println("Hunger: "+ getHunger() + "\n Health: " + getHealth() + "\n Happy: " + getHappy() + "\n Discipline: " + getDiscipline() + "\n Hygiene: " + getHygiene() + "\n Sick?: " + isSick);
	//if isAlive is false, then dies
    }
    //Sprites stats
    
}
