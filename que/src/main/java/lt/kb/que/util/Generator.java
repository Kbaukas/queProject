package lt.kb.que.util;

import lt.kb.que.model.Specialist;
import lt.kb.que.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Generator {
    public static String serialNr(List<Ticket> tickets) {
        int number = new Random().nextInt(9999);
        String serialNr = String.format("%04d", number);
        if (!tickets.isEmpty()) {
            List<String> serialNrList = tickets.stream().map(t -> t.getSerialNumber()).collect(Collectors.toList());
            if (serialNrList.contains(serialNr)) {
                serialNr(tickets);
            } else {
                return serialNr;
            }
        }
            return serialNr;

    }
}
