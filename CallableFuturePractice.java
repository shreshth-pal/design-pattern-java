import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuturePractice {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // countDownLatch();
        syncCollection();
    }

    static void syncCollection(){
        List<Integer> v= Collections.synchronizedList(new ArrayList<>());
        Thread t1= new Thread(()->{
            for(int i=0;i<1000;i++){
                v.add(i);
            }
        });

        Thread t2= new Thread(()->{
            for(int i=0;i<1000;i++){
                v.add(i);
            }
        });
        try(ExecutorService s= Executors.newCachedThreadPool()) {
            s.execute(t2);
            s.execute(t1);
        } catch (Exception e) {
        }

        System.out.println(v.size());

        
    }

    static void countDownLatch() throws InterruptedException{
        try( ExecutorService s= Executors.newFixedThreadPool(2)){
            CountDownLatch cl= new CountDownLatch(3);
            Future<Integer> r0=s.submit(new Task(5,"Insan",cl));
            Future<Integer> r2=s.submit(new Task(6,"Human",cl));
            Future<Integer> r1=s.submit(new Task(7,"Hooman",cl));
            cl.await();
        }
    }
}


class Task implements  Callable<Integer>{

    int id;
    String name;
    CountDownLatch cl;
    public Task(int id, String name,CountDownLatch cl) {
        this.id = id;
        this.name = name;
        this.cl=cl;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println("Name: "+ name);
        cl.countDown();
        return id;
    }
    
}
