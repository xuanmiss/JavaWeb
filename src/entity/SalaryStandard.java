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

    @Column(name = "basic", precision = 10, scale = 2, nullable = false)
    private Double basicSalary;

    @Column(name = "comm")
    private Integer commission;

    @Column(columnDefinition = "NOT NULL DEFAULT '基础工资+业绩*提成%'")
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
}
