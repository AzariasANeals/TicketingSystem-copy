

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Queue;

/**
 * The test class TicketingSystemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TicketingSystemTest
{
    @Test
    public void testGenerateFiveTickets(){
        TicketingSystem system = new TicketingSystem();
        Queue<TicketingSystem.Ticket> queue = system.generateTickets(5);
        assertEquals(5, queue.size());
        
        int num = 1;
        for (TicketingSystem.Ticket t: queue){
            assertEquals(num++, t.ticketNumber);
            assertNotNull(t.timestamp);
        }
        
    }
    
    @Test
    public void testGenerateTwoTickets(){
        TicketingSystem system = new TicketingSystem();
        Queue<TicketingSystem.Ticket> queue = system.generateTickets(2);
        assertEquals(2, queue.size());        
    }
    
    @Test
    public void testGenerateTwentyTickets(){
        TicketingSystem system = new TicketingSystem();
        Queue<TicketingSystem.Ticket> queue = system.generateTickets(20);
        assertEquals(20, queue.size());        
    }
    
    @Test
    public void testZeroTickets(){
        TicketingSystem system = new TicketingSystem();
        Queue<TicketingSystem.Ticket> queue = system.generateTickets(0);
        assertTrue(queue.isEmpty());
    }
    
    @Test
    public void testServeTicketsEmptyQueue(){
        TicketingSystem system = new TicketingSystem();
        Queue<TicketingSystem.Ticket> queue = system.generateTickets(5);
        system.serveTickets(queue);
        assertTrue(queue.isEmpty());
    }
    
    @Test
    public void testGenerate100Tickets(){
        TicketingSystem system = new TicketingSystem();
        Queue<TicketingSystem.Ticket> queue = system.generateTickets(100);
        assertEquals(100, queue.size());
    }
}