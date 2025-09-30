
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SyncQueue {
    public static final int QUEUE_CAPACITY=10;
    public static BlockingQueue<Integer> q= new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    public static void main(String[] args) {
        
        Thread producer= new Thread(()->{

            for(int i=1;i<=20;i++){
                
                try {
                    q.put(i);
                    System.out.println("Adding element ...");
                } catch (InterruptedException ex) {
                }
            }
        });

        Thread consumer1 = new Thread(()->{
            
            while(true){
                try {
                    int val=q.take();
                    task("Consumer 1",val);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }


        });

        Thread consumer2 = new Thread(()->{
            
            while(true){
                try {
                    int val=q.take();
                    task("Consumer 2",val);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }


        });

        producer.start();
        consumer1.start();
        consumer2.start();

    }


    public static void task(String consumerName,int val) throws  InterruptedException{
        System.out.println(consumerName+" consumed the value "+ val+" and is working on it...");
        Thread.sleep(1000);
        System.out.println("Task completed by "+ consumerName);
    } 

}


