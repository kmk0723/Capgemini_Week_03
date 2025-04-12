import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        HashSet<Character> set=new HashSet<>();

        String s="Hello";
        s="World";
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);

            }
        }
        String S= sb.toString();
        System.out.println("original: "+s);
        System.out.println("String Without duplicates: "+S);



    }
}
