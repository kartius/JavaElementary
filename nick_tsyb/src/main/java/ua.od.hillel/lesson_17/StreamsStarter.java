package ua.od.hillel.lesson_17;

import java.io.*;

public class StreamsStarter {


    public static void main(String[] args) {
        //Byte streams
        try (FileInputStream fis = new FileInputStream("filename")) {
            int i;
            while ((i = fis.read()) != -1) {
                //do something
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Character streams
        try (FileReader r = new FileReader("filename")) {
            int i;
            while ((i = r.read()) != -1) {
                //  cast to char
                //do something
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Buffered Character streams
        try (BufferedReader r = new BufferedReader(new FileReader("filename"))) {
            int i;
            while ((i = r.read()) != -1) {
                //  cast to char
                //do something
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        try (BufferedReader r = new BufferedReader(new FileReader("filename"))) {
            String line;
            while ((line = r.readLine()) != null) {
                //  cast to char
                //do something
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter w = new PrintWriter(new FileWriter("filename"))) {
            w.println("qqq");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //DataStreams
        try (DataOutputStream fis = new DataOutputStream(new FileOutputStream("qwe.txt"))) {
            fis.writeDouble(2.5);
        } catch (IOException e) {
            e.printStackTrace();
        }











    }

}
