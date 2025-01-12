package head_first_design_patterns;

interface  FlyBehaviour{
    void fly();
} 

class FlyWithNoWings implements FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("Flies but with no wings");    
    }
    
}

class FlyWithWings implements  FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("Flies with wings");
    }
        
}

class FlyWithRocketFuel implements  FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Flies with rocket exhaust");
    }
        


}

interface  QuackBehaviour{
    void quack();
};

class Quack implements QuackBehaviour{

    @Override
    public void quack() {
        System.out.println("This does quack");
    }

};

class Squeak implements  QuackBehaviour{

    @Override
    public void quack() {
        System.out.println("This does squeak ");
    }

};

class MuteQuack implements QuackBehaviour{

    @Override
    public void quack() {
        System.out.println("This does Mute Quack");
    }

    
};


 abstract class Duck{
   private QuackBehaviour quackBehaviour;
   private FlyBehaviour flyBehaviour;

    public Duck(FlyBehaviour flyBehaviour, QuackBehaviour quackBehaviour) {
        this.flyBehaviour = flyBehaviour;
        this.quackBehaviour = quackBehaviour;
    }

    public void performQuack(){
        quackBehaviour.quack();
    }

    public void fly(){
        flyBehaviour.fly();
    }

    public abstract  void display();

    public  void swim(){
        System.out.println("All ducks float even decoys");
    };

    
};


class MallardDuck extends Duck{

    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I am a Mallard Duck");
    }

    

    
}

public class duckSimU {
    public static void main(String[] args) {

        Duck mallard= new MallardDuck();
        mallard.fly();
        mallard.performQuack();
        mallard.display();
        
    }
}
