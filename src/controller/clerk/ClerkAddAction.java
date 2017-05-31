package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import entity.Clerk;
import entity.Role;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.role.IRoleHandleSvc;
import service.salaryStandard.ISalaryStandardHandleSvc;
import util.IdentityUtil;
import util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/13.
 */
@Controller("addClerk")
@Scope("prototype")
public class ClerkAddAction extends ActionSupport implements Preparable{

    @Autowired
    private ISalaryStandardHandleSvc salarySvc;
    @Autowired
    private IClerkHandleSvc clerkSvc;
    @Autowired
    private IRoleHandleSvc roleSvc;

    private Role role;
    private Clerk clerk;
    private List<SalaryStandard> salaryStandardList;
    private int status = 0;

    @Override
    public String execute()throws Exception{

            if(status == 0)
                return "input";
            //保存
            if(check()){
                clerkSvc.saveClerk(clerk);//先保存业务员信息
                System.out.print(clerk.getId());
                role.setClerk(clerk);
                roleSvc.save(role);//再保存登陆信息
            }

            else return "input";
            return "show";

    }


    public Boolean check(){

        //忽略开始空字符
        //clerk.setIdentity(clerk.getIdentity().trim());
        clerk.setPhone(clerk.getPhone().trim());
        //clerk.setSalary_card(clerk.getSalary_card().trim());
        clerk.setWeichat(clerk.getWeichat().trim());
        clerk.setName(clerk.getName().trim());
        role.setPassword(role.getPassword().trim());
        role.setUsername(role.getUsername().trim());
        clerk.setEntry_time(new Date());
        role.setAuthority(1);

        //业务员姓名
        //判断是否为空
        //用户名、密码
        if(!role.getUsername().matches("^([A-Z]|[a-z]|[0-9]){6,20}$")){
            addFieldError("username", "用户名由6~20位字母、数字组成！");
            return false;
        }
        else if(roleSvc.isExist(role.getUsername(), "username")){
            addFieldError("username", "该用户名已经存在");
            return false;
        }
        else if(!role.getPassword().matches("^([A-Z]|[a-z]|[0-9]){6,20}$")){
            addFieldError("password", "密码由6~20位字母、数字组成！");
            return false;
        }
        else if(StringUtil.isEmptyString(clerk.getName())){
            addFieldError("name", "业务员姓名不能为空！");
            return false;
        }
        //业务员身份证
        else if(clerkSvc.isExist(clerk.getIdentity(), "identity")){
            addFieldError("identity", "该身份证已被注册！");
            return false;
        }
        else if(!IdentityUtil.isValidatedAllIdcard(clerk.getIdentity())){
            addFieldError("identity", "身份证格式出错！");
            return false;
        }
        //业务员手机号
        else if(!clerk.getPhone().matches(("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"))){
            addFieldError("phone", "手机号码格式错误！");
            return false;
        }
        else if(clerkSvc.isExist(clerk.getPhone(), "phone")){
            addFieldError("phone", "该手机号已被注册！");
            return false;
        }



        //业务员职位
        clerk.setDuties("业务员");

        //设置业务员状态
        clerk.setStatus(1);

        //设置生日
        clerk.setBirthday(IdentityUtil.getBirthdayByIdentiy(clerk.getIdentity()));

        //设置性别
        clerk.setSex(IdentityUtil.getSexByIdentity(clerk.getIdentity()));

        //设置地址
        clerk.setAddress(IdentityUtil.getHomelandByIdentity(clerk.getIdentity()));

        //设置工资卡
        long random = new Random().nextInt(999999999);
        while(clerkSvc.isExist((Long.toString(random)), "salary_card"))
            random = new Random().nextInt(999999999);
        clerk.setSalary_card(Long.toString(random));

        return true;
    }

    @Override
    public void prepare(){
        salaryStandardList = salarySvc.getAll();
    }


    public List<SalaryStandard> getSalaryStandardList() {
        return salaryStandardList;
    }

    public void setSalaryStandardList(List<SalaryStandard> salaryStandardList) {
        salaryStandardList = salaryStandardList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
