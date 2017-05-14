package service.clerk;

import entity.Clerk;
import util.PageBean;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface IHandleClerkSvc {

    boolean isExist(String value, String property);
    PageBean<Clerk> getListByPage(int pageNo);
    void saveClerk(Clerk clerk);
    void deleteById(int id);
}
