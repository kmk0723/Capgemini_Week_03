import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    public static void main(String[] args) {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter Your name: ");
            String name=br.readLine();
            System.out.println("Welcome: "+name+"!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
