// package headFirstDesignPattern;

// public class StarBuzzCoffeeShop {
//     public static void main(String[] args) {
        
//         Beverage darkRoast= new Soy(new Whip(new DarkRoast()));
//         System.out.println("Your order " +darkRoast.getDescription() +" costs "+darkRoast.cost());
//         Beverage decaf= new Whip(new Soy(new Mocha(new Decaf())));

//         System.out.println("Your order " +decaf.getDescription() +" costs "+decaf.cost());

        
//     }
// }

// abstract class Beverage{
//     String description="Unknown Beverage";

//     int milkCost=0;
//     int soyCost=0;
//     int mochaCost=0;
//     int whipCost=0;
    

//     public double cost() {
//         double condimentCost = 0.0;
//         if (hasMilk()) {
//             condimentCost += milkCost;
//         }
//         if (hasSoy()) {
//             condimentCost += soyCost;
//         }
//         if (hasMocha()) {
//             condimentCost += mochaCost;
//         }
//         if (hasWhip()) {
//             condimentCost += whipCost;
//         }
//         return condimentCost;
//     }

//         public int getMilkCost() {
//             return milkCost;
//         }

//         public void setMilkCost(int milkCost) {
//             this.milkCost = milkCost;
//         }

//         public int getSoyCost() {
//             return soyCost;
//         }

//         public void setSoyCost(int soyCost) {
//             this.soyCost = soyCost;
//         }

//         public int getMochaCost() {
//             return mochaCost;
//         }

//         public void setMochaCost(int mochaCost) {
//             this.mochaCost = mochaCost;
//         }

//         public int getWhipCost() {
//             return whipCost;
//         }

//         public void setWhipCost(int whipCost) {
//             this.whipCost = whipCost;
//         }
//  }

//     public Size getSize() {
//         return size;
//     }

//     public void setSize(Size size) {
//         this.size = size;
//     }
//     public enum Size { TALL, GRANDE, VENTI };
//     Size size = Size.TALL;

//     public String getDescription(){
//         return description;
//     }


//     // public abstract  double cost();

// }

// abstract  class Condiments extends  Beverage{
//     Beverage b;
//     @Override
//     public abstract String getDescription();
    
// }

// class Espresso extends Beverage{

//     public Espresso() {
//         description="Espresso";
//     }

//     @Override
//     public double cost() {
//         return 1.99;
//     }
    
// }

// class HouseBlend extends Beverage{
//     public HouseBlend() {
//         description="House Blend";
//     }

//     @Override
//     public double cost() {
//         return 0.89;
//     }
// }

// class DarkRoast extends Beverage{
//     public DarkRoast() {
//         description="Dark Roast";
//     }

//     @Override
//     public double cost() {
//         return 0.99;
//     }
// }

// class Decaf extends Beverage{

//     public Decaf() {
//         description="Decaf";
//     }

//     @Override
//     public double cost(){
//         return 1.05;
//     }
    
// }

// class Mocha extends Condiments{

    

//     public Mocha(Beverage beverage) {
//         b=beverage;
//     }   

//     @Override
//     public String getDescription() {
//         return b.getDescription()+", Mocha";
//     }

//     @Override
//     public double cost() {
//         return b.cost()+0.2;   
//     }
    
// }

// class Soy extends Condiments{

//     public Soy(Beverage beverage){
//         b=beverage;
//     }

//     @Override
//     public String getDescription() {
//         return b.getDescription()+ ", Soy";
//     }

//     @Override
//     public double cost() {
//         return b.cost()+0.1;
//     }
    
// }

// class Whip extends Condiments{

//     public Whip(Beverage beverage){
//         b=beverage;
//     }

//     @Override
//     public String getDescription() {
//         return b.getDescription()+", Whip";
//     }

//     @Override
//     public double cost() {
//         return b.cost()+0.15;
//     }
    
// }



