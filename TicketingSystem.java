import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Ticketing system simulation using a Queue.
 * 
 * Objective:
 *  - Generate tickets for customers as they arrive.
 *  - Process (serve) tickets in order.
 *  - Simulate random arrival and service times.
 */
public class TicketingSystem {

    // Ticket class representing a customer's ticket
    static class Ticket {
        private final int ticketNumber;
        private final String timestamp;

        public Ticket(int ticketNumber) {
            this.ticketNumber = ticketNumber;
            this.timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        }

        public int getTicketNumber() {
            return ticketNumber;
        }

        public String getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "Ticket #" + ticketNumber + " | Time: " + timestamp;
        }
    }

    // Method to simulate ticket generation
    public static Queue<Ticket> generateTickets(int totalTickets) {
        Queue<Ticket> queue = new LinkedList<>();
        Random random = new Random();

        System.out.println("=== Generating Tickets ===");
        for (int i = 1; i <= totalTickets; i++) {
            Ticket ticket = new Ticket(i);
            queue.add(ticket);
            System.out.println("Generated: " + ticket);

            // Simulate random customer arrival (0.5–1.5 seconds)
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nAll tickets have been generated!\n");
        return queue;
    }

    // Method to simulate ticket processing (serving customers)
    public static void processTickets(Queue<Ticket> queue) {
        Random random = new Random();

        System.out.println("=== Serving Tickets ===");
        while (!queue.isEmpty()) {
            Ticket ticket = queue.poll(); // Dequeue
            System.out.println("Now serving: " + ticket);

            // Simulate variable service time (1–2 seconds)
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nAll customers have been served!");
    }

    // Main method: simulate ticketing system
    public static void main(String[] args) {
        int totalTickets = 5; // You can change this number

        // Phase 1: Generate tickets
        Queue<Ticket> ticketQueue = generateTickets(totalTickets);

        // Phase 2: Process tickets
        processTickets(ticketQueue);
    }
}
