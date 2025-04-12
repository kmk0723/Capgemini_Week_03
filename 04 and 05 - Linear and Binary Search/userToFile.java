import java.io.*;


public class userToFile {
    public static void main(String[] args) {
        String filePath="sample.txt";
        try(InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        FileWriter fw=new FileWriter(filePath, true)){
            String line;
            while(!(line=br.readLine()).equals("exit")){
                fw.write(line+ System.lineSeparator());
            }
            System.out.println("Input saved to: "+filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

}
