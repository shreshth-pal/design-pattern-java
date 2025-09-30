
import java.util.*;

public class PubSub {
    
    

    public static void main(String[] args) {
        PublisherSubscriber worker= new PublisherSubscriber(10);

        Thread producer = new Thread(()->{
            try {
                worker.produce();
            } catch (InterruptedException ex) {
            }
        });
        Thread consumer = new Thread(()->{
             try {
                worker.consume();
            } catch (InterruptedException ex) {
            }
        });

        producer.start();
        consumer.start();

    }


}

class PublisherSubscriber{
    public static Object lock= new Object();
    List<Integer> container;
    int capacity;
    int sequence;
    public PublisherSubscriber(int cap) {
        container = new ArrayList<>();
        capacity=cap;
        sequence=0;
        
    }


    void produce() throws InterruptedException{
        synchronized (lock) {
            while (true) {
                if(container.size()==capacity){
                    System.out.println("Container full");
                    lock.wait();
                } 
                else{
                    System.out.println("Adding to container");
                    container.add(sequence++);
                    lock.notify();
                }
                Thread.sleep(500);
                }
                   
            }
            
        }
    

    void consume() throws InterruptedException{
        synchronized (lock) {
            while (true) { 
                if(container.isEmpty()){
                    System.out.println("Removing from Container");
                    lock.wait();
                }
                else{
                    System.out.println("Removing from Container");
                    System.out.println("Removing: "+container.removeFirst());
                    lock.notify();
                }
                Thread.sleep(500);
                    
    
                   
            }
            
        }
    }

    
    
}


class Publisher{



}

class Consumer{


}