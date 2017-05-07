package entity;

import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="salary_standard")
public class SalaryStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "basic")
    private Double basicSalary;

    @Column(name = "comm")
    private Integer commission;


    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(o instanceof SalaryStandard)
            return id == ((SalaryStandard)o).id;
        return false;
    }

    @Override
    public int hashCode() {
        return 17*31+id;
    }
}
