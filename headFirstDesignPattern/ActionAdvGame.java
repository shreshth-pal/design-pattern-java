package headFirstDesignPattern;

abstract  class Character {
    WeaponBehaviour weapon;

    public Character(WeaponBehaviour weapon) {
        this.weapon=weapon;
    }

    public  void fight(){
        weapon.useWeapon();
    };

    public void setWeapon(WeaponBehaviour weapon) {
        this.weapon = weapon;
    }

    
}


class Queen extends Character{

    public Queen() {
        super(new KnifeBehaviour());
    }

}

class Troll extends Character{
    
    public Troll() {
        super(new BowAndArrowBehaviour());
    }
    
}

class King extends Character{
    
    public King() {
        super(new AxeBehaviour());
    }
    
}

class Knight extends Character{
    
    public Knight() {
        super(new SwordBehaviour());
    }
    
}


interface  WeaponBehaviour{
    void useWeapon();
}

class KnifeBehaviour implements  WeaponBehaviour{

    @Override
    public void useWeapon() {
        System.out.println("I will cut you");
    }
}


class AxeBehaviour implements  WeaponBehaviour{

    @Override
    public void useWeapon() {
        System.out.println("I will chop you down");
    }
}
class SwordBehaviour implements  WeaponBehaviour{

    @Override
    public void useWeapon() {
        System.out.println("I will skin you");
    }
}class BowAndArrowBehaviour implements  WeaponBehaviour{

    @Override
    public void useWeapon() {
        System.out.println("I will pierce you");
    }
}

public class ActionAdvGame {
    public static void main(String[] args) {
        Character king=new King();
        king.fight();
        king.setWeapon(new BowAndArrowBehaviour());
        king.fight();
    }
}

