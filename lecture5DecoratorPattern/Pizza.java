package lecture5DecoratorPattern;

 public class  Pizza {
    public static void main(String[] args) {
        BasePizza b=  new Capsicum(new Cheese(new MargeritaPizza()));
        System.out.println("The cost of the pizza is "+b.cost());
    }
}

interface  BasePizza{
    int cost();

}

class PicantePizza implements BasePizza{

    @Override
    public int cost() {
        return 990;
    }
}

class MargeritaPizza implements  BasePizza{

    @Override
    public int cost(){
        return 690;
    }
}

class FarmhousePizza implements BasePizza{

    @Override
    public int cost(){
        return 850;
    }
}


class Toppings implements BasePizza{

    BasePizza b;
    int cost;

    public Toppings(BasePizza b,int cost) {
        this.b=b;
        this.cost=cost;
    }

    @Override
    public int cost() {
        return cost+b.cost();
    }
    
}

class Capsicum extends Toppings{
    
    public Capsicum(BasePizza b) {
        super(b, 10);
    }
    
}

class Olive extends Toppings{
    
    public Olive(BasePizza b) {
        super(b, 20);
    }
    
}

class Mushroom extends Toppings{
    
    public Mushroom(BasePizza b) {
        super(b, 15);
    }
    
}

class Cheese extends Toppings{
    public Cheese(BasePizza b) {
        super(b, 35);
    }
    
}
