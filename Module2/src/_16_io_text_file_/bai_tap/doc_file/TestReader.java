package _16_io_text_file_.bai_tap.doc_file;

import java.io.*;

public class TestReader {
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                            new File("src\\_16_io_text_file_\\bai_tap\\doc_file\\file.csv")));
            String line = null;
            String[] arr=null;

            while ((line=bufferedReader.readLine()) != null){
                arr=line.split(",");
                System.out.println(arr[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
