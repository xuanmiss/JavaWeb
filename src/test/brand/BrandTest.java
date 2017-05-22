package test.brand;

import dao.IOrderDBAccessor;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.brand.BrandHandleSvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymcvalu on 2017/5/20.
 */
@Component("brandTest")
@Scope("prototype")
public class BrandTest {
    public static void main(String[]args){
        //bean工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("/test/test.xml");
        //获取bean
        BrandTest bt=context.getBean("brandTest",BrandTest.class);
        bt.test();
    }

    //注入依赖
    @Autowired
    private IOrderDBAccessor orderDBAccessor;
    public void test(){

        List list=orderDBAccessor.undoneOrders(1,2);
        System.out.println(list.size());
        list.forEach((it)->{
            Object[] obj=(Object[])it;
            System.out.println(((Object[]) it).length);
            System.out.println(obj[obj.length-1]);

        });
    }
}
