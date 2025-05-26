
import java.util.ArrayList;


interface FileSystem{
    public void ls();
}


class Directory implements  FileSystem{
    private ArrayList<FileSystem> elements= new ArrayList<>();
    private final String name;

    

    public Directory(String name  ) {
        this.name=name;
    }

    @Override
    public void ls() {
       System.out.println("directory :"+name);
       for(FileSystem element : elements){
        element.ls();
    }
    }
    public void addElement(FileSystem f){
        elements.add(f);
    }
    

}

class File implements  FileSystem{
    private final String name;
    private final String extension;

    

    public File(String name, String extension) {
        this.name = name;
        this.extension = extension;
      
    }
    

    @Override
    public void ls() {
       System.out.println("filename :"+name+"."+extension);
    }

}


class  CompositeDesignPattern{
    public static void main(String[] args) {
        Directory fs=new Directory("root");
        Directory ds=new Directory("shres");
        ds.addElement(new File("word", "docx"));

        fs.addElement(new File("application", "exe"));
        fs.addElement(new File("access", "xls"));
        fs.addElement(ds);
        
        fs.ls();
    }
}