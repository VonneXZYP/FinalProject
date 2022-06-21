import java.util.HashMap;

public class Topping{

     /*
    Attributes
    */

    /** the name of the topping */
    String name;
    /** amount of points the topping is worth */
    int point;
    /** amount of points needed to unlock the topping */
    int cost;
    /** whether the topping is unlocked or not */
    boolean lock;
    
    //list of all the toppings
    static HashMap<Topping, Boolean> baseList = new HashMap<>();

    /*
    Constructor
    */

    public Topping(String name, int point) {
        
        this.name = name;
        if(point > 0){
            this.point = point;
        }
        this.lock = false;
        this.cost = 0;
        baseList.put(this, false);
    }

    public Topping(String name, int point, int cost) {
        
        this.name = name;
        if(point > 0){
            this.point = point;
        }
        this.lock = true;
        this.cost = cost;
        baseList.put(this, false);
    }


    /*
    Accessors
    */

    /**
    gets the name of the topping
    @return the name of the topping
    */
    public String getName() {
        return this.name;
    }
    /**
    gets the point of the topping
    @return the point of the topping
    */
    public int getPoint() {
        return this.point;
    }
    /**
    gets the base list of toppings
    @return the base list of toppings
    */
    public static HashMap<Topping, Boolean> getList() {
        
        return baseList;
    }
    /**
    gets the cost of the topping
    @return the cost of the topping
    */
    public int getCost() {
        return this.cost;
    }
    /**
    gets the cost of the topping
    @return the cost of the topping
    */
    public Boolean getLock() {
        return this.lock;
    }


    /*
    Mutators
    */

    /**
    change the cost of the topping
    @param newCost the new cost of the topping
    */
    public void setCost(int newCost) {
        this.cost = newCost;
    }
    /**
    change the lock status of the topping
    @param newLock the new lock status of the topping
    */
    public void setLock(Boolean newLock) {
        this.lock = newLock;
    }

    
}
