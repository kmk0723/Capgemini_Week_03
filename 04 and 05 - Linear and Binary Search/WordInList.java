import java.util.Scanner;


public class WordInList {

    public static String findWord(String[] arr,String toFind){
        for(String sentence:arr){
            String[] words=sentence.split(" ");
            for(String word:words){
                if(word.equals(toFind)){
                    return sentence;
                }
            }

        }
        return "Word Not found";
    }

    public static void main(String[] args) {
        System.out.println("Enter number of sentences: ");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String toFind="java";
        String[] arr=new String[n+1];
        System.out.println("Enter "+n+" sentences");
        for(int i=0;i<n+1;i++){
            arr[i]=scanner.nextLine();
        }
        scanner.close();

        System.out.println(findWord(arr,toFind));
    }
}
