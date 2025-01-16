package lecture4WalmartObservable.Observer;

import lecture4WalmartObservable.Subject.StockObservable;

public class EmailAlertObserver implements Observer {

    String name;
    String emailId;
    StockObservable stockObservable;
     
    

    public EmailAlertObserver(String name,String emailId,StockObservable stockObservable) {
        this.name=name;
        this.emailId=emailId;
        this.stockObservable=stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + " (" + emailId + "), we have " + stockObservable.getStockCount() + " iPhones available");
    }

}
