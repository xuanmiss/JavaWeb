package service.login;

import dao.IRoleDBAccessor;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ymcvalu on 2017/5/8.
 */
@Service("loginSvc")
public class LoginHandler implements ILoginHandler {
    @Autowired
    private IRoleDBAccessor roleDBAccessor;
    @Override
    public Role handler(String username, String password) {
        return roleDBAccessor.loggingCheck(username,password);
    }

    public IRoleDBAccessor getRoleDBAccessor() {
        return roleDBAccessor;
    }

    public void setRoleDBAccessor(IRoleDBAccessor roleDBAccessor) {
        this.roleDBAccessor = roleDBAccessor;
    }
}
