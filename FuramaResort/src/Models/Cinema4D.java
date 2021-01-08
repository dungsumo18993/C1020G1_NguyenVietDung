package Models;

import Controllers.CustomerController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Cinema4D {
    static Queue<Customer> customerQueue = new LinkedList<>();
    static List<Customer> customerList = new ArrayList<>();
    public static void showCinemaCustomer(){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Customer.csv")
            );
            String line = null;
            while ((line=bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                Customer customer = new Customer(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7]);
                customerList.add(customer);
            }
            for (Customer element : customerList){
               element.showInfo();
            }

            customerQueue.add(customerList.get(2));
            customerQueue.add(customerList.get(3));

            System.out.println("-----------------------");
            Customer customer = null;
            while (!customerQueue.isEmpty()){
                customer = customerQueue.poll();
                customer.showInfo();
            }
            System.out.println("-----------------------");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
