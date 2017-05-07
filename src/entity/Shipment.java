package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Shipment)
            return id==((Shipment)a).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+31*id;
    }
}
