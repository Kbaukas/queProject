package lt.kb.que.service;

import lt.kb.que.model.Ticket;
import lt.kb.que.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketDao ticketDao;

    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }

    public void addNewTicket(Ticket ticket) {

   Ticket newTicket = new Ticket();
   newTicket.setStartTime(ticket.getStartTime());
   newTicket.setEndTime(ticket.getEndTime());
   ticketDao.save(ticket);
    }
}
