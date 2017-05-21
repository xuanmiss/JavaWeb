package entity;


import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
@Table(name="clerk_client")
public class Clerk_Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private int clerk; //clerk外键
    private int client; //client外键


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClerk() {
        return clerk;
    }

    public void setClerk(int clerk) {
        this.clerk = clerk;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }




    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Clerk_Client)
            return id==((Clerk_Client)a).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int result=17;
        result=result*31+id;
        result=result*31+id*id;
        result=result*31+id*id*id;
        return result;
    }
}
