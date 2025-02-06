package headFirstDesignPattern;

public class SingletonPattern {

    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton.getInstance();
        //come back after learning threads;
    }
    
    
}



class Singleton{

   private static Singleton inst;

    private Singleton(){
        System.out.println("once please");
    }

    public static Singleton getInstance(){
        if(inst==null){
            inst=new Singleton();
        }
        return inst;
    }
}


class SyncronizedSingleton{
    private static SyncronizedSingleton inst;

    private SyncronizedSingleton(){
    }

    public static synchronized SyncronizedSingleton getInstance(){
        if(inst==null){
            inst=new SyncronizedSingleton();
        }
        return inst;
    }
}

class EagerlySingleton{
    private static EagerlySingleton inst=new EagerlySingleton();

    private EagerlySingleton(){
    }

    public static EagerlySingleton getInstance(){
        return inst;
    }
}

class DoubleCheckedLockingSingleton{
    private static volatile DoubleCheckedLockingSingleton inst;

    private DoubleCheckedLockingSingleton(){
    }

    public static DoubleCheckedLockingSingleton getInstance(){
        if(inst==null){
            synchronized (DoubleCheckedLockingSingleton.class) {
                if(inst==null){
                    inst= new DoubleCheckedLockingSingleton();
                }    
            }
            
        }
        return inst;
    }
}