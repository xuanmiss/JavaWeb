package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import entity.Clerk;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.salaryStandard.ISalaryStandardHandleSvc;
import util.StringUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */
@Controller("updateClerk")
@Scope("prototype")
public class ClerkUpdateAction extends ActionSupport implements Preparable {

    @Autowired
    private ISalaryStandardHandleSvc salarySvc;
    @Autowired
    private IClerkHandleSvc clerkHandleSvc;

    private int clerkId;
    private List<SalaryStandard> salaryStandardList;
    private Clerk clerk;
    private int status = 0;

    public List<SalaryStandard> getSalaryStandardList() {
        return salaryStandardList;
    }

    public void setSalaryStandardList(List<SalaryStandard> salaryStandardList) {
        this.salaryStandardList = salaryStandardList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public String execute(){

            if(status == 0){
                clerk = clerkHandleSvc.findById(clerkId);
                return "input";
            }
            if(check()){
                Clerk preClerk = clerkHandleSvc.findById(clerk.getId());
                preClerk.setAddress(clerk.getAddress());
                preClerk.setWeichat(clerk.getWeichat());
                preClerk.setPhone(clerk.getPhone());
                preClerk.setName(clerk.getName());
                preClerk.setStatus(clerk.getStatus());
                preClerk.setSex(clerk.getSex());
                preClerk.setSalaryStandard(clerk.getSalaryStandard());
                clerkHandleSvc.saveClerk(preClerk);
                return "show";
            }else{
                clerkId = clerk.getId();
                return "input";
            }



    }

    public Boolean check(){

        //忽略开始空字符
        clerk.setAddress(clerk.getAddress().trim());
        clerk.setWeichat(clerk.getWeichat().trim());
        clerk.setPhone(clerk.getPhone().trim());
        clerk.setName(clerk.getName().trim());

        //判断是否为空
        //业务员姓名
        if(StringUtil.isEmptyString(clerk.getName())){
            addFieldError("name", "业务员姓名不能为空！");
            return false;
        }
        //判断手机号码
        if(!clerk.getPhone().matches(("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"))){
            addFieldError("phone", "手机号码格式错误！");
            return false;
        }
        return true;
    }

    public void prepare(){
        salaryStandardList = salarySvc.getAll();
    }
}
