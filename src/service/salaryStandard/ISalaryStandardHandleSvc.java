package service.salaryStandard;

import entity.SalaryStandard;
import util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/13/013.
 */
public interface ISalaryStandardHandleSvc {
    void save(SalaryStandard salaryStandard);

    PageBean<SalaryStandard> getListByPage(int pageNo);

    void update(SalaryStandard salaryStandard);

    SalaryStandard findById(Integer id);

    List<SalaryStandard> getAll();

    boolean delete(Integer id, Class<SalaryStandard> salaryStandardClass);
}
