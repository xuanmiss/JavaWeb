package service.finance;

import dao.BaseDBAccessor;
import dao.IArrearDBAccessor;
import entity.AccountFlow;
import entity.Arrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenshihong on 2017/5/28.
 */
@Service
public class ArrearHandleSvc extends BaseDBAccessor<Arrear> implements IArrearHandleSvc{
    @Autowired
    private IArrearDBAccessor arrearDBAcc;
    @Override
    public void deleteArrear(AccountFlow accountFlow) {
       arrearDBAcc.deleteArrear(accountFlow);
    }
}
