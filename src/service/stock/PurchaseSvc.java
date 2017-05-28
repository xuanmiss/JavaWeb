package service.stock;

import dao.PurchaseDBAccessor;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.List;

/**
 * Created by LCQ on 2017/5/23.
 */
@Service
public class PurchaseSvc implements IPurchaseSvc {
    @Override
    public boolean addPurchaseOrder(Purchase_Order po) {
        return false;
    }
}
