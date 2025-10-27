import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TicketSystemWithRandomTime {

    // Inner Ticket class
    static class Ticket {
        int ticketNumber;
        String timestamp;

        Ticket(int number, String time) {
            this.ticketNumber = number;
            this.timestamp = time;
        }

        public String toString() {
            return "Ticket #" + ticketNumber + " (Time: " + timestamp + ")";
        }
    }

    public static void main(String[] args) {
        Queue<Ticket> ticketQueue = new LinkedList<>();
        Random random = new Random();

        // === Generate Tickets Phase ===
        System.out.println("=== Generating Tickets ===");

        for (int i = 1; i <= 5; i++) {
            String time = java.time.LocalTime.now().toString();
            Ticket t = new Ticket(i, time);
            ticketQueue.add(t);
            System.out.println("Generated: " + t);

            // Simulate random wait time between 0.5 and 1.5 seconds
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nAll tickets generated! Now serving...\n");

        // === Process Tickets Phase ===
        while (!ticketQueue.isEmpty()) {
            Ticket current = ticketQueue.poll();
            System.out.println("Now serving: " + current);

            // Simulate random serving time (1–2 seconds)
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nAll customers have been served!");
    }
}
