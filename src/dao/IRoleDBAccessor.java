package dao;

import entity.Clerk;
import entity.Role;

import java.util.List;

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
     * 根据用户名模糊查找Role
     * @return List<Role>
     */
    List<Role> findByUserName(Object object);

    /**
     * 根据业务员ID精确查找Role
     * @return Role
     */
    Role findByClerk(Object object);

    /**
     * 登陆校验
     * @param username 账户
     * @param password 密码
     * @return 如果验证成功则返回对应的业务员信息，否则返回null
     */
    Role loggingCheck(String username, String password);


}
