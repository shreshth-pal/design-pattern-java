package headFirstDesignPattern;

import java.util.List;

public class WeatherStation {

}



interface Subject{
 
   void registerObserver(Observer o);

   void removeObserver(Observer o);

   void notifyObservers();


}

interface Observer{
    void update();
}

interface DisplayElement{
    void display();
}



class WeatherData implements Subject{

   private List<Observer>observers;
   private float temp;
   private float pressure;
   private float humidity;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
       
    }

    @Override
    public void removeObserver(Observer o) {
       if( observers.remove(o));
            System.err.println("You have been removed from the list");
        
       
    }

    @Override
    public void notifyObservers() {

        observers.forEach(t->t.update());
        
       
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temp=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObservers();

    }


    
}

class CurrentConditionsDisplay implements Observer,DisplayElement{

    private float temperature;
    private float  humidity;
    private WeatherData weatherData;


    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}