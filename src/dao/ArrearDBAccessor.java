package dao;

import entity.Arrear;
import entity.Clerk;
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
     * 在这里实现新方法...
     */
}
