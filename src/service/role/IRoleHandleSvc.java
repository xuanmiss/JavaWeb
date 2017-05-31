package service.role;

import entity.Role;

/**
 * Created by Administrator on 2017/5/30.
 */
public interface IRoleHandleSvc {
    void save(Role role);
    void deleteById(int id);
    boolean isExist(String value, String property);
    Role findByClerk(int id);
}
