public class Stats {
    private static double age; //days, should progressively make gameplay more difficult
    private static double weight; //affects health

    private static double hunger; //affects energy
    private static double smarts; //affects hygiene, 
    private static double energy; //affects active, happy
    private static double hygiene; //affects physical state
    private static double active; //affects weight
    private static double happy; //affects emotional state

    public Stats() {
	age = 0.0;
	weight = 5.0;
	
	hunger = 0.0; //if negative for too long, dies
	smarts = 1.0; //as smarts are increased, can "learn" to do things
	energy = 5.0; //between 10, -10, can decrease with activities, at certain range, decreases hunger
	hygiene = 5.0; //between 10, -10, at certain range, slowly decreases health
	active = 0.0; //can decrease weight(?)
	happy = 0.0; //
    }

    //Accessors
    public static double getAge() {return age;}
    public static void setAge(double a) {age = a;}
    public static double getWeight() {return weight;}
    public static void setWeight(double w) {weight = w;}
    public static double getHunger() {return hunger;}
    public static void setHunger(double h) {hunger = h;}
    public static double getSmarts() {return smarts;}
    public static void setSmarts(double s) {smarts = s;}
    public static double getEnergy() {return energy;}
    public static void setEnergy(double e) {energy = e;}
    public static double getHygiene() {return hygiene;}
    public static void setHygiene(double h) {hygiene = h;}
    public static double getActive() {return active;}
    public static void setActive(double a) {active = a;}
    public static double getHappy() {return happy;}
    public static void setHappy(double h) {happy = h;}
    
}
