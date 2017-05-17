package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import util.IdentityUtil;
import util.StringUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/13.
 */
@Controller("addClerk")
@Scope("prototype")
public class ClerkAddAction extends ActionSupport{

    private Clerk clerk;

    @Autowired
    private IClerkHandleSvc clerkSvc;

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public String execute()throws Exception{

        //保存
        clerkSvc.saveClerk(clerk);

        return "show";
    }

    @Override
    public void validate(){

        //忽略开始空字符
        //clerk.setIdentity(clerk.getIdentity().trim());
        clerk.setPhone(clerk.getPhone().trim());
        //clerk.setSalary_card(clerk.getSalary_card().trim());
        clerk.setWeichat(clerk.getWeichat().trim());
        clerk.setName(clerk.getName().trim());
        clerk.setEntry_time(new Date());

        //业务员姓名
        //判断是否为空
        if(StringUtil.isEmptyString(clerk.getName()))
            addFieldError("name", "业务员姓名不能为空！");

        //业务员身份证
        if(clerkSvc.isExist(clerk.getIdentity(), "identity"))
            addFieldError("identity", "该身份证已被注册！");
        else if(!IdentityUtil.isValidatedAllIdcard(clerk.getIdentity()))
            addFieldError("identity", "身份证格式出错！");


        //业务员手机号
        if(clerkSvc.isExist(clerk.getPhone(), "phone"))
            addFieldError("phone", "该手机号已被注册！");
        else if(!clerk.getPhone().matches(("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")))
            addFieldError("phone", "手机号码格式错误！");
        //业务员状态
        if(clerk.getStatus() < 0)
            addFieldError("status", "请选择业务员状态！");

        //业务员职位
        if(clerk.getDuties().equals("-1"))
            addFieldError("status", "请选择业务员职位！");


        //设置生日
        clerk.setBirthday(IdentityUtil.getBirthdayByIdentiy(clerk.getIdentity()));

        //设置薪资
        SalaryStandard ss = new SalaryStandard();
        ss.setId(1);
        clerk.setSalaryStandard(ss);

        //设置性别
        clerk.setSex(IdentityUtil.getSexByIdentity(clerk.getIdentity()));

        //设置地址
        try{
            clerk.setAddress(IdentityUtil.getHomelandByIdentity(clerk.getIdentity()));
        }catch (Exception e){
            e.printStackTrace();
        }

        //设置工资卡
        clerk.setSalary_card("a123");
    }

}
