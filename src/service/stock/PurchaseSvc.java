package service.stock;

import com.opensymphony.xwork2.ActionContext;
import dao.IBaseDBAccessor;
import dao.IPurchaseOrderDBAccessor;
import dao.OrderDBAccessor;
import dao.PurchaseDBAccessor;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
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


    @Autowired
    private IBaseDBAccessor<Object> baseDBAccessor;
    @Override
    public boolean addPurchaseOrder(Purchase_Order po) {
        try{
            Model m=(Model) baseDBAccessor.getObj(Model.class,po.getModel().getId());
            po.setAmount(m.getIn_price()*po.getQuantity());
            Clerk c=new Clerk();
            c.setId((Integer) ActionContext.getContext().getSession().get("clerk"));
            po.setClerk(c);
            po.setDate(new Date());
            SimpleDateFormat df=new SimpleDateFormat("yyMMdd");
            String orderNo="11"+df.format(po.getDate());
            String str=((Long)System.currentTimeMillis()).toString().substring(8);
            po.setOrder_no(orderNo+str);
            po.setType(1);
            baseDBAccessor.insert(po);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Autowired
    private IPurchaseOrderDBAccessor ipoAcc;
    @Override
    public PageBean<Purchase_Order> getUndoPurchaseOrders(int pageNo) {
        PageBean<Purchase_Order> pageBean=new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(ipoAcc.countOfUndoPurchase());
        List<Purchase_Order> list=ipoAcc.getUndoPurchaseByPage(pageNo,pageBean.getRowsPerPage());
        pageBean.setData(list);
        return pageBean;
    }


    @Override
    public void inWarehouse(Purchase purchase) {
        //新建批次
        Batch batch=new Batch();
        //获取对应的进货申请单
        Purchase_Order order=ipoAcc.getOrderByOrderNo(purchase.getOrder().getOrder_no());
        //设置已经入库
        order.setType(order.getType()+1);
        //设置批次号
        batch.setBatch_no(purchase.getBatch().getBatch_no());
        //设置入库日期
        batch.setDate(new Date());
        //设置入库型号
        batch.setModel(order.getModel());
        //保存批次信息
        baseDBAccessor.insert(batch);
        //设置入库单
        purchase.setOrder(order);
        purchase.setBatch(batch);
        Clerk c=new Clerk();
        c.setId((Integer) ActionContext.getContext().getSession().get("clerk"));
        purchase.setClerk(c);
        //保存入库单
        baseDBAccessor.insert(purchase);

    }
}
