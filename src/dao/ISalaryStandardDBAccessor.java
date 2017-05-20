package dao;

import entity.SalaryStandard;

/**
 * Created by Administrator on 2017/5/7.
 */

/**
 * 公司基本薪金接口
 * ...
 */

public interface ISalaryStandardDBAccessor extends IBaseDBAccessor<SalaryStandard> {
    /**
     * 声明新方法
     * ...
     */

    /**
     * 根据ID查找SalaryStandard
     * @return SalaryStandard
     */
    SalaryStandard findByID(Integer id);

}
