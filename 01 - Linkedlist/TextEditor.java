public class TextEditor {
    private Node head;
    private Node current;
    private int size;
    private final int historyLimit;

    private static class Node {
        String text;
        Node prev;
        Node next;

        public Node(String text) {
            this.text = text;
        }
    }

    public TextEditor(int limit) {
        this.historyLimit = limit;
    }

    // Add new text state to history
    public void addState(String text) {
        Node newNode = new Node(text);

        if (head == null) {
            head = newNode;
            current = newNode;
            size = 1;
        } else {
            // Remove future states when adding new changes
            Node next = current.next;
            while (next != null) {
                Node temp = next.next;
                next.prev = null;
                next.next = null;
                next = temp;
                size--;
            }

            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            size++;

            // Maintain history limit
            while (size > historyLimit) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }

    // Undo to previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // Redo to next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // Display current text
    public void display() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("Empty Document");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(3);

        editor.addState("Initial draft");
        editor.display();  // Initial draft

        editor.addState("Added introduction");
        editor.addState("Added conclusion");
        editor.display();  // Added conclusion

        editor.undo();
        editor.display();  // Added introduction

        editor.addState("Revised introduction");
        editor.display();  // Revised introduction

        editor.undo();
        editor.undo();
        editor.display();  // Initial draft (limited by history)

        editor.redo();
        editor.display();  // Revised introduction
    }
}
