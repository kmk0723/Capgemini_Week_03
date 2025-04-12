import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStacks {

    Deque<Integer> enqueueStack;
    Deque<Integer> dequeStack;

    public QueueUsingStacks() {
        enqueueStack=new ArrayDeque<>();
        dequeStack=new ArrayDeque<>();
    }

    public void enqueue(int value){
        enqueueStack.push(value);
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        transferIfNeeded();
        return dequeStack.pop();
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        transferIfNeeded();
        return dequeStack.peek();
    }

    public boolean isEmpty(){
        return enqueueStack.isEmpty() && dequeStack.isEmpty();
    }

    public void transferIfNeeded(){
        if(dequeStack.isEmpty()){
            while(!enqueueStack.isEmpty()){
                dequeStack.push(enqueueStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks queue=new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: "+queue.dequeue());

        System.out.println("peek: "+queue.peek());

        queue.enqueue(40);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Is empty: " + queue.isEmpty());

    }
}
