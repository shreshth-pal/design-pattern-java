public class ImplThread {

    public static int counter;

    public static synchronized  void increment(){
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main: "+Thread.currentThread().getPriority());
        // Thread t1= new Thread(new Thread1());
        // Thread t2= new Thread(new Thread2());
        
        Thread cnt1= new Thread(()->{
            for(int i=0;i<10000;i++){
                increment();    
            }
        });

        Thread cnt2= new Thread(()->{
            for(int i=0;i<10000;i++){
                increment();    
            }
        });

        cnt1.start();
        cnt2.start();
        cnt1.join();
        cnt2.join();
        System.out.println("Counter="+counter);
        System.out.println("Something good is about to happen to me");
    }
}


class Thread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
         System.out.println("Thread 1:"+i);   
        }
    }


}


class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
         System.out.println("Thread 2:"+i);   
        }
    }
}