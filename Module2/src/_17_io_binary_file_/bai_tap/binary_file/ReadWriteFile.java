package _17_io_binary_file_.bai_tap.binary_file;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {

        Student student1 = new Student(1,"Luffy",19);
        Student student2 = new Student(2,"Zoro",19);
        Student student3 = new Student(3,"Sanji",19);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src\\_17_io_binary_file_\\bai_tap\\binary_file\\file.io"));

            objectOutputStream.writeObject(student1);
            objectOutputStream.writeObject(student2);
            objectOutputStream.writeObject(student3);

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src\\_17_io_binary_file_\\bai_tap\\binary_file\\file.io"));
            Student student = null;
            do {
                student = (Student) objectInputStream.readObject();
                System.out.println(student);
            } while (student != null);
        }catch (EOFException e){
            System.out.println("Đã hết file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
