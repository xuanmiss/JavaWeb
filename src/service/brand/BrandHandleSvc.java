package service.brand;

import dao.IBrandDBAccessor;
import entity.Brand;
import entity.Model;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.List;

/**
 * Created by ymcvalu on 2017/5/9.
 */
@Service("brandHandler")
public class BrandHandleSvc implements IBrandHandleSvc {
    @Autowired
    private IBrandDBAccessor brandAcc;
    @Override
    public boolean isExist(String name) {
        return brandAcc.isExist(name);
    }

    @Override
    public void saveBrand(Brand brand) {
        brandAcc.insert(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandAcc.update(brand);
    }

    @Override
    public boolean deleteBrand(int brandId) {;
        Brand brand = findById(brandId);
        if(brandAcc.isExitModel(brandId)==false) {
            brandAcc.delete(brand);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public PageBean<Brand> getListByPage(int pageNo){
        PageBean<Brand> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(brandAcc.getCount(Brand.class));
        pb.setData(brandAcc.getListByPage(Brand.class,pageNo,pb.getRowsPerPage()));
        return pb;
    }

    @Override
    public String getBrandName(int id) {
        return brandAcc.getBrandName(id);
    }

    @Override
    public Brand findById(int id) {
        return brandAcc.getObj(Brand.class,id);
    }
}
