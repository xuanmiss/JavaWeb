package test.brand;

import dao.IClientDBAccessor;
import dao.IOrderDBAccessor;
import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.brand.BrandHandleSvc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymcvalu on 2017/5/20.
 */
@Component("brandTest")
@Scope("prototype")
public class BrandTest {
    public static void main(String[]args) throws Exception {
        //bean工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("/test/test.xml");
        //获取bean
        BrandTest bt=context.getBean("brandTest",BrandTest.class);
        bt.test();



    }

    //注入依赖
    @Autowired
    private IOrderDBAccessor orderDBAccessor;
    @Autowired
    private IClientDBAccessor clientDBAccessor;
    public void test(){
        List<Client> list=clientDBAccessor.getClientsOfClerkByPage(1,12,2);
        list.forEach((it)->{
            System.out.println(it.getName());
        });


    }
}
