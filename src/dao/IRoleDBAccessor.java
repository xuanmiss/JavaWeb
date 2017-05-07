package dao;

import entity.Role;

/**
 * Created by Administrator on 2017/5/7.
 */

/**
 * 公司角色接口
 */
public interface IRoleDBAccessor extends IBaseDBAccessor<Role> {

    /**
     * 声明新方法
     * ...
     */

    /**
     * 根据用户名查找Role
     * @return List<Role>
     */
    Role findByUserName(Object object);

    /**
     * 根据业务员ID查找Role
     * @return List<Role>
     */
    Role findByClerk(Object object);


}
