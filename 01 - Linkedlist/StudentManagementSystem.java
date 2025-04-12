public class StudentManagementSystem{
    Node head;

    static class Node{
        int age;
        String name;
        int rollNumber;
        String grade;
        Node next;

        public Node(int age, String name, int rollNumber, String grade) {

            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    public void addFirst(int rollNumber,String name,int age,String grade){

        Node newNode=new Node(age,name,rollNumber,grade);
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int rollNumber,String name,int age,String grade){

        Node newNode=new Node(age,name,rollNumber,grade);
        if(head==null){
            head=newNode;
            return;
        }

        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }

    public void addAtposition(int position,int rollNumber,String name,int age,String grade){
        Node newNode=new Node(age,name,rollNumber,grade);

        if(position==0){
            newNode.next=head;
            head=newNode;
            return;
        }

        Node current=head;
        int currentPosition=0;
        while(current!=null && currentPosition<position-1){
            current=current.next;
            currentPosition++;
        }
        if(current==null){
            addLast(rollNumber,name,age,grade);
        }else{
            newNode.next=current.next;
            current.next=newNode;
        }
    }

    public void deleteByRollNumber(int rollNumber){
        if(head==null){
            return;
        }

        if(head.rollNumber==rollNumber){
            head=head.next;
            return;
        }

        Node current=head;
        Node prev=null;

        while(current!=null){
            if(current.rollNumber==rollNumber){
                prev.next=current.next;
                return;
            }
            prev=current;
            current=current.next;
        }
    }

    public String searchByRollNumber(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return "Roll Number: " + current.rollNumber + "\nName: " + current.name + "\nAge: " + current.age + "\nGrade: " + current.grade + "\n";
            }
            current = current.next;
        }
        return "Student with Roll Number " + rollNumber + " not found.";
    }


    public void displayAll(){

        Node current=head;
        while(current!=null){
            System.out.println("Roll Number: "+current.rollNumber+"\nName: "+current.name+"\nAge: "+current.age+"\nGrade: "+current.grade+"\n");
            current=current.next;
        }

    }

    public void updateGrade(int rollNumber,String newGrade){
        Node current=head;
        while(current!=null){
            if(current.rollNumber==rollNumber){
                current.grade=newGrade;
                return;
            }
            current=current.next;
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms=new StudentManagementSystem();
        sms.addFirst(101,"Alice",20,"A+");
        sms.addLast(102,"Bob",20,"A");
        sms.addAtposition(1,100,"Jhon",20,"O");

        System.out.println("Student details");
        sms.displayAll();

        sms.deleteByRollNumber(102);
        System.out.println("\nAfter deleting Bob");
        sms.displayAll();

        // Update grade
        sms.updateGrade(101, "A");
        System.out.println("\nAfter updating Alice's grade");
        sms.displayAll();

        // Search student
        System.out.println("\nSearching for roll 101");
        System.out.println(sms.searchByRollNumber(101));
    }
}