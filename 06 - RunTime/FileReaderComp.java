import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReaderComp {

    public static void Filereader(String filePath){
        try(FileReader reader=new FileReader(filePath)){
            int ch;
            while((ch=reader.read())!=-1){

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static  void inputStream(String filePath){
        try(InputStreamReader reader=new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)){
            int ch;
            while((ch=reader.read())!=-1){

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath="Sample.txt";
        long start = System.nanoTime();
        Filereader(filePath);
        long end = System.nanoTime();
        System.out.println("FileReader time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        inputStream(filePath);
        end = System.nanoTime();
        System.out.println("InputStreamReader time: " + (end - start) / 1_000_000 + " ms");
    }
}
