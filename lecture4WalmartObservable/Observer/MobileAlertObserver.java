package lecture4WalmartObservable.Observer;

import lecture4WalmartObservable.Subject.StockObservable;

public class MobileAlertObserver implements Observer {
    String name;
    String mobileNum;
    StockObservable stockObservable;
     
    

    public MobileAlertObserver(String name,String mobileNum,StockObservable stockObservable) {
        this.name=name;
        this.mobileNum=mobileNum;
        this.stockObservable=stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + " (" + mobileNum + "), we have " + stockObservable.getStockCount() + " iPhones available");
    }


}
