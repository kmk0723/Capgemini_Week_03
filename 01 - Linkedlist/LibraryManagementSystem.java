public class LibraryManagementSystem {
    Node head;

    static class Node{
        String title;
        String author;
        String genre;
        String bookID;
        boolean availableStatus;
        Node next;
        Node prev;

        public Node(String title, String author, String genre, String bookID, boolean availableStatus) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookID = bookID;
            this.availableStatus = availableStatus;
            this.next=null;
            this.prev=null;
        }
    }

    public void addStart(String title, String author, String genre, String bookID, boolean availableStatus){
        Node newNode=new Node(title,author,genre,bookID,availableStatus);
        if(head!=null){
            head.prev=newNode;
        }
        newNode.next=head;
        head=newNode;
        newNode.prev=null;

    }

    public void addEnd(String title, String author, String genre, String bookID, boolean availableStatus){
        Node newNode=new Node(title,author,genre,bookID,availableStatus);
        if(head==null){
            addStart(title,author,genre,bookID,availableStatus);
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        newNode.prev=current;
        current.next=newNode;
    }

    public void addAtPosition(int position, String title, String author, String genre, String bookID, boolean availableStatus){
        Node newNode=new Node(title,author,genre,bookID,availableStatus);
        if(position==0){
            addStart(title,author,genre,bookID,availableStatus);
            return;
        }
        Node current=head;
        int currentPos=0;
        while(current!=null && currentPos<position-1){
            current=current.next;
            currentPos++;
        }
        if(current==null){
            addEnd(title,author,genre,bookID,availableStatus);
            return;
        }
        newNode.prev=current;
        newNode.next=current.next;

        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }

    public void removeByItemId(String bookID){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node current=head;
        while(current!=null){
            if(current.bookID.equals(bookID)){
                if(current.prev!=null){
                    current.prev.next=current.next;
                }else{
                    head=current.next;
                }
                if(current.next!=null){
                    current.next.prev=current.prev;
                }
                return;

            }
            current=current.next;
        }
    }

    public void searchByBook(String title){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node current=head;
        while(current!=null){
            if(current.title.equals(title)){
                System.out.println("\nBook Title: "+current.title+"\nAuthor: "+current.author+"\nGenre: "+current.genre+"\nBook Id: "+current.bookID+"\nAvailability Status: "+current.availableStatus);

            }
            current=current.next;
        }
    }

    public void searchByAuthor(String author){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node current=head;
        while(current!=null){
            if(current.author.equals(author)){
                System.out.println("\nBook Title: "+current.title+"\nAuthor: "+current.author+"\nGenre: "+current.genre+"\nBook Id: "+current.bookID+"\nAvailability Status: "+current.availableStatus);

            }
            current=current.next;
        }
    }

    public void updateStatus(boolean status, String bookID){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node current=head;
        while(current!=null){
            if(current.bookID.equals(bookID)){
                current.availableStatus=status;
            }
            current=current.next;
        }
    }

    public void DisplayForward(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node current=head;
        while(current!=null){
            System.out.println("\nBook Title: "+current.title+"\nAuthor: "+current.author+"\nGenre: "+current.genre+"\nBook Id: "+current.bookID+"\nAvailability Status: "+current.availableStatus);
            current=current.next;
        }
    }

    public void DisplayReverse(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        while(current!=null){
            System.out.println("\nBook Title: "+current.title+"\nAuthor: "+current.author+"\nGenre: "+current.genre+"\nBook Id: "+current.bookID+"\nAvailability Status: "+current.availableStatus);
            current=current.prev;
        }
    }

    public void noofBooks(){
        int count=0;
        Node current=head;
        while(current!=null){
            if(current.availableStatus){
                count++;
            }
            current=current.next;
        }
        System.out.println("Number of Bokks in a Library are: "+count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms=new LibraryManagementSystem();
        lms.DisplayForward();
        System.out.println("\nAdding 1st book");
        lms.addStart("Book1","author1","genre1","1",true);
        lms.DisplayForward();
        System.out.println("\nAdding 3rd book");
        lms.addEnd("Book3","author3","genre3","3",false);
        lms.DisplayForward();
        System.out.println("\nAdding Second book and position");
        lms.addAtPosition(1,"Book2","Author2","Genre2","2",false);
        lms.DisplayForward();
        System.out.println("\nRemove Second book");
        lms.removeByItemId("2");
        lms.DisplayForward();
        lms.updateStatus(true,"3");
        System.out.println("Update Status for book 3");
        lms.DisplayForward();
        System.out.println("\nReverse Order");
        lms.DisplayReverse();
        System.out.println();
        lms.noofBooks();
    }
}
