package entity;


import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="order_form")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(targetEntity = Client.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver",referencedColumnName = "id")
    private Client receiver;
}
