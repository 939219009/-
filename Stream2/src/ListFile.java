import org.junit.Test;

import java.io.File;

public class ListFile {
    @Test
    public void Test(){
        String path="C://";
        List(path);
    }
    public void List(String path){

        File file=new File(path);

        File[] fs=file.listFiles();

       for(File f :fs){
           if(f.isDirectory()){
               List(f.getPath());
           }
           System.out.println(f.getPath());
       }
    }
}
