import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Random {

    @Test
    public void copyFile(){
        try(RandomAccessFile in=new RandomAccessFile("C://Users//wym//Desktop//write.txt","r");
             RandomAccessFile out=new RandomAccessFile("C://Users//wym//Desktop//write2.txt","rw"))
        {
            byte[] buffer=new byte[1024];
            int len=-1;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void merge(){
        File file=new File("C://Users//wym//Desktop//于文文心跳.mp3");
        try( RandomAccessFile in=new RandomAccessFile("C://Users//wym//Desktop//冯提莫体面.mp3","r");
              RandomAccessFile out=new RandomAccessFile(file,"rw");
        ) {
            byte[] buffer=new byte[1024];
            int len=-1;
            out.seek(file.length());//定位到写文件的尾部
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
