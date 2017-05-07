package dao;

import entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */

/**
 * 公司角色实现类
 * ...
 */

public class RoleDBAccessor extends BaseDBAccessor<Role> implements IRoleDBAccessor {
    /**
     * 声明新方法
     * ...
     */

    /**
     * 根据用户名查找Role
     * @return Role
     */
    public Role findByUserName(Object object){return null;};

    /**
     * 根据业务员ID查找Role
     * @return List<Shipment>
     */
    public Role findByClerk(Object object){return null;};
}
