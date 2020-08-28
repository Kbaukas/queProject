package lt.kb.que.dao;

import lt.kb.que.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket,Integer>{
}
