public class MovieManagementSystem {
    Node head;

    static class Node{
        String movietitle;
        String Director;
        int yearOfRelease;
        double rating;
        Node next;
        Node prev;


        public Node(String movietitle, String director, int yearOfRelease, double rating) {
            this.movietitle = movietitle;
            Director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.prev=null;
            this.next=null;
        }
    }
    public void addStart(String movieTitle,String director,int yearOfRelease,double rating){
        Node newNode=new Node(movieTitle,director,yearOfRelease,rating);
        newNode.next=head;
        newNode.prev=null;
        if(head!=null) {
            head.prev = newNode;
        }
        head=newNode;
    }
    public void addLast(String movieTitle,String director,int yearOfRelease,double rating){
        Node newNode=new Node(movieTitle,director,yearOfRelease,rating);
        if(head==null){
            head=newNode;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
        newNode.prev=current;
    }

    public void addAtSpecificPosition(int position,String movieTitle,String director,int yearOfRelease,double rating){
        Node newNode=new Node(movieTitle,director,yearOfRelease,rating);
        if(position==0){
            newNode.next=head;
            head=newNode;
            newNode.prev=null;
            return;
        }

        Node current=head;
        int currentPosition=0;
        while(current!=null && currentPosition<position-1){
            current=current.next;
            currentPosition++;
        }
        if(current==null){
            addLast(movieTitle,director,yearOfRelease,rating);
            return;
        }

        newNode.next=current.next;
        newNode.prev=current;

        if(current.next!=null){
            current.next.prev=newNode;
        }
        current.next=newNode;

    }

    public void removeByTitle(String movietitle){
        Node current=head;
        while(current!=null){
            if(current.movietitle.equals(movietitle)){
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

    public String searchByDirector(String Director){
        Node current=head;
        while(current!=null){
            if(current.Director.equals(Director)){
                return "Movie Title: "+ current.movietitle+"\n Director: "+current.Director+"\nYear of Release: "+current.yearOfRelease+"\nRating: "+current.rating;
            }
            current=current.next;
        }
        return "Director: "+Director+" is not found";
    }

    public void displayForward(){
        Node current=head;
        if(current==null){
            System.out.println("Empty");
        }
        while(current!=null){
            System.out.println("\nMovie Title: "+ current.movietitle+"\n Director: "+current.Director+"\nYear of Release: "+current.yearOfRelease+"\nRating: "+current.rating);
            current=current.next;
        }
    }

    public void displayReverse(){
        Node current=head;
        if(current==null){
            System.out.println("Empty");
            return;
        }
        while(current.next!=null){
            current=current.next;
        }
        while(current!=null){
            System.out.println("Movie Title: "+ current.movietitle+"\n Director: "+current.Director+"\nYear of Release: "+current.yearOfRelease+"\nRating: "+current.rating);
            current=current.prev;
        }
    }

    public void updateRating(String movieTitle,double rating){
        Node current=head;
        if(current==null){
            System.out.println("Empty");
        }
        while(current!=null){
            if(current.movietitle.equals(movieTitle)){
                current.rating=rating;
                return;
            }
            current=current.next;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms=new MovieManagementSystem();
        mms.displayForward();
        mms.addStart("Race Gurram","Surender Reddy",2014,7.3);
        mms.displayForward();
        mms.addLast("Pokiri","Trivikram",2006,8);
        mms.displayForward();
        mms.addAtSpecificPosition(2,"Aravinda Sametha","Trivikram",2018,7.3);
        mms.displayForward();
        System.out.println("Reverse Display");
        mms.displayReverse();
        mms.removeByTitle("Race Gurram");
        mms.displayForward();
        mms.searchByDirector("Trivikram");
        mms.updateRating("Pokiri",8.3);
        mms.displayForward();



    }

}
