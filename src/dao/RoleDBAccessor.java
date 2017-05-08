package dao;

import entity.Clerk;
import entity.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */

/**
 * 公司角色实现类
 * ...
 */

@Repository("roleDBAcc")
public class RoleDBAccessor extends BaseDBAccessor<Role> implements IRoleDBAccessor {
    /**
     * 声明新方法
     * ...
     */

    /**
     * 根据用户名查找Role
     * @return Role
     */
    public List<Role> findByUserName(Object object){return null;}

    /**
     * 根据业务员ID查找Role
     * @return List<Shipment>
     */
    public Role findByClerk(Object object){return null;}


    @Override
    public Role loggingCheck(String username, String password) {
        Session session=getSession();
        return (Role)session.createQuery("from entity.Role as r where r.username = ?1 and r.password = ?2")
                .setString("1",username)
                .setString("2",password)
                .uniqueResult();

    }
}
