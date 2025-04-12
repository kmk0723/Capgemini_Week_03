import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurence {
    public static void main(String[] args) {
        String filePath="sample.txt";
        String input="Hello";
        int count=0;
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;

            while((line=br.readLine())!=null){
                String[] words=line.split(" ");
                for(String word:words){
                    if(word.equals(input)){
                        count++;
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("The occurencec of the word"+input+" is: "+count);
    }



}
