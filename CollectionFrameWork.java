import java.util.*;


class Student implements Comparable<Student>{

    private Integer age;
    public Integer marks;
    public String name;

    
        

    public Student(Integer age, Integer marks, String name) {
        this.age = age;
        this.marks = marks;
        this.name = name;
        
    }
    @Override
    public String toString() {
    return "Student{" +
           "age=" + age +
           ", marks=" + marks +
           ", name='" + name + '\'' +
           '}';
    }

    @Override
    public int compareTo(Student that) {
        return this.age> that.age?1:-1;  
    }
    
}

public class CollectionFrameWork {

 
    public static void main(String[] args) {
        compPractice();
        listPractice();
        setPractice();
        mapPractice();    
        
    }
    public static void compPractice(){
        List<Student> std= new ArrayList<>();
        std.add(new Student(19, 99, "Shres"));
        std.add(new Student(25, 90, "Sh"));
        std.add(new Student(20, 99, "Sr"));
        std.add(new Student(18, 99, "Shhhres"));

        Collections.sort(std);

        System.out.println(std);

    }


    public static void listPractice(){
        List<Integer> arrayList =new ArrayList<>();
        List<Integer> linkdList =new LinkedList<>();
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(1);
      
            
        linkdList.addAll(arrayList);
        System.out.println(arrayList.equals(linkdList));
        arrayList.set(1, 8);
      
        System.out.println(linkdList);
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer a,Integer b){
                if(a>b){
                    return 1;
                }
                else if(a.equals(b)){
                    return 0;
                }
                else{
                    return -1;
                }
                
            }
        };
        Collections.sort(arrayList,cmp);
        System.out.println(arrayList);
    }

    public static void setPractice(){
        Set<Integer> h = new HashSet<>();
        Set<Integer> t = new TreeSet<>();
        Set<Integer> lh = new LinkedHashSet<>();
        
        h.add(0); h.add(-1); h.add(3);h.add(1);
        h.add(100); h.add(50); h.add(-20);
        t.add(1); t.add(0); t.add(3);t.add(1);
        lh.add(1); lh.add(0); lh.add(3);lh.add(1);
        
        System.out.println(h);
        System.out.println(t);
        System.out.println(lh);


        Iterator <Integer> x= h.iterator();

        while(x.hasNext()){
            System.out.println(x.next());
        }
    
    
    }
    
    public static void mapPractice(){
        Map<String,Integer> mp= new HashMap<>();

        mp.put("Maths",100);
        mp.put("Physics",100);
        mp.put("Englis",99);
        mp.put("CompSci",100);
        Map<String,Integer> tree = new TreeMap<>(mp);
        
        for (Map.Entry<String, Integer> entry : tree.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println(mp);


    }

}
