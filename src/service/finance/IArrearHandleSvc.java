package service.finance;

import entity.AccountFlow;

/**
 * Created by chenshihong on 2017/5/28.
 */
public interface IArrearHandleSvc {
    void deleteArrear(AccountFlow accountFlow);
}
