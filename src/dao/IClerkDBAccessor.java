package dao;

import entity.Clerk;

import java.util.List;


/**
 * Created by ymcvalu on 2017/5/4.
 */

/**
 * 员工表访问接口
 */
public interface IClerkDBAccessor extends IBaseDBAccessor<Clerk> {

    /**
     * 删除业务员对象
     * @param id 业务员ID
     */
    void deleteById(int id);

    /**
     * 判断是否存在
     * @param value 值
     * @param property 属性
     */
    boolean isExist(String value, String property);
    List<Clerk> getListClerkofAll();

}

