public class TaskScheduler {

    Node head;

    static class Node{
        String taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        public Node(String taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next=this;
        }
    }

    public void addStart(String taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Self-reference for circularity
        } else {
            newNode.next = head;
            // Traverse to find the last node (tail)
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode; // Update last node's next reference
            head = newNode; // Set new node as the head
        }
    }


    public void addEnd(String taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Self-reference for circularity
        } else {
            Node current = head;
            while (current.next != head) { // Traverse to find the last node
                current = current.next;
            }
            current.next = newNode; // Update last node's next reference
            newNode.next = head; // Point new node back to the head
        }
    }


    public void addAtPosition(int position, String taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null || position == 1) {
            addStart(taskId, taskName, priority, dueDate);
            return;
        }

        Node current = head;
        int count = 1;

        while (count < position - 1 && current.next != head) { // Traverse until position - 1 or circular end
            current = current.next;
            count++;
        }

        newNode.next = current.next; // Insert at the desired position
        current.next = newNode;
    }


    public void removeByTaskId(String taskID) {
        if (head == null) return; // Handle empty list

        Node current = head;
        Node prev = null;

        // Special case: Removing the head node
        if (head.taskId.equals(taskID)) {
            if (head.next == head) { // Single-node list
                head = null; // List becomes empty
                return;
            } else {
                // Traverse to find the last node in the list
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next; // Update last node's next reference
                head = head.next; // Update head to next node
                return;
            }
        }

        do {
            if (current.taskId.equals(taskID)) { // Found the node to remove
                prev.next = current.next; // Bypass the node to delete
                return;
            }
            prev = current;          // Track previous node
            current = current.next;  // Move to next node
        } while (current != head);
    }


    public void viewCurrentAndMoveNExt() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current task:");
        System.out.println("ID: " + head.taskId + "\nName: " + head.taskName + "\nPriority: " + head.priority + "\nDue Date: " + head.dueDate);

        head = head.next; // Move to next task in circular list
    }


    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Node current = head;

        do {
            System.out.println("ID: " + current.taskId + "\nName: " + current.taskName + "\nPriority: " + current.priority + "\nDue Date: " + current.dueDate);
            current = current.next; // Move to next node in circular list
        } while (current != head); // Stop when we loop back to the start
    }


    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Node current = head;

        do {
            if (current.priority == priority) { // Match found for priority
                System.out.println("ID: " + current.taskId + "\nName: " + current.taskName + "\nPriority: " + current.priority + "\nDue Date: " + current.dueDate);
            }
            current = current.next; // Move to next node in circular list
        } while (current != head); // Stop when we loop back to the start
    }


    public static void main(String[] args) {
        TaskScheduler ts=new TaskScheduler();
        ts.displayAll();
        ts.addStart("123","HomeWork",1,"11-04-2025");
        ts.displayAll();
        ts.addEnd("321","Classwork",3,"18-04-2025");
        ts.addAtPosition(2,"312","Hybrid",2,"02-05-2025");
        ts.displayAll();
        ts.viewCurrentAndMoveNExt();
        ts.searchByPriority(2);
    }
}
