public class RoundRobinSchedule {
    Node head;
    private int timeQuantum;
    private int totalProcesses;
    private int totalWaitingTime;
    private int totalTurnAroundTime;

    static class Node {
        String processId;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime;
        Node next;

        public Node(String processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.next = null;
        }
    }

    public RoundRobinSchedule(int quantum) {
        this.timeQuantum = quantum;
        this.totalProcesses = 0;
        this.totalWaitingTime = 0;
        this.totalTurnAroundTime = 0;
    }

    // Add process to end of circular list
    public void addProcess(String id, int burst, int priority) {
        Node newNode = new Node(id, burst, priority);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        totalProcesses++;
    }

    // Remove process by ID
    private void removeProcess(String id) {
        if (head == null) return;

        Node curr = head, prev = null;
        do {
            if (curr.processId.equals(id)) {
                if (curr == head) {
                    Node last = head;
                    while (last.next != head) last = last.next;
                    head = (head.next == head) ? null : head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                totalProcesses--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Run scheduling simulation
    public void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }

        int currentTime = 0;
        Node current = head;

        while (totalProcesses > 0) {
            if (current.remainingTime == 0) {
                current = current.next;
                continue;
            }

            int executeTime = Math.min(current.remainingTime, timeQuantum);
            current.remainingTime -= executeTime;
            currentTime += executeTime;

            // Update waiting times for other processes
            Node temp = current.next;
            while (temp != current) {
                if (temp.remainingTime > 0) {
                    temp.waitingTime += executeTime;
                }
                temp = temp.next;
            }

            if (current.remainingTime == 0) {
                totalWaitingTime += current.waitingTime;
                totalTurnAroundTime += currentTime;
                String completedId = current.processId;
                current = current.next; // Move pointer before removal
                removeProcess(completedId);
            } else {
                current = current.next;
            }

            displayProcesses();
        }

        displayStatistics();
    }

    private void displayProcesses() {
        if (head == null) {
            System.out.println("[Queue Empty]");
            return;
        }

        System.out.print("Current Queue: ");
        Node temp = head;
        do {
            System.out.printf("%s (RT:%d WT:%d) → ",
                    temp.processId, temp.remainingTime, temp.waitingTime);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    private void displayStatistics() {
        System.out.println("\nScheduling Complete!");
        System.out.printf("Average Waiting Time: %.2f\n",
                (float) totalWaitingTime / totalProcesses);
        System.out.printf("Average Turn-Around Time: %.2f\n",
                (float) totalTurnAroundTime / totalProcesses);
    }

    public static void main(String[] args) {
        RoundRobinSchedule scheduler = new RoundRobinSchedule(4);
        scheduler.addProcess("P1", 8, 1);
        scheduler.addProcess("P2", 2, 2);
        scheduler.addProcess("P3", 7, 3);
        scheduler.simulate();
    }
}
