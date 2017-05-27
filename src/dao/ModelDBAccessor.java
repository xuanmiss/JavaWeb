package dao;

import entity.Model;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenshihong on 2017/5/7.
 */

@Repository

public class ModelDBAccessor extends BaseDBAccessor<Model> implements IModelDBAccessor {
    @Override
    public List<Model> getListByPage(int brand, int pageNo,int rows) {
        return (List<Model>)getSession().createQuery("from entity.Model as m where m.brand=?1")
                .setInteger("1",brand)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public Model getModelById(int brand, int id) {
        return (Model)getSession().createQuery("from entity.Model as m where m.brand =?1 and m.id=?2")
                .setInteger("1",brand)
                .setInteger("2",id)
                .uniqueResult();
    }

    @Override
    public boolean isExist(String model,int brandId) {
        return (long)getSession().createQuery("select count(*) from entity.Model as m where m.model = ?1 and m.brand= ?2")
                .setString("1",model)
                .setInteger("2",brandId)
                .uniqueResult()>0;
    }

    @Override
    public List<Model> getListofAll() {
        return (List<Model>)getSession().createQuery("from entity.Model")
                .list();
    }

    @Override
    public int getModelCountByBrand(int brandId) {
        return ((Long)getSession().createQuery("select count(*) from entity.Model as m where m.brand.id=?1")
                .setInteger("1",brandId)
                .uniqueResult()).intValue();
    }
}
