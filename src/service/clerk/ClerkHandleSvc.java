package service.clerk;

import dao.IClerkDBAccessor;
import entity.Clerk;
import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service("clerkHandler")
public class ClerkHandleSvc implements IClerkHandleSvc {
    @Autowired
    private IClerkDBAccessor clerkDBAccessor;

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
        PageBean<Clerk> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(clerkDBAccessor.getCount(Clerk.class));
        pb.setData(clerkDBAccessor.getListByPage(Clerk.class,pageNo,pb.getRowsPerPage()));
        return pb;
    }

    @Override
    public boolean isExist(String value, String property){
        return clerkDBAccessor.isExist(value, property);
    }

    @Override
    public Clerk findById(int id) {
        return clerkDBAccessor.getObj(Clerk.class,id);
    }


}
