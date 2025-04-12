public class StringConcatenation {

    public static void string(String a,String b){
        String c="";
        for(int i=0;i<10000;i++){
            c=c+a+b;
        }

    }
    public static void stringBuilder(String a,String b){
        StringBuilder sb=new StringBuilder(a);
        for(int i=0;i<10000;i++){
            sb.append(a).append(b);
        }


    }

    public static void stringBuffer(String a,String b){
        StringBuffer sb1=new StringBuffer(a);
        for(int i=0;i<10000;i++){
            sb1.append(a).append(b);
        }
    }

    public static void main(String[] args) {
        String a="Hello! ";
        String b="World";

        long Start=System.nanoTime();
        string(a,b);
        long end=System.nanoTime();
        System.out.println("Time taken to concatenate two Strings in strings: "+(end-Start)/1000000+"ms");

        Start=System.nanoTime();
        stringBuilder(a,b);
        end=System.nanoTime();
        System.out.println("Time taken to concatenate two Strings in string builders: "+(end-Start)/1000000+"ms");

        Start=System.nanoTime();
        stringBuffer(a,b);
        end=System.nanoTime();
        System.out.println("Time taken to concatenate two Strings in StringBuffers: "+(end-Start)/1000000+"ms");


    }
}
