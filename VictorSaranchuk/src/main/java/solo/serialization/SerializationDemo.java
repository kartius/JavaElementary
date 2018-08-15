package solo.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream("serial"))){
        MyClass object1=new MyClass("Hello", 9, 55e4);
            System.out.println("Object1 "+object1);

            ous.writeObject(object1);
            ous.close();
        }catch (IOException e){
            System.out.println(e);
        }

        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("serial"))){
            MyClass object2=(MyClass)ois.readObject();
            System.out.println("Object2 "+object2);

            ois.close();
        }catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
