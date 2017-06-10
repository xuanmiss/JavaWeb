package controller.salaryStandard;

import com.opensymphony.xwork2.ActionSupport;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.salaryStandard.ISalaryStandardHandleSvc;
import util.StringUtil;

/**
 * Created by Administrator on 2017/5/13/013.
 */
@Controller("salaryStandardAdd")
@Scope("prototype")
public class SalaryStandardAddAction extends ActionSupport {

    @Autowired
    private ISalaryStandardHandleSvc salaryStandardSvc;

    private SalaryStandard salaryStandard;

    @Override
    public String execute() throws Exception{

        salaryStandardSvc.save(salaryStandard);

        return SUCCESS;
    }

    @Override
    public void validate(){
        salaryStandard.setDescription(salaryStandard.getDescription().trim());
        if(salaryStandard.getBasicSalary() == null || salaryStandard.getBasicSalary() == 0)
            addFieldError("basicSalary", "基本工资格式出错!");
        else if(salaryStandard.getCommission() == null || salaryStandard.getCommission() == 0)
            addFieldError("commission", "工资提成格式出错!");
        else if(StringUtil.isEmptyString(salaryStandard.getDescription()))
            addFieldError("description", "描述信息不能为空!");
    }

    public SalaryStandard getSalaryStandard() {
        return salaryStandard;
    }

    public void setSalaryStandard(SalaryStandard salaryStandard) {
        this.salaryStandard = salaryStandard;
    }

}
