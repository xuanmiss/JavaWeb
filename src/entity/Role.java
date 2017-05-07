package entity;

import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private Integer authority;

    @OneToOne(targetEntity = Clerk.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk")
    private Clerk clerk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(o instanceof Role)
            return id == ((Role)o).id;
        return false;
    }

    @Override
    public int hashCode() {
        return 17*31+id;
    }
}
