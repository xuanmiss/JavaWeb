package service.role;

import dao.IRoleDBAccessor;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/30.
 */
@Service("roleHandler")
public class RoleHandleSvc implements IRoleHandleSvc{
    @Autowired
    private IRoleDBAccessor roleDBAccessor;

    @Override
    public void save(Role role){
        roleDBAccessor.insert(role);
    }

    @Override
    public void deleteById(int id){
        roleDBAccessor.delete(id, Role.class);
    }

    @Override
    public boolean isExist(String value, String property){
        return roleDBAccessor.isExist(value, property);
    }

    @Override
    public Role findByClerk(int id){
        return roleDBAccessor.findByClerk(id);
    }
}
