package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private Date date;
    private Date deadline;
    private String description;
    @OneToOne(targetEntity = Clerk.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "personA", referencedColumnName = "id", unique = true)
    private Clerk clerk;
    @OneToOne(targetEntity = Client.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "personB", referencedColumnName = "id", unique = true)
    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }




    @Override

    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Contract)
            return id==((Contract)a).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 17*31+id;
    }

}
