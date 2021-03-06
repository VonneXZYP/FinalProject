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
    /** the topping's sprit's tileNum */
    int tileNum;
    
    //list of all the toppings
    static HashMap<Topping, Boolean> baseList = new HashMap<>();

    /*
    Constructor
    */

    public Topping(String name, int point, int tileNum) {
        
        this.name = name;
        if(point > 0){
            this.point = point;
        }
        this.lock = false;
        this.cost = 0;
        this.tileNum = tileNum;
        baseList.put(this, false);
    }

    public Topping(String name, int point, int cost, int tileNum) {
        
        this.name = name;
        if(point > 0){
            this.point = point;
        }
        this.lock = true;
        this.cost = cost;
        this.tileNum = tileNum;
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
    gets if the topping if locked or not
    @return whether the topping is locked or not
    */
    public Boolean getLock() {
        return this.lock;
    }
    /**
    gets the tile number of the topping
    @return the tile number of the topping
    */
    public int getTileNum() {
        return this.tileNum;
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
