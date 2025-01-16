package lecture4WalmartObservable;

import lecture4WalmartObservable.Observer.EmailAlertObserver;
import lecture4WalmartObservable.Observer.MobileAlertObserver;
import lecture4WalmartObservable.Observer.Observer;
import lecture4WalmartObservable.Subject.IphoneObservable;
import lecture4WalmartObservable.Subject.StockObservable;

public class Store {

    public static void main(String[] args) {
        
        StockObservable iphoneObservable =new IphoneObservable(5);
        Observer emailAlertObserver=new EmailAlertObserver("Shreshth", "Shreshth.pal@gmail.com",iphoneObservable );
        Observer mobileAlertObserver=new MobileAlertObserver("Shreshth", "9592902106",iphoneObservable );
        iphoneObservable.add(emailAlertObserver);
        iphoneObservable.add(mobileAlertObserver);
        iphoneObservable.setStockCount(9);
    }

}
