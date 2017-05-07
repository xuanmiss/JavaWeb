package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="clerk_brand")
public class Clerk_Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private Date date;
    private Integer status;
    @OneToOne(targetEntity = Clerk.class)
    @JoinColumn(name = "clerk", referencedColumnName = "id", unique = true)
    private Clerk clerk;
    @JoinColumn(name = "brand", referencedColumnName = "id", unique = true)
    private Brand brand;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }



    @Override

    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Clerk_Brand)
            return id==((Clerk_Brand)a).id;
        else
            return false;
    }



    @Override
    public int hashCode() {
        return 17*31+id;
    }

}
