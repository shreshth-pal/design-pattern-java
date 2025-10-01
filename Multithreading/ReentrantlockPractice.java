import java.util.concurrent.locks.ReentrantLock;
//Practiced Multi




class ReLock{
    private int sharedData=0;
    ReentrantLock lc= new ReentrantLock();

    public ReLock() {
    }

    public void methodA() throws InterruptedException {
        lc.lock();
        try {
            //critical section
            sharedData++;
            System.out.println("Shared Data value increased:"+sharedData);
            Thread.sleep(1000);
            methodB();
            
        }

         finally {
            lc.unlock();
        }

    }

    private void methodB() throws InterruptedException{
        lc.lock();
        try {
            //critical section
            sharedData--;
            Thread.sleep(1000);
            System.out.println("Shared Data value decreased:"+sharedData);
            
        } finally {
            lc.unlock();
        }

    }

}



public class ReentrantlockPractice {


    static ReentrantLock lc= new ReentrantLock();
    public static void main(String[] args) {
        
        Thread t1 = new Thread(()->{try {
            method();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }},"T1");
        Thread t2 = new Thread(()->{try {
            method();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }},"T2");

        t1.start();
        t2.start();

        
    }
    private static void method() throws InterruptedException{
        
        try {
            while(true){
                System.out.println(" Lock Not Found What to do man...."+ Thread.currentThread().getName());
                if(lc.tryLock()){
                    System.out.println("Lock Found going to sleep..."+ Thread.currentThread().getName());
                    Thread.sleep(5000);
                    break;
                }
                Thread.sleep(200);
            }
            
            
        } finally {
        if(lc.isLocked()){
            lc.unlock();
        }
            
        }
    }



    private static void reEnterentPractice(){
        ReLock re= new ReLock();
        for(int i=0;i<5;i++){
            new Thread(()->{try {
                re.methodA();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}).start();
        }
    }

}