package entity;

import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String model;         //型号编码
    private String format;       //规格 如600*1200
    private String color;        //颜色
    private String image;        //图片，以路径形式保存
    @ManyToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brand",nullable = false)
    private Brand brand;         //对应的品牌
    private double in_price;    //进价
    private double out_price;   //售价
    private Date date;            //推出日期
    private int status;          //状态码，1-在市，0-下市
    @OneToMany(targetEntity = Batch.class)
    private Set<Batch> batchs = new HashSet<Batch>();

    public Set<Batch> getBatchs() {
        return batchs;
    }

    public void setBatchs(Set<Batch> batchs) {
        this.batchs = batchs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getIn_price() {
        return in_price;
    }

    public void setIn_price(double in_price) {
        this.in_price = in_price;
    }

    public double getOut_price() {
        return out_price;
    }

    public void setOut_price(double out_price) {
        this.out_price = out_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Model)
            return id==((Model)a).id;
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
