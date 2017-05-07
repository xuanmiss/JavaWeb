package entity;


import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
public class Clerk_Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private int clerk; //clerk外键
    private int client; //client外键
    private int contract; //外键合同

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

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
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
        return super.hashCode()+31*id;
    }
}
