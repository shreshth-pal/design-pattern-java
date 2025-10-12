import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphorePractice {

    public static void main(String[] args) {
        ExecutorService ex= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            ex.execute(new Thread(()->{
                ScraperService.Instance.coumpute();
            }));
        }
    }
}



enum ScraperService{
    Instance;
    Semaphore s= new Semaphore(3);


    public void coumpute(){
       try {
           s.acquire();
            scaraping();
       } catch (Exception e) {
       } finally {
            s.release();
        }

    }

    private void scaraping() throws  InterruptedException{
        System.out.println("Scraping Started ....." +s.availablePermits());
        Thread.sleep(2000);
    }

}