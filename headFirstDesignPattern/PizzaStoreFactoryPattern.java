package headFirstDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class PizzaStoreFactoryPattern {

    public static void main(String[] args) {
        PizzaStore hawaiiPizzaStore= new HawaiiStylePizzaStore();
   
    
    PizzaStore nyPizzaStore=new NYstylePizzaStore();
    
    PizzaStore chPizzaStore=new ChicagoStylePizzaStore();

    hawaiiPizzaStore.order("Pineapple");
    nyPizzaStore.order("Pepperoni");
    chPizzaStore.order("Cheese");
    }
    
    
    
   

    // pizza=nyPizzaStore.order("Cheese");
    
  
}


abstract class PizzaStore{

    abstract Pizza createPizza(String type);

    Pizza order(String type){

         Pizza pizza=createPizza(type);
         pizza.prepare();
         pizza.bake();
         pizza.cut();
         pizza.box();

         return pizza;

    }
}


class NYstylePizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if (type.equals("Cheese")){
            return new NYStyleCheesePizza();
        }
        else if(type.equals("Pepperoni")){
            return new NyStylePepperoniPizza();
        }
        else{
            return null;
        }
    }
    
}


class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("Cheese")){
            return new ChicagoStyleCheesePizza();
        }
        else{
            return null;
        }
    }
}

class HawaiiStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
      
        if (type.equals("Pineapple")){
            return new HawaiiStylePineapplePizza();
        }
        else{
            return null;
        }
    }
}






abstract  class Pizza{
    String name;
    String dough;
    String sauce;
    List<String> toppings=new ArrayList<String>();



    void prepare(){
        System.out.println("Preparing "+ name);
        System.out.println("Tossing dough ...");
        System.out.println("Adding sauce.. ");
        System.out.println("Adding toppings:");
        for(String topping:toppings){
            System.out.println(topping);
        }
        
    }
    void cut(){
        System.out.println("Cutiing pizza into slices");
    }
     void box(){
        System.out.println("Placing pizza in official PizzaStore box");
     }
    void bake(){
        System.out.println("Baking for 25 min in 250F oven..");
    };

}

class ChicagoStyleCheesePizza extends Pizza{

    public ChicagoStyleCheesePizza() {
        name="Chicago Style Cheese Pizza";
        dough="Deep Dish Dought";
        toppings.add("Marinara Sauce");
        toppings.add("American Cheese");
    }

    
    
}




class NyStylePepperoniPizza extends Pizza{

    public NyStylePepperoniPizza() {
        name="NY style Pepperoni Pizza";
        dough="Thin Crust";
        toppings.add("Pepperoni");
        toppings.add("Cheese");
    }
    
    
    
}

class NYStyleCheesePizza extends Pizza{

    public NYStyleCheesePizza() {
        name="NY style Cheese Pizza";
        dough="Thin Crust";
        toppings.add("Margerita Cheese");
    }
    
}

class HawaiiStylePineapplePizza extends  Pizza{

    public HawaiiStylePineapplePizza() {
        name="Hawaii Style Pizza";
        dough="Thin Crust";
        toppings.add("Pineapple");
        toppings.add("Truffles");
    }

    

}