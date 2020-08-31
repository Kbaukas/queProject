package lt.kb.que.util;

import lt.kb.que.model.Specialist;
import lt.kb.que.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Generator {
    public static String serialNr(List<Ticket> tickets) {
        int number = new Random().nextInt(9999);
        String serialNr = String.format("%04d", number);
        if (!tickets.isEmpty()) {
            List<String> serialNrList = tickets.stream().map(Ticket::getSerialNumber).collect(Collectors.toList());

            for (String s:serialNrList) {
                if(s.equals(serialNr)){
                    serialNr(tickets);
                }

            }


        }
            return serialNr;

    }
    public static Long timeLeft(Ticket ticket){

      Long   now= Timestamp.valueOf(LocalDateTime.now()).getTime();
        return (ticket.getStartTime().getTime() - now)/(1000*60);
    }
}
