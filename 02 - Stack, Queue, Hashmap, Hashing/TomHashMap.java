import java.util.LinkedList;

public class TomHashMap{
    static final int size=10;

    static class Node{
        String key;
        int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] buckets;

    public TomHashMap(){
        buckets=new LinkedList[size];
        for(int i=0;i<size;i++){
            buckets[i]=new LinkedList<>();
        }
    }

    public int getIndex(String key){
        return Math.abs(key.hashCode())%size;
    }

    public void put(String key,int value){
        int index=getIndex(key);
        for(Node node: buckets[index]){
            if(node.key.equals(key)){
                node.value=value;
                return;
            }
        }
        buckets[index].add(new Node(key,value));
    }

    public Integer get(String key) {
        int index = getIndex(key);
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(String key){
        int index=getIndex(key);
        buckets[index].removeIf(node -> node.key.equals(key));
    }

    public static void main(String[] args) {
        TomHashMap map = new TomHashMap();

        map.put("apple", 10);
        map.put("banana", 20);
        System.out.println("Get apple: " + map.get("apple"));   // 10
        map.put("apple", 15);
        System.out.println("Updated apple: " + map.get("apple")); // 15
        map.remove("apple");
        System.out.println("After removal, apple: " + map.get("apple")); // null
    }
}