package lecture4WalmartObservable.Subject;

import java.util.ArrayList;
import lecture4WalmartObservable.Observer.Observer;

public class IphoneObservable implements StockObservable {

    int count;
    ArrayList<Observer>subscribers;   
    

    public IphoneObservable(int count) {
        this.count=count;
        subscribers=new ArrayList<>();
    }

    @Override
    public void add(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void remove(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifySubscribers() {
        for(Observer o:subscribers){
            o.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        count+=newStockAdded;
        notifySubscribers();
    }

    @Override
    public int getStockCount() {
        return count;
        
    }

}