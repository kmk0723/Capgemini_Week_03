public class TicketReservationSystem {
    private Node head;
    private int size;

    private static class Node {
        String ticketId;
        String customerName;
        String movieName;
        int seatNumber;
        String bookingTime;
        Node next;

        Node(String tid, String cname, String mname, int seat, String time) {
            ticketId = tid;
            customerName = cname;
            movieName = mname;
            seatNumber = seat;
            bookingTime = time;
            next = null;
        }
    }

    // Add new ticket to the end of the circular list
    public void addTicket(String tid, String cname, String mname, int seat, String time) {
        Node newNode = new Node(tid, cname, mname, seat, time);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    // Remove ticket by ID
    public void removeTicket(String tid) {
        if (head == null) return;

        Node curr = head, prev = null;
        do {
            if (curr.ticketId.equals(tid)) {
                if (curr == head) {
                    Node last = head;
                    while (last.next != head) last = last.next;
                    head = (head.next == head) ? null : head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked!");
            return;
        }

        Node current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId);
            System.out.println("Customer: " + current.customerName);
            System.out.println("Movie: " + current.movieName);
            System.out.println("Seat: " + current.seatNumber);
            System.out.println("Time: " + current.bookingTime);
            System.out.println("-----------------------");
            current = current.next;
        } while (current != head);
    }

    // Search tickets by customer or movie name
    public void searchTickets(String query) {
        if (head == null) return;

        Node current = head;
        boolean found = false;
        System.out.println("Search results for '" + query + "':");

        do {
            if (current.customerName.equalsIgnoreCase(query) ||
                    current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + current.ticketId);
                System.out.println("Seat: " + current.seatNumber);
                System.out.println("Time: " + current.bookingTime);
                System.out.println("-----------------------");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) System.out.println("No matching tickets found");
    }

    // Get total booked tickets
    public int getTotalTickets() {
        return size;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket("T1", "John Doe", "Avengers", 5, "14:30");
        system.addTicket("T2", "Jane Smith", "Star Wars", 12, "16:45");
        system.addTicket("T3", "John Doe", "Jurassic Park", 7, "19:15");

        system.displayTickets();
        /* Output:
           T1, T2, T3 tickets displayed */

        system.searchTickets("John Doe");
        /* Output:
           T1 and T3 tickets displayed */

        system.removeTicket("T2");
        system.displayTickets();
        /* Output:
           T1 and T3 tickets remaining */

        System.out.println("Total tickets: " + system.getTotalTickets());
        // Output: 2
    }
}
