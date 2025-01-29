package headFirstDesignPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoraterExtended {

    public static void main(String[] args) {
            int c;

            try {
                InputStream in=new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\shres\\OneDrive\\Desktop\\java\\design-pattern-java\\headFirstDesignPattern\\test.txt")));
                while((c=in.read())>=0){
                    System.out.print((char)c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

}


class LowerCaseInputStream extends FilterInputStream{

    public LowerCaseInputStream(InputStream in){
        super(in);
    }
    @Override
    public int read() throws IOException{
        int c=in.read();
        return (c == -1?c:java.lang.Character.toLowerCase((char)c));
    }

    @Override
    public int read(byte[] b,int offset,int len) throws IOException{
        int result=in.read(b,offset,len);
        for(int i=offset;i<len;i++){
            b[i]=(byte)java.lang.Character.toLowerCase(((char)b[i]));
        }
        return result;
    }
}

