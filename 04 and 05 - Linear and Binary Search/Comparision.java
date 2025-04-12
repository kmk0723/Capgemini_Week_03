import java.io.*;
import java.nio.charset.StandardCharsets;

public class Comparision {
    public static void main(String[] args) {
        String targetWord = "java";
        int count1 = 0;
        int count2 = 0;
        double startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        double endTime = System.nanoTime();
        double builderTime = endTime - startTime;

        System.out.println("Builder Time: " + builderTime);

        startTime = System.nanoTime();
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sb1.append("hello");
        }
        endTime = System.nanoTime();
        double bufferTime = endTime - startTime;
        System.out.println("Buffer Time: " + bufferTime);

        String filepath = "sample.txt";
        startTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count1++;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        bufferTime = endTime - startTime;
        System.out.println("Count: " + count1);
        System.out.println("FileReader Time: " + bufferTime);

        startTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count2++;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        bufferTime = endTime - startTime;
        System.out.println(count2);
        System.out.println("InputStreamReader Time: " + bufferTime);

    }
}
