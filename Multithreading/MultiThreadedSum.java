
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MultiThreadedSum {

    public static void main(String[] args) {
        Random random = new Random();
        int arr[]= new int[100000];
        for(int i=0;i<100000;i++){
            arr[i]=random.nextInt(10)+1;
        }

        try(ForkJoinPool forkJoinPool= new ForkJoinPool(Runtime.getRuntime().availableProcessors())){
            WorkSplitter task= new WorkSplitter(0, 100000, arr);

            long startTime = System.currentTimeMillis();
            Integer val = forkJoinPool.invoke(task);
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
            System.out.println("Val"+val);

        }

    }


}


class WorkSplitter extends   RecursiveTask<Integer>{

    int low,high;
    int[] arr;

    

    public WorkSplitter(int low, int high, int[] arr) {
        this.low = low;
        this.high = high;
        this.arr = arr;
       
    }

    @Override
    protected Integer compute() {
       int size=low-high;
       if(size>10000){
        WorkSplitter t1= new WorkSplitter(low, size/2, arr);
        WorkSplitter t2= new WorkSplitter( size/2,high, arr);
        t1.fork();
        t2.fork();

        return t1.join()+t2.join();

       }
       else{
        return sumValue();
       }    

        

    }

    private int sumValue(){
        Integer sum=0;

        for(int i=low;i<high;i++){
            sum += arr[i];
        }
        return sum;
    }

}


