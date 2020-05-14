package Repository;

import Model.coffees.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeRepository {
    private List<Coffee> coffees;

    public CoffeeRepository(){
        this.coffees = new ArrayList<>();
    }

    public void add(Coffee c){
        this.coffees.add(c);
    }

    public Coffee getByTitle(String title){
        for(Coffee c: coffees){
            if(c.getTitle().equals(title)){
                return c;
            }
        }
        return null;
    }
    public List<Coffee> getCoffees(){ return this.coffees;}

}
