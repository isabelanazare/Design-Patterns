package Model.coffees;

public class Ingredient {
    String name;
    int quantity;

    public Ingredient(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

  @Override
    public String toString(){
        return "name: " + this.name + " quantity: " + this.quantity;
  }
}
