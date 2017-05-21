package controller.salaryStandard;

import com.opensymphony.xwork2.ActionSupport;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.salaryStandard.ISalaryStandardHandleSvc;
import util.StringUtil;

/**
 * Created by Administrator on 2017/5/14/014.
 */
@Controller("findByIdSalaryStandard")
@Scope("prototype")
public class SalaryStandardFindByIdAction extends ActionSupport {
    @Autowired
    private ISalaryStandardHandleSvc salaryStandardSvc;

    private SalaryStandard salaryStandard;

    private Integer id;

    public String execute(){
        salaryStandard = salaryStandardSvc.findById(id);
        return SUCCESS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SalaryStandard getSalaryStandard() {
        return salaryStandard;
    }

    public void setSalaryStandard(SalaryStandard salaryStandard) {
        this.salaryStandard = salaryStandard;
    }
}
