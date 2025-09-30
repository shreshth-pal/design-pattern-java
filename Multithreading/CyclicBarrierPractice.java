
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierPractice {
    public static final int NUM_TOURIST=5;
    public static final int STAGES=3;
    public static CyclicBarrier cb= new CyclicBarrier(NUM_TOURIST,()->{
        System.out.println("Tour Guides Begans to speak.......");
    });
    
    public static void main(String[] args) { 
        for(int i=1;i<=NUM_TOURIST;i++){
            new Thread(new Tourist(i, cb)).start();
        }
        
    }
}

class Tourist implements  Runnable{
    int id;
    CyclicBarrier cb;
    public Tourist(int id,CyclicBarrier cb) {
        this.id = id;
        this.cb=cb;
    }

    @Override
    public void run() {
        for(int i=0;i<CyclicBarrierPractice.STAGES;i++){
            System.out.println("Tourist No"+this.id +" is at Stage"+(i+1));
            try {
                Thread.sleep(1000);
                cb.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
            }
            

        }

    }
    
    


}


