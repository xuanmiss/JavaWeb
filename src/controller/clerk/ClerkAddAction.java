package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.IHandleClerkSvc;
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
    private IHandleClerkSvc clerkSvc;

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public String execute()throws Exception{
        clerk.setEntry_time(new Date());
        clerk.setStatus(1);

        //保存
        clerkSvc.saveClerk(clerk);

        return "input";
    }

    @Override
    public void validate(){

        //忽略开始空字符
        clerk.setAddress(clerk.getAddress().trim());
        //clerk.setIdentity(clerk.getIdentity().trim());
        clerk.setPhone(clerk.getPhone().trim());
        //clerk.setSalary_card(clerk.getSalary_card().trim());
        clerk.setWeichat(clerk.getWeichat().trim());
        clerk.setName(clerk.getName().trim());
        clerk.setStatus(1);
        clerk.setDuties("业务员");
        clerk.setEntry_time(new Date());

        //业务员姓名
        //判断是否为空
        if(StringUtil.isEmptyString(clerk.getName()))
            addFieldError("name", "业务员姓名不能为空！");

        //业务员身份证
        if(clerkSvc.isExist(clerk.getIdentity(), "identity"))
            addFieldError("identity", "该身份证已被注册！");
        if(!clerk.getIdentity().matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)"))
            addFieldError("identity", "身份证格式出错！");


        //业务员手机号
        if(clerkSvc.isExist(clerk.getPhone(), "phone"))
            addFieldError("phone", "该手机号已被注册！");


        //设置生日
        clerk.setBirthday(IdentityUtil.getBirthdayByIdentiy(clerk.getIdentity()));

        //设置薪资
        clerk.setSalary(1);

        //设置性别
        clerk.setSex('0');

        //设置工资卡
        clerk.setSalary_card("a123");
    }

}
