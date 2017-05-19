package dao;

import entity.SalaryStandard;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/7.
 */

/**
 * 公司基本薪金实现类
 * ...
 */
@Repository
public class SalaryStandardDBAccessor extends BaseDBAccessor<SalaryStandard> implements ISalaryStandardDBAccessor {
    /**
     * 声明新方法
     * ...
     */

    /**
     * 根据ID查找SalaryStandard
     * @return SalaryStandard
     */
    @Override
    public SalaryStandard findByID(Object object){
        return null;
    };
}
