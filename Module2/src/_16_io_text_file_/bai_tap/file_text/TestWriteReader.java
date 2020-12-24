package _16_io_text_file_.bai_tap.file_text;

import java.io.*;

public class TestWriteReader {
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                            new File("src/_16_io_text_file_/bai_tap/file_text/folder_a/a.csv")));
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(new File("src/_16_io_text_file_/bai_tap/file_text/folder_b/b.csv")));
            String line = null;

            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.write("6, Nguyen Van F, 22/12/2020");
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
