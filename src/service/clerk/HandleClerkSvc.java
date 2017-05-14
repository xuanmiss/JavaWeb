package service.clerk;

import dao.ClerkDBAccessor;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service("clerkHandler")
public class HandleClerkSvc implements IHandleClerkSvc{
    @Autowired
    private ClerkDBAccessor clerkDBAccessor;

    @Override
    public void deleteById(int id){
        clerkDBAccessor.deleteById(id);
    }

    @Override
    public void saveClerk(Clerk clerk){
        clerkDBAccessor.insert(clerk);
    }

    @Override
    public PageBean<Clerk> getListByPage(int pageNo){
        PageBean<Clerk> pageBean= new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(clerkDBAccessor.getCount(Clerk.class));
        pageBean.setData(clerkDBAccessor.getListByPage(Clerk.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }

    @Override
    public boolean isExist(String value, String property){
        return clerkDBAccessor.isExist(value, property);
    }

}
