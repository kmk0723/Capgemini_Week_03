public class InventoryManagementSystem {
    Node head;
    static class Node{
        String itemName;
        String itemId;
        double quantity;
        double price;
        Node next;

        public Node(String itemName, String itemId, double quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next=null;
        }
    }

    public void addStart(String itemName,String itemId, double quantity, double price){
        Node newNode=new Node(itemName,itemId,quantity,price);
        newNode.next=head;
        head=newNode;
    }

    public void addEnd(String itemName,String itemId, double quantity, double price){
        Node newNode=new Node(itemName,itemId,quantity,price);
        if(head==null){
            newNode.next=head;
            head=newNode;
            return;
        }else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
            newNode.next=null;
        }
    }

    public void addSpecificPosition(int position, String itemName,String itemId, double quantity, double price){
        Node newNode=new Node(itemName,itemId,quantity,price);
        if(position==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        if(head==null){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node current=head;
        int currestPos=0;
        while(current!=null&& currestPos<position-1){
            current=current.next;
            currestPos++;
        }
        if(current==null){
            addEnd(itemName,itemId,quantity,price);
        }else{
            newNode.next = current.next;
            current.next = newNode;
        }

    }
    public void removeItem(String itemId){
        Node current=head;
        Node prev=null;
        if(head==null){
            System.out.println("Empty");
            return;
        }
        if(head.itemId.equals(itemId)){
            head=head.next;
            return;
        }
        while(current!=null){
            if(current.itemId.equals(itemId)){
                prev.next=current.next;
                return;
            }
            prev=current;
            current=current.next;
        }
    }

    public void updateQuantity(double quantity,String itemId){
        if(head==null){
            System.out.println("Empty");
        }
        Node current=head;
        while(current!=null){
            if(current.itemId.equals(itemId)){
                current.quantity=quantity;

            }
            current=current.next;
        }
    }

    public void searchByItemId(String itemId){
        if(head==null){
            System.out.println("empty");
        }
        Node current=head;
        while(current!=null){
            if(current.itemId.equals(itemId)){
                System.out.println("Item Name: "+current.itemName+"\nItem Id: "+current.itemId+"\nQuantity: "+current.quantity+"\nPrice: "+current.price);

            }else{
                System.out.println("No item found with itemId: "+itemId);
            }
            current=current.next;
        }
    }

    public void searchByitemName(String itemName){
        if(head==null){
            System.out.println("Empty");
        }
        Node current=head;
        while(current!=null){
            if(current.itemName.equals(itemName)){
                System.out.println("Item Name: "+current.itemName+"\nItem Id: "+current.itemId+"\nQuantity: "+current.quantity+"\nPrice: "+current.price);
            }else{
                System.out.println("No item found with itemName: "+itemName);
            }
            current=current.next;
        }
    }
    public void totalValue(){
        if(head==null){
            System.out.println("Empty");
        }
        double totalValue=0;
        Node current=head;
        while(current!=null){
            totalValue=current.price*current.quantity;
            current=current.next;
        }
    }

    public void bubbleSort(boolean byName, boolean ascending) {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one node
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;

            while (current != null && current.next != null) {
                boolean comparison;

                // Compare based on name or price
                if (byName) {
                    int compareResult = current.itemName.compareTo(current.next.itemName);
                    comparison = ascending ? compareResult > 0 : compareResult < 0;
                } else {
                    comparison = ascending ?
                            current.price > current.next.price :
                            current.price < current.next.price;
                }

                // Swap nodes if they are in the wrong order
                if (comparison) {
                    swapped = true;

                    // Swap current and next nodes
                    Node next = current.next;
                    current.next = next.next;
                    next.next = current;

                    if (previous == null) {
                        head = next; // Update head if swapping involves the first node
                    } else {
                        previous.next = next;
                    }

                    previous = next; // Move previous pointer to the swapped node
                } else {
                    previous = current; // Move previous pointer normally
                    current = current.next; // Move current pointer normally
                }
                current=current.next;
            }
        } while (swapped); // Repeat until no swaps are needed
    }

    public void displayAll(){
        Node current=head;
        if(head==null){
            System.out.println("Empty List\n");
            return;
        }
        while(current!=null){
            System.out.println("\nItem Name: "+current.itemName+"\nItem Id: "+current.itemId+"\nQuantity: "+current.quantity+"\nPrice: "+current.price);
            current=current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims=new InventoryManagementSystem();
        ims.displayAll();
        ims.addStart("Rice","2A1",3,50);
        ims.displayAll();
        ims.addEnd("Plates","6A1",6,20);
        ims.displayAll();
        ims.addSpecificPosition(1,"spoons","5A1",7,10);
        ims.displayAll();
        ims.removeItem("plates");
        ims.displayAll();
        ims.updateQuantity(3,"6A1");
        ims.displayAll();
        ims.searchByItemId("6A1");
        ims.searchByitemName("Plates");
        ims.totalValue();
        ims.bubbleSort(false,false);
        ims.displayAll();



    }


}
