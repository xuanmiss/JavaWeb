package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="arrears")
public class Arrear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
}
