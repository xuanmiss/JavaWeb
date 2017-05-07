package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by ymcvalu on 2017/5/4.
 */


@Entity(name="clerk")
public class Clerk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String identity;
    private String name;
    private String phone;
    private String address;
    private Date birthday;
    private Date entry_time;
    private String weichat;
    private String salary_card;
    private int status;
    private String duties;
    @ManyToOne(targetEntity = SalaryStandard.class,fetch = FetchType.EAGER)
    @JoinColumn(name="salary",referencedColumnName = "id",unique = true)
    private SalaryStandard salaryStandard;
    @OneToMany(targetEntity = Client.class,fetch = FetchType.LAZY,mappedBy = "clerk")
     private Set<Client> clients;


    @OneToMany (targetEntity = Clerk_Client.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk",referencedColumnName = "id")

    private Set<Clerk_Client> cc;
    public void setCC(Set<Clerk_Client> cc){
        this.cc=cc;
    }
    public Set<Clerk_Client> getCC(){
        return cc;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Date entry_time) {
        this.entry_time = entry_time;
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }

    public String getSalary_card() {
        return salary_card;
    }

    public void setSalary_card(String salary_card) {
        this.salary_card = salary_card;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public SalaryStandard getSalaryStandard() {
        return salaryStandard;
    }

    public void setSalaryStandard(SalaryStandard salaryStandard) {
        this.salaryStandard = salaryStandard;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Clerk)
            return id==((Clerk)a).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 17*31+id;
    }
}
