package lesson17HomeWork;

import java.io.*;

public class CompareBISandFIS {
    public static void main(String[] args) throws IOException {

        //Create array of bytes
        String str="SpeedTest";
        byte[] array=str.getBytes();

        // Write to file array of bytes
        FileOutputStream fos=new FileOutputStream("test.txt");
        fos.write(array,0,array.length);

        //Find FileInputStream with 1000 iterations
        FileInputStream fis=new FileInputStream("test.txt");
        long l=System.nanoTime();
        for(int i=0; i<1000; i++){
            fis.read();
        }
        System.out.println("FileInputStream:   "+(System.nanoTime()-l));
        //Create and find BufferedInputStream ith 1000 iterations
        ByteArrayInputStream bais= new ByteArrayInputStream(array);
        BufferedInputStream bis=new BufferedInputStream(bais);
        l=System.nanoTime();
        for (int i=0; i<1000; i++){
            bis.read();
        }
        System.out.println("BufferdInputStream: "+(System.nanoTime()-l));


    }
}
