import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample{
    public static void main(String[] args) {
        String filepath="sample.txt";
        try(BufferedReader bf=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=bf.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}