import java.util.*;

public class DataStructuresSearching {

    public static void main(String[] args) {
        int dataSize=1_000_000;
        int target=dataSize-1;

        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<dataSize;i++){
            arr.add(i);
        }
        Set<Integer> hashSet= new HashSet<>(arr);
        Set<Integer> treeSet=new TreeSet<>(arr);

        long s=System.nanoTime();
        boolean isFound=arr.contains(target);
        long e=System.nanoTime();
        System.out.println("ArrayList time: "+(e-s));

        s=System.nanoTime();
        isFound=hashSet.contains(target);
        e=System.nanoTime();
        System.out.println("ArrayList time: "+(e-s));

        s=System.nanoTime();
        isFound=treeSet.contains(target);
        e=System.nanoTime();
        System.out.println("ArrayList time: "+(e-s));
    }
}
