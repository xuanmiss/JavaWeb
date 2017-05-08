package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String name;//姓名
    private String phone;//手机号
    private String weichat;//微信
    private String address;//地址
    private int reposal;//信用值
    private int status;//状态
    private String card;//银行账户
    private char sex;

    @OneToMany(targetEntity = Order.class,fetch = FetchType.LAZY,mappedBy = "receiver")
    private Set<Order> orders;  //订单

    @ManyToOne(targetEntity = Clerk.class,fetch = FetchType.LAZY)
    @JoinTable(
            name = "clerk_client",
            joinColumns = @JoinColumn(name = "client",referencedColumnName = "id",unique = true),
            inverseJoinColumns = @JoinColumn(name="clerk",referencedColumnName = "id"))
    private Clerk clerk;  //签约业务员


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getReposal() {
        return reposal;
    }

    public void setReposal(int reposal) {
        this.reposal = reposal;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Client)
            return id==((Client)a).id;
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
