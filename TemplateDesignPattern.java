public class TemplateDesignPattern {

    public static void main(String[] args) {
        CaffieneBeverage coffee= new Coffee();
        CaffieneBeverage tea=new Tea();
        coffee.prepare();
        tea.prepare();
    }
    
}

abstract  class  CaffieneBeverage{

    void prepare(){
        boilWater();
        brew();
        //hook
        if(customerWantsCondiments())
            addCondiments();
        pourIntoCup();

    }

    boolean customerWantsCondiments(){
        return true;
    }

    void boilWater(){
        System.out.println("Boiling Water");
    }

    void pourIntoCup(){
        System.out.println("Pouring Beverage into the cup ");
    }

    abstract void brew();

    abstract  void addCondiments();



    
    

}


class Coffee extends  CaffieneBeverage{


    @Override
    void brew() {
        System.out.println("Adding coffee to brew");
    }

    @Override
    void addCondiments() {
        System.out.println("adding Creamer");
    }


}


class Tea extends  CaffieneBeverage{
     

    

    @Override
    void brew() {
        System.out.println("Adding tea leaves and simmering");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding cardamon and milk");
    }

    @Override
    public boolean  customerWantsCondiments(){
        return false;
    }

}
