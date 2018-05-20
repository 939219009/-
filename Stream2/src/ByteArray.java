import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArray {
    @Test
    public void ByteA(){
        ByteArrayOutputStream bout=new ByteArrayOutputStream();

        int a=100;
        int b=80;
        int c=90;

        bout.write(a);
        bout.write(b);
        bout.write(c);

        byte[] buffer=bout.toByteArray();
//        for(int i=0;i<buffer.length;i++){
//            System.out.println(buffer[i]);
//        }

        ByteArrayInputStream bin=new ByteArrayInputStream(buffer);

        int len=-1;
        int i=0;
        while((len=bin.read())!=-1){
            System.out.println(buffer[i]);
            i++;
        }

    }
}
