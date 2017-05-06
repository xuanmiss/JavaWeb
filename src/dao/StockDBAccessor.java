package dao;

import entity.Stock;
import org.hibernate.Session;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
@Repository("stockDBAcc")
@Lazy
public class StockDBAccessor extends BaseDBAccessor<Stock> implements IStockDBAccessor{


}
