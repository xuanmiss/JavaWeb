package service.login;

import entity.Role;

/**
 * Created by ymcvalu on 2017/5/8.
 */
public interface ILoginHandler {
    Role handler(String username,String password);
}
