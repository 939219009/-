import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class Main {

    @Test
    public void copyFile(){
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E://IJ//CLion-2017.2.3.exe"),1024*1024);
             BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("C://Users//wym//Desktop//write2.exe"));) {

              byte[] buffer=new byte[1024*1024];
              int len=-1;

              while((len=bis.read(buffer))!=-1){
                   bos.write(buffer,0,len);
              }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void In(){
       InputStream is=System.in;
       while(true) {
           byte[] buffer = new byte[1024];
           try {
               is.read(buffer);
               System.out.println(new String(buffer).trim());
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    public void In2(){
        Scanner sc=new Scanner(System.in);
        while(true){
            String str=sc.nextLine();
            System.out.println(str);

            if(str.trim().toUpperCase().equals("Q")){
                break;
            }
        }
        sc.close();
    }
    @Test
    public void  ScannerFileTest(){
        try {
            Scanner sc=new Scanner(new File("C://Users//wym//Desktop//mysql.txt"));
            while(sc.hasNextLine()){
                String string = null;
                string=sc.nextLine();
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void In3(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
                String str=br.readLine();
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Main().ScannerFileTest();
    }
}
