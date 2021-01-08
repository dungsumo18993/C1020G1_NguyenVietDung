package Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FilingCabinets {
    public static void searchEmployee(){
        Scanner scanner = new Scanner(System.in);
        Stack<String> stringStack = new Stack<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Employee.csv")
            );
            String line = null;
            while ((line= bufferedReader.readLine()) != null){
               stringStack.push(line);
            }

            System.out.println("Nhập ID: ");
            String id = scanner.next();

            for (String s : stringStack) {
                String[] array = s.split(",");
                if (array[0].equals(id)) {
                    System.out.println("Name: " + array[1] + ", Age: " + array[2] + ", Address:" + array[3]);
                    System.out.println("---------------------------------------");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
