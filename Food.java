import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class Food {
    
    /*
    Attributes
    */

    /** siza of the food */
    int size;
    /** amount of points the food is worth */
    int point;
    /** the toppings on the food */
    HashMap<Topping, Boolean> topping = new HashMap<>();

    /*
    Constructor
    */

    public Food(int size){
        this.size = size;
        this.point = 10;
        for (Entry<Topping, Boolean> entry : Topping.getList().entrySet()) {
 
            // using put method to copy one Map to Other
            topping.put(entry.getKey(),entry.getValue());
        }
    }

    //randomly generate a food
    public Food(){
        this.size = (int) Math.floor(Math.random()*(3)+1);
        this.point = 10;
        for (Entry<Topping, Boolean> entry : Topping.getList().entrySet()) {
 
            // using put method to copy one Map to Other
            topping.put(entry.getKey(),entry.getValue());
        }
        int i = 0;
        while(i < Math.floor(Math.random()*(5)+1)){
            Topping randomTopping = this.randomTopping();
            if(!topping.get(randomTopping) && randomTopping.getLock() == false){
                topping.replace(randomTopping, false, true);
                this.point =+ randomTopping.getPoint();
                i++;
            }
        }
        
        
    }

    /*
    Accessors
    */

    /**
    gets the point of the food
    @return the point of the food
    */
    public int getPoint()
    {
        return this.point;
    }
    /**
    gets the size of the food
    @return the size of the food
    */
    public int getSize()
    {
        return this.size;
    }
    /**
    gets the toppings on the food
    @return the toppings on the food
    */
    public HashMap<Topping, Boolean> getToppings()
    {
        return this.topping;
    }
    
    /*
    Mutators
    */

    /**
    changes the point of the food
    @param newPoint the new amount of points the food is worth
    */
    public void setPoint(int newPoint)
    {
        this.point = newPoint;
    }
    

    /*
    Methods
    */

    /**
    adds a topping on to the food
    @param add the topping to be added to the food
    */
    public void add(Topping add)
    {
        if(!topping.get(add)){//topping is not added
            topping.replace(add, true);
            this.point = point + add.getPoint();
        }
    }
    /**
    outputs a random topping
    @return a random topping
    */
    public Topping randomTopping()
    {
        Set<Topping> keySet = topping.keySet();
        List<Topping> keyList = new ArrayList<>(keySet);
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        Topping randomKey = keyList.get(randIdx);
        return randomKey;
    }
    /**
    prints the toppings the food has
    */
    public void printToppings() {
        if(this.topping.containsValue(true)){
            Set set = this.topping.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                if((boolean) mentry.getValue()){
                    System.out.println(((Topping) mentry.getKey()).getName());
                }
            }
        }
    }
    /**
    checks if two foods are the same
    @param compare the food to compare with
    */
    public Boolean compare(Food compare) {
        Boolean same = false;
        if(this.size == compare.getSize()){
            if(this.topping.equals(compare.getToppings())){
                same = true;
            }
        }
        return same;
    }
}
