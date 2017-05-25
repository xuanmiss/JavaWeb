package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.salaryStandard.ISalaryStandardHandleSvc;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
@Controller("beforeUpdate")
@Scope("prototype")
public class BeforeUpdateAction extends ActionSupport{
    @Autowired
    private ISalaryStandardHandleSvc salarySvc;
    @Autowired
    private IClerkHandleSvc clerkSvc;

    private List<SalaryStandard> salaryStandardList;
    private Clerk clerk;
    private int clerkId;

    public List<SalaryStandard> getSalaryStandardList() {
        return salaryStandardList;
    }

    public void setSalaryStandardList(List<SalaryStandard> salaryStandardList) {
        this.salaryStandardList = salaryStandardList;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }


    public String execute(){

        clerk = clerkSvc.findById(clerkId);
        salaryStandardList = salarySvc.getAll();
        return SUCCESS;

    }

}
