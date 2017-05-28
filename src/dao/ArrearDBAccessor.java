package dao;

import entity.AccountFlow;
import entity.Arrear;
import entity.Clerk;
import entity.Purchase_Order;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by miss on 2017/5/6.
 */

/**
 * 客户白条实现类
 */
@Repository("arrearDBAcc")
@Lazy
public class ArrearDBAccessor extends BaseDBAccessor<Arrear> implements IArrearDBAccessor {
    /**
     * 声明新方法
     * ...
     *
     * @param accountFlow
     */
    @Override
    public void deleteArrear(AccountFlow accountFlow) {
        delete(accountFlow.getOrder_no(),Arrear.class);
    }
    /**
     * 在这里实现新方法...
     */
}
