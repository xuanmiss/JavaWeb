package service.salaryStandard;

import dao.ISalaryStandardDBAccessor;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

/**
 * Created by Administrator on 2017/5/13/013.
 */
@Service
public class SalaryStandardHandleSvc implements ISalaryStandardHandleSvc  {
    @Autowired
    private ISalaryStandardDBAccessor salaryStandardAcc;

    @Override
    public void save(SalaryStandard salaryStandard) {
        salaryStandardAcc.insert(salaryStandard);
    }

    @Override
    public PageBean<SalaryStandard> getListByPage(int pageNo) {
        PageBean<SalaryStandard> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(salaryStandardAcc.getCount(SalaryStandard.class));
        pageBean.setData(salaryStandardAcc.getListByPage(SalaryStandard.class, pageNo, pageBean.getRowsPerPage()));
        return pageBean;
    }

    @Override
    public void update(SalaryStandard salaryStandard) {
        salaryStandardAcc.update(salaryStandard);
    }

    @Override
    public SalaryStandard findById(Integer id) {
        return (SalaryStandard) salaryStandardAcc.findByID(id);
    }

    @Override
    public boolean delete(Integer id, Class<SalaryStandard> salaryStandardClass) {
        return salaryStandardAcc.delete(id, salaryStandardClass);
    }


}
