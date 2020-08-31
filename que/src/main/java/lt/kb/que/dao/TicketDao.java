package lt.kb.que.dao;

import lt.kb.que.model.Specialist;
import lt.kb.que.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketDao extends JpaRepository<Ticket,Integer>{

    @Query("select t from Ticket t where t.serialNumber= :filter")
    List<Ticket> findBySerialNumber(@Param("filter") String filter);

}
