package service.brand;

import dao.IBrandDBAccessor;
import entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ymcvalu on 2017/5/9.
 */
@Service("brandHandler")
public class HandleBrandSvc implements IHandleBrandSvc{
    @Autowired
    private IBrandDBAccessor brandDBAccessor;
    @Override
    public boolean isExist(String name) {
        return brandDBAccessor.isExist(name);
    }

    @Override
    public void saveBrand(Brand brand) {
        brandDBAccessor.insert(brand);
    }
}
