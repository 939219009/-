import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.ReadWriteLock;

public class Main {

    public static void readFile(){
        FileInputStream fis=null;
        InputStreamReader reader=null;
        BufferedReader buffer=null;
        try {
            fis = new FileInputStream("C://Users//wym//Desktop//mysql.txt");
            reader = new InputStreamReader(fis,"gbk"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
            buffer = new BufferedReader(reader);
//            byte[] buffer=new byte[1024];
//            int n=-1;
//            while((n=fis.read(buffer))!=-1){
//                System.out.println(new String(buffer));
//            }
            String str;
            while ((str=buffer.readLine())!=null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                reader.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test//字符流
    public void readerFile(){//字符流
        File file=null;
        Reader reader=null;

        try {
            file=new File("C://Users//wym//Desktop//mybatis.cfg.xml");
            reader=new FileReader(file);
            char[] buffer=new char[1024];
            int n=-1;
            while((n=reader.read(buffer))!=-1){
                 System.out.println(new String(buffer));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void writerFile(){
        File file=new File("C://Users//wym//Desktop//33.txt");
        try(Writer   writer=new FileWriter(file);) {
            writer.write("赵冬雪");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void copyerFile(){
        File file=new File("C://Users//wym//Desktop//mybatis.cfg.xml");
        File file1=new File("C://Users//wym//Desktop//newmybatis.cfg.xml");
        try(Reader reader=new FileReader(file);
            Writer writer=new FileWriter(file1)) {
         int n=-1;
         char[] buffer =new char[1024];
         while((n=reader.read(buffer))!=-1){
             writer.write(buffer);
         }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("C://Users//wym//Desktop//write.txt");

            fos.write("吴云明".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void copyFile(){
        FileInputStream fis=null;
        FileOutputStream fos=null;

        try {
            fis = new FileInputStream("C://Users//wym//Desktop//mysql.txt");
            fos = new FileOutputStream("C://Users//wym//Desktop//mysql1.txt");

            byte[] buffer = new byte[1024];
            long start=System.currentTimeMillis();
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
               fos.write(buffer,0,len);
            }
            long end=System.currentTimeMillis();
            SimpleDateFormat sf=new SimpleDateFormat("mm:ss");
            System.out.println(sf.format(end-start));


          }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void makeFile(){
        File file=new File("C://Users//wym//Desktop//make");
        try {
           // file.createNewFile();//创建文件
            file.mkdir();//创建目录
            System.out.print(file.isDirectory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //readFile();
       //writeFile();
        copyFile();
    }

}
