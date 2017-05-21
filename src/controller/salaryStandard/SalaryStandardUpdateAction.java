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
@Controller("updateSalaryStandard")
@Scope("prototype")
public class SalaryStandardUpdateAction extends ActionSupport {
    @Autowired
    private ISalaryStandardHandleSvc salaryStandardSvc;

    private SalaryStandard salaryStandard;

    @Override
    public String execute() throws Exception{

        salaryStandardSvc.update(salaryStandard);

        return SUCCESS;
    }

    @Override
    public void validate(){
        salaryStandard.setDescription(salaryStandard.getDescription().trim());
        if(StringUtil.isEmptyString(salaryStandard.getDescription()))
            addFieldError("description", "描述信息不能为空!");
    }

    public SalaryStandard getSalaryStandard() {
        return salaryStandard;
    }

    public void setSalaryStandard(SalaryStandard salaryStandard) {
        this.salaryStandard = salaryStandard;
    }
}
