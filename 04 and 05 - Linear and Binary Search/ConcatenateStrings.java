public class ConcatenateStrings {

    static public String concatenate(String[] arr){
        StringBuffer sb=new StringBuffer();

        for(String word: arr){
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr={"Hello ","World","!"};
        String result=concatenate(arr);

        System.out.println("Concatenated String: "+result);
    }
}
