package ua.od.hillel.lesson_16.serialization.xml_serialization;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GsonExample {


    public static void main(String[] args) {


        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("test");
        customer.setAge(29);
        customer.setOrders(Arrays.asList("test1", "test2", "test3"));

        Customer customer1 = new Customer();
        customer1.setId(1001);
        customer1.setName("test1");
        customer1.setAge(291);
        customer1.setOrders(Arrays.asList("test11", "test21", "test31"));


        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);

        MyObject myObject = new MyObject();
        myObject.setCustomers(customers);


        Gson gson = new Gson();


        try (FileWriter writer = new FileWriter("testGson2.json")) {

            gson.toJson(myObject, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
