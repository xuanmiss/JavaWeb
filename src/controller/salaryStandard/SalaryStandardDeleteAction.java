package controller.salaryStandard;

import com.opensymphony.xwork2.ActionSupport;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.salaryStandard.ISalaryStandardHandleSvc;

/**
 * Created by Administrator on 2017/5/14/014.
 */
@Controller("deleteSalaryStandard")
@Scope("prototype")
public class SalaryStandardDeleteAction extends ActionSupport {
    @Autowired
    private ISalaryStandardHandleSvc salaryStandardSvc;

    private Integer id;

    public String execute(){

        if(salaryStandardSvc.delete(id, SalaryStandard.class)){
            return SUCCESS;
        }
        return "error";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
