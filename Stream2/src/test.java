import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class test {
    @Test
    public void Test(){
        Runtime runtimen=Runtime.getRuntime();

        System.out.println(runtimen.availableProcessors()+" "+runtimen.freeMemory()+" "+runtimen.maxMemory()+
        " "+runtimen.hashCode());
//        try {
//           // runtimen.exec("C://IJ//Python//PyCharm 2017.2.3//bin//pycharm.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void Test2(){
        Calendar calendar=Calendar.getInstance();
        Date date=calendar.getTime();
        calendar.setTime(date);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-DD EEEE HH:mm:ss");
        String str=dateFormat.format(calendar.getTime());
        System.out.println(str);
        //System.out.println(calendar.getTime());
    }
    @Test
    public void D(){
        DateTimeFormatter[] formatters=new DateTimeFormatter[]{
              DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE HH:mm:ss")
        } ;
        LocalDateTime date=LocalDateTime.now();

        for(int i=0;i<formatters.length;i++){
            System.out.println(date.format(formatters[i]));
        }
        Date date1=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-DD EEEE HH:mm:ss");
        String str=dateFormat.format(date1);
        try {
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
