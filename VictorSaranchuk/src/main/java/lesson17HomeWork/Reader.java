package lesson17HomeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {


    public static String read(File file){
        FileReader fr=null;
        String str=null;
        try{
            fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            char c[]=new char[(int)file.length()];
            br.read(c);
            str=String.copyValueOf(c);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        return str;
    }

    public static int getIdFromFile(File file){
        int id=-1;
        String[] spliter=read(file).split(" ");
        String[] spliterAfterSpliter;
        for(int i=0; i<spliter.length; i++){
            if(spliter[i].contains("ID:")){
               spliterAfterSpliter=spliter[i+1].split("\n");
               id=Integer.parseInt(spliterAfterSpliter[0].trim());
            }
            }
        return id;
    }

    public static String getLastNameFromFile(File file){
        String lastName=null;
        String[] spliter=read(file).split(" ");
        String[] spliterAfterSpliter;
        for(int i=0; i<spliter.length; i++){
            if(spliter[i].contains("LastName:")){
                spliterAfterSpliter=spliter[i+1].split("\n");
                lastName=spliterAfterSpliter[0].trim();
            }
        }
        return lastName;
    }

    public static String getFirstNameFromFile(File file){
        String firstName=null;
        String[] spliter=read(file).split(" ");
        String[] spliterAfterSpliter;
        for(int i=0; i<spliter.length; i++){
            if(spliter[i].contains("FirstName:")){
                spliterAfterSpliter=spliter[i+1].split("\n");
                firstName=spliterAfterSpliter[0].trim();
            }
        }
        return firstName;
    }

    public static int getAgeFromFile(File file){
        int age=-1;
        String[] spliter=read(file).split(" ");
        String[] spliterAfterSpliter;
        for(int i=0; i<spliter.length; i++){
            if(spliter[i].contains("Age:")){
                spliterAfterSpliter=spliter[i+1].split("\n");
                age=Integer.parseInt(spliterAfterSpliter[0].trim());
            }
        }
        return age;
    }

}
