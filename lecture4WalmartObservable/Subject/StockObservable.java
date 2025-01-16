package lecture4WalmartObservable.Subject;

import lecture4WalmartObservable.Observer.Observer;

public interface StockObservable{

    public void add(Observer o);

    public void remove(Observer o);

    public void notifySubscribers();

    public void setStockCount(int newStockAdded);
    
    public int getStockCount();

}
