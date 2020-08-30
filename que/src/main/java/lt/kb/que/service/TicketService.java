package lt.kb.que.service;

import lt.kb.que.dao.SpecialistDao;
import lt.kb.que.model.Specialist;
import lt.kb.que.model.Ticket;
import lt.kb.que.dao.TicketDao;
import lt.kb.que.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    TicketDao ticketDao;
    @Autowired
    SpecialistService specialistService;

   public Page<Ticket> findPage(int pageNo, int pageSize){
        Pageable pageable= PageRequest.of(pageNo -1,pageSize);
        return ticketDao.findAll(pageable);

    }
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }



    public Ticket addNewTicket(Ticket ticket) {
        List<Ticket> tickets = ticketDao.findAll().stream().filter(a -> a.getSpecialist()
                .getSpeciality().equals(ticket.getSpecialist().getSpeciality())).collect(Collectors.toList());

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + tickets);
        Ticket newTicket = new Ticket();
        if(tickets.isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            newTicket.setStartTime(Timestamp.valueOf(now));
        }else{

            long t=tickets.get(tickets.size()-1).getStartTime().getTime();
            long m=ticket.getSpecialist().getSpeciality().getSessionTime()*60*1000;

            Timestamp theNewTimestamp=new Timestamp (t+m);
            newTicket.setStartTime(theNewTimestamp);
        }
        newTicket.setEndTime(ticket.getEndTime());
        newTicket.setSerialNumber(Generator.serialNr(ticketDao.findAll()));
        Specialist specialist = new Specialist();
        specialist = specialistService.findBySpeciality(ticket.getSpecialist().getSpeciality()).get(0);
        newTicket.setSpecialist(specialist);
        System.out.println(newTicket);

        ticketDao.save(newTicket);
        System.out.println("iDDDD "+newTicket.getId());
        return newTicket;
    }
    public Optional<Ticket> getBySerialNumber(String serialNumber) {
        Optional<Ticket> ticket = ticketDao.findAll().stream().filter(a -> a.getSerialNumber().equals(serialNumber)).findAny();
       return ticket;
    }
}
