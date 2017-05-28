package service.clerk;

import entity.Clerk;
import entity.Client;
import util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface IClerkHandleSvc {

    boolean isExist(String value, String property);
    PageBean<Clerk> getListByPage(int pageNo);
    void saveClerk(Clerk clerk);
    void deleteById(int id);
    Clerk findById(int id);
    List<Clerk> getListClerkofAll();
}
