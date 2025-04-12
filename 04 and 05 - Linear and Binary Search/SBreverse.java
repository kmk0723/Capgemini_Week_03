public class SBreverse {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("hello");
        sb.reverse();
        String s=sb.toString();
        System.out.println("String Builder: "+sb);
        System.out.println("String: "+s);

    }
}
