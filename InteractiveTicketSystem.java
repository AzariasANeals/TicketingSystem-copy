import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class InteractiveTicketSystem {

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
        Scanner scanner = new Scanner(System.in);
        Queue<Ticket> ticketQueue = new LinkedList<>();
        Random random = new Random();

        System.out.println("=== Welcome to the Interactive Ticket System ===\n");

        // === Ticket Generation Phase ===
        System.out.print("How many tickets do you want to generate? ");
        int totalTickets = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("\nPress ENTER to generate each ticket...\n");

        for (int i = 1; i <= totalTickets; i++) {
            System.out.print("Press ENTER to generate Ticket #" + i + "...");
            scanner.nextLine();

            String time = java.time.LocalTime.now().toString();
            Ticket t = new Ticket(i, time);
            ticketQueue.add(t);

            System.out.println("✅ Generated: " + t);

            // Random delay between 0.5s and 1.5s to simulate arrival
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n🎟️ All tickets have been generated!");
        System.out.println("Press ENTER to start serving customers...");
        scanner.nextLine();

        // === Ticket Serving Phase ===
        while (!ticketQueue.isEmpty()) {
            Ticket current = ticketQueue.poll();
            System.out.print("Press ENTER to serve the next ticket...");
            scanner.nextLine();

            System.out.println("🧾 Now serving: " + current);

            // Random service time between 1s and 2s
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("✅ Finished serving Ticket #" + current.ticketNumber + "\n");
        }

        System.out.println("🎉 All customers have been served! Goodbye!");
        scanner.close();
    }
}
