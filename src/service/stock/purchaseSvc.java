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
 * Created by LCQ on 2017/5/21.
 */
@Service
public class PurchaseSvc implements IPurchaseSvc {
    @Autowired
    private PurchaseDBAccessor purchaseDBAccessor;
    /**
     * 获取全部入库信息的服务层支持，调用dao层数据库支持
     * */
    public PageBean<Purchase> getListByPage(int pageNo){
        PageBean<Purchase> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(purchaseDBAccessor.getCount(Purchase.class));
        pageBean.setData(purchaseDBAccessor.getListByPage(Purchase.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }
    /**
     * 提供表单列表数据支持
     **/
    public List<Batch> formBatchOption(){
        List<Batch> batchOption = purchaseDBAccessor.getBatchList();
        return batchOption;
    }
    public List<Clerk> formClerkOption(){
        List<Clerk> clerkOption = purchaseDBAccessor.getClerkList();
        return clerkOption;
    }
    public List<Order> formOrderOption(){
        List<Order> orderOption = purchaseDBAccessor.getOrderList();
        return orderOption;
    }
    /**
     * 新增入库记录
     **/
    public void savePurchase(Purchase purchase){
        purchaseDBAccessor.getSession().save(purchase);
    }


}
