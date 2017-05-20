package test.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.brand.BrandHandleSvc;

/**
 * Created by ymcvalu on 2017/5/20.
 */
@Component("brandTest")
@Scope("prototype")
public class BrandTest {
    public static void main(String[]args){
        ApplicationContext context=new ClassPathXmlApplicationContext("/test/test.xml");
        BrandTest bt=context.getBean("brandTest",BrandTest.class);
    }

    @Autowired
    private BrandHandleSvc brandSvc;
    public void test(){
        brandSvc.getListByPage(1).getData().forEach((it)->{
            System.out.println(it.getName());
        });
    }



}
