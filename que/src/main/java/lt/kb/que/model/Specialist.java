package lt.kb.que.model;

import com.sun.istack.NotNull;
import lt.kb.que.util.Speciality;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialists")
public class Specialist {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


    @NotNull
    @Enumerated(EnumType.STRING)

    @Column(name = "speciality", columnDefinition = "ENUM('ADMIN','ACCOUNTANT','MANAGER','SUPPORT')", nullable = false)
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
