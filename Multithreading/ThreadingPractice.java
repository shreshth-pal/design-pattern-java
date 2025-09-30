
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingPractice {
    public static void main(String[] args) {
        //    ThreadPoolPractice();
        //    FixedThreadPoolPractice();
        //    CachedThreadPoolPractice();  
    }


    static void CachedThreadPoolPractice(){
        try(ExecutorService s= Executors.newCachedThreadPool()){
            for(int i=0;i<1000;i++){
                s.execute(new Task(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void ThreadPoolPractice(){
        try{
            ExecutorService service= Executors.newSingleThreadExecutor();
            for(int i=0;i<5;i++){
                service.execute(new Task(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void FixedThreadPoolPractice(){
        try(ExecutorService s=Executors.newFixedThreadPool(3)){
            
            for(int i=0;i<10;i++){
                s.execute(new Task(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




class Task implements  Runnable{

    int id;
    

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with Id ="+ id +"Is Being executed by "+ Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
    
}




