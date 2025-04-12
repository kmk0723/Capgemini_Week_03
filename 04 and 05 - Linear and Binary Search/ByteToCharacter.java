import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class ByteToCharacter {
    public static void main(String[] args) {
        String filepath="sample.txt";
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8))){
            String line;

            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
