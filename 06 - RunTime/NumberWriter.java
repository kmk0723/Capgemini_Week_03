import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NumberWriter {
    public static void main(String[] args) {
        String fileName = "Sample.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 74000000; i++) {
                writer.write(Integer.toString(i));

                // Optional: flush every 1 million numbers to manage memory
                if (i % 1000000 == 0) {
                    writer.flush();
                    System.out.println("Written up to: " + i);
                }
            }
            System.out.println("Done writing numbers to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
