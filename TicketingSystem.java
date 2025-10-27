import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TicketingSystem
{
     // Inner Ticket Class
     
     static class Ticket{
         
         int ticketNumber;
         String timestamp;
         
         Ticket(int number, String time){
             this.ticketNumber = number;
             this.timestamp = time;
         }
         
         public String toString(){
             return "Ticket #" + ticketNumber + " (Time: " + timestamp + ")"; 
         }
         
     }
     
    // Generates a queue of tickets
    public Queue<Ticket> generateTickets(int count) {
        Queue<Ticket> ticketQueue = new LinkedList<>();
        for (int i = 1; i <= count; i++) {
            String time = java.time.LocalTime.now().toString();
            ticketQueue.add(new Ticket(i, time));
        }
        return ticketQueue;
    }

    // Serves tickets (removes them from queue)
    public void serveTickets(Queue<Ticket> queue) {
        while (!queue.isEmpty()) {
            queue.poll(); // simulate serving
        }
    }
     
     public static void main(String[] args){
         Queue<Ticket> ticketQueue = new LinkedList<>();
         Random random = new Random();
         
         System.out.println(" -- Generating Tickets --");
         
         for (int i=1; i <= 5; i++){
             String time = java.time.LocalTime.now().toString();
             Ticket t = new Ticket(i, time);
             ticketQueue.add(t);
             System.out.println("Generated: " + t);
             
             try{
                 Thread.sleep(500 + random.nextInt(1000));
             }
             catch(InterruptedException e){
                 Thread.currentThread().interrupt();
             }
             
         }
         
         System.out.println("\nAll tickets generated! Now serving . . . \n");
         
         while (!ticketQueue.isEmpty()){
             Ticket current = ticketQueue.poll();
             System.out.println("Now serving: " + current);
             
            try{
                 Thread.sleep(1000 + random.nextInt(1000));
             }
             catch(InterruptedException e){
                 Thread.currentThread().interrupt();
             }
         }
         
         
         System.out.println("\nAll customers have been served!");
     }
    
    
    
}