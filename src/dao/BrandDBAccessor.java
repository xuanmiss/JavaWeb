package dao;

import entity.Brand;
import entity.Model;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    @Override
    public String getBrandName(int id) {
        return (String)getSession().createQuery("select b.name from entity.Brand as b where b.id = ?1")
                .setInteger("1",id)
                .uniqueResult();
    }

    @Override
    public Boolean isExitModel(int brandId) {;
        String hql = "from entity.Model as m where m.brand.id=?1";
        Session sess = getSession();
        List<Model> models = sess.createQuery(hql).setParameter("1",brandId).list();
        if(models.isEmpty())
            return false;
        else
            return true;
    }
}
