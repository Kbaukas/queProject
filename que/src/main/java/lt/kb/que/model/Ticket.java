package lt.kb.que.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lt.kb.que.util.Speciality;
import lt.kb.que.util.TicketState;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String serialNumber = "";
    private Timestamp startTime;
    private Timestamp endTime;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @NotNull
    @Enumerated(EnumType.STRING)

    @Column(name = "state", columnDefinition = "ENUM('CANCELLED','WAITING','SERVING')", nullable = false)
    private TicketState ticketState;

    public Ticket() {
//        serialNumber = UUID.randomUUID().toString();
        ticketState=TicketState.WAITING;

    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }



    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "serial_number", nullable = false, length = 45)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    @Column(name = "start_time", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }


    @Column(name = "end_time", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket that = (Ticket) o;
        return id == that.id &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
