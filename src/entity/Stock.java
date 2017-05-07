package entity;

import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int count;  //库存数量
    @OneToOne(targetEntity = Batch.class)
    @JoinColumn(name = "batch",nullable = false)
    private Batch batch; //外键批号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Stock)
            return id==((Stock)a).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 17*31+id;
    }
}
