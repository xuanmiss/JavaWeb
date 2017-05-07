package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private int bitch_no; //  bitch_no外键
    private int date; //date外键
    private int model; //外键品牌型号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBitch_no() {
        return bitch_no;
    }

    public void setBitch_no(int bitch_no) {
        this.bitch_no = bitch_no;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getModel() { return model; }

    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Batch)
            return id==((Batch)a).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 17*31+id;
    }

}
