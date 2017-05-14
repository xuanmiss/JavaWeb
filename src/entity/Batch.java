package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int batch_no; //  批号
    private Date date; //生产日期
    @ManyToOne(targetEntity = Model.class)
    @JoinColumn(name = "model",nullable = false)
    private Model model; //外键品牌型号
    @OneToOne(targetEntity = Stock.class,mappedBy ="batch" )
    private Stock stock; //对应库存

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBitch_no() {

        return batch_no;
    }

    public void setBitch_no(int bitch_no) {
        this.batch_no = bitch_no;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        int result=17;
        result=result*31+id;
        result=result*31+id*id;
        result=result*31+id*id*id;
        return result;
    }

}
