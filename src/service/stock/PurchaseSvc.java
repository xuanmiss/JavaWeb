package service.stock;

import dao.PurchaseDBAccessor;
import entity.Batch;
import entity.Clerk;
import entity.Order;
import entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.List;

/**
 * Created by LCQ on 2017/5/23.
 */
@Service
public class PurchaseSvc implements IPurchaseSvc {
    @Autowired
    private PurchaseDBAccessor purchaseDBAccessor;
    /**
     * 获取所有purchase表信息
     * */
    public PageBean<Purchase> getAll(int pageNo){
        PageBean<Purchase> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(purchaseDBAccessor.getCount(Purchase.class));
        pageBean.setData(purchaseDBAccessor.getListByPage(Purchase.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }
    /**
     * 表单下拉栏数据支持
     **/
    public List<Batch> getAllBatch(){
        List<Batch> batchList= purchaseDBAccessor.getBatchList();
        /*for(int i=0 ; i<batchList.size() ;i++){
            System.out.println(batchList.get(i));
        }*/
        return batchList;
    }
    public  List<Clerk> getAllClerk(){
       List<Clerk> clerkList = purchaseDBAccessor.getClerkList();
       /* for(int i=0 ; i<clerkList.size() ;i++){
            System.out.println(clerkList.get(i));
        }*/
       return clerkList;
    }
    public List<Order> getAllOrder(){
        List<Order> orderList = purchaseDBAccessor.getOrderList();
        /*for(int i=0 ; i<orderList.size() ;i++){
            System.out.println(orderList.get(i));
        }*/
        return  orderList;
    }
    /**
     * 新增记录
     * */
    public void savePurchase(Purchase purchase){
        purchaseDBAccessor.getSession().save(purchase);
    }

    /**
     * 清除记录*/
    public void remove(int id){
        purchaseDBAccessor.remove(id);
    }

    /**
     * 按id查询相应记录
     * */
   /* public Batch getBatchById(int batchId){
        return purchaseDBAccessor.findBatchById(batchId);
    }
    public Clerk getClerkById(int clerkId){
        return purchaseDBAccessor.findClerkById(clerkId);
    }
    public Order getOrderById(int orderId){
        return purchaseDBAccessor.findOrderById(orderId);
    }*/

}
