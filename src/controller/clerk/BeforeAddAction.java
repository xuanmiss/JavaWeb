package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.salaryStandard.ISalaryStandardHandleSvc;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
@Controller("beforeAdd")
@Scope("prototype")
public class BeforeAddAction extends ActionSupport{
    @Autowired
    private ISalaryStandardHandleSvc salarySvc;
    private List<SalaryStandard> salaryStandardList;
    private Clerk clerk;

    public List<SalaryStandard> getSalaryStandardList() {
        return salaryStandardList;
    }

    public void setSalaryStandardList(List<SalaryStandard> salaryStandardList) {
        this.salaryStandardList = salaryStandardList;
    }


    @Override
    public String execute(){
        salaryStandardList = salarySvc.getAll();
        return SUCCESS;
    }
}
