package lesson17HomeWork;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void write(String file, String data){
        FileWriter fw=null;
        try{
            fw=new FileWriter(file);
            fw.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }



    public static void writeStudentInJsonToFile(Student student, File file){
        Gson gson=new Gson();
        try(FileWriter writer=new FileWriter(file.getName())){
            gson.toJson(student, writer);
        }catch (IOException e){
            e.printStackTrace();
        }

    }




}
