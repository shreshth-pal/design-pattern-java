package headFirstDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay= new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay=new ForecastDisplay(weatherData);

        

        weatherData.setMeasurements(45, 50, 30.0f);
        weatherData.setMeasurements(40,57, 28.9f);
    }
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

   private List<Observer>observers=new ArrayList();
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

       for(Observer o:observers){
            o.update();
       }
        
       
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temp=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObservers();

    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
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
        temperature=weatherData.getTemp();
        humidity=weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: "+ temperature + "degree Celcius and "+ humidity+"% humidity" );
    }
}

class ForecastDisplay implements Observer,DisplayElement{
    WeatherData weatherData;
    private float currentPressure=29.92f;
    private float lastPressure;

    public ForecastDisplay(WeatherData o){
        weatherData=o;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        lastPressure=currentPressure;
        currentPressure=weatherData.getPressure();
        display();
    }

    @Override
    public void display() {
        System.out.println("To be implemented");
    }

    
}