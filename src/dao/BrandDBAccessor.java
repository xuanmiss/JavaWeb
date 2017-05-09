package dao;

import entity.Brand;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2017/5/7/007.
 */
@Repository("brandDbAcc")
public class BrandDBAccessor extends BaseDBAccessor<Brand> implements IBrandDBAccessor {
    @Override
    public boolean isExist(String name) {
        return (long)getSession().createQuery("select count(*) from entity.Brand as b where b.name = ?1")
                .setString("1",name)
                .uniqueResult()>0;
    }
}
