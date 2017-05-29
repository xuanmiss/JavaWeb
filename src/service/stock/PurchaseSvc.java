package service.stock;

import com.opensymphony.xwork2.ActionContext;
import dao.IBaseDBAccessor;
import dao.IPurchaseOrderDBAccessor;
import dao.PurchaseDBAccessor;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Service
public class PurchaseSvc implements IPurchaseSvc {
    @Autowired
    private PurchaseDBAccessor purchaseDBAccessor;
    /**
     * 获取所有purchase表信息
     * */
    public PageBean<Purchase> getListByPage(int pageNo){
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

    /**
     * 添加进货申请单
     * @param po
     * @return
     */
    @Override
    public boolean addPurchaseOrder(Purchase_Order po) {
        try{
            //查找型号
            Model m=(Model) baseDBAccessor.getObj(Model.class,po.getModel().getId());
            //设置总金额
            po.setAmount(m.getIn_price()*po.getQuantity());

            Clerk c=new Clerk();
            //从session中获取当前业务员
            c.setId((Integer) ActionContext.getContext().getSession().get("clerk"));
            //设置申请人
            po.setClerk(c);
            //设置日期
            po.setDate(new Date());
            //日期格式
            SimpleDateFormat df=new SimpleDateFormat("yyMMdd");
            /**
             * order_no: 11+yyMMdd+currentTimetMills.toString().substring(8)
             */
            String orderNo="11"+df.format(po.getDate());
            String str=((Long)System.currentTimeMillis()).toString().substring(8);
            //设置order_no
            po.setOrder_no(orderNo+str);
            //设置申请单类型
            po.setType(1);
            //插入申请单
            baseDBAccessor.insert(po);
        }catch (Exception e){
            //如果异常，申请失败
            return false;
        }
        //申请成功
        return true;
    }


    @Autowired
    private IPurchaseOrderDBAccessor ipoAcc;

    /**
     * 获取指定页码的未入库的申请单
     * @param pageNo
     * @return
     */
    @Override
    public PageBean<Purchase_Order> getUndoPurchaseOrders(int pageNo) {
        //创建PageBean
        PageBean<Purchase_Order> pageBean=new PageBean<>();
        //设置当前页码
        pageBean.setCurPage(pageNo);
        //设置总行数
        pageBean.setMaxRowCount(ipoAcc.countOfUndoPurchase());
        //从数据库中查找指定页码未入库的申请单
        List<Purchase_Order> list=ipoAcc.getUndoPurchaseByPage(pageNo,pageBean.getRowsPerPage());
        //封装数据
        pageBean.setData(list);
        return pageBean;
    }

    /**
     * 入库操作
     * @param purchase
     */

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
        //创建库存实体
        Stock stock=new Stock();
        //设置批次
        stock.setBatch(batch);
        //设置库存量
        stock.setCount(order.getQuantity());
        //保存库存
        baseDBAccessor.insert(stock);
    }

    /**
     * 取消入库申请单
     * @param po 要取消的申请单实体，内部应有order_no字段
     * @return 成功：true，失败：false
     */
    @Override
    public boolean cancelIn(Purchase_Order po) {
        //根据order_no查找指定的进货申请单
        po=ipoAcc.getOrderByOrderNo(po.getOrder_no());
        //如果未向厂家预付款项
        if(po.getType()==1){
            //删除
            ipoAcc.delete(po);
            return true;
        }
        else
            return false;
    }

}
