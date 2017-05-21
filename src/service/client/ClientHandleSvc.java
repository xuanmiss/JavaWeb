package service.client;

import dao.ClientDBAccessor;
import dao.IClerk_ClientDBAccessor;
import dao.IClientDBAccessor;
import entity.Clerk;
import entity.Clerk_Client;
import entity.Client;
import util.PageBean;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by miss on 2017/5/16.
 */
@Service("clientHandler")
public class ClientHandleSvc implements IClientHandleSvc{


        @Autowired
        private IClientDBAccessor clientAcc;

        @Autowired
        private IClerk_ClientDBAccessor clerk_clientAcc;

        @Override
        public boolean isExist(String value, String property){
            return clientAcc.isExist(value,property);
        }

        @Override
        public void saveClient(Client client) {


            clientAcc.insert(client);
        }

        @Override
        public void updateClient(Client client) {
            clientAcc.update(client);
        }

        @Override
        public boolean deleteClient(int clientId) {
            Client client = findById(clientId);
                clientAcc.delete(client);
                return true;

        }

        @Override
        public PageBean<Client> getListByPage(int pageNo){
            PageBean<Client> pb=new PageBean<>();
            pb.setCurPage(pageNo);
            pb.setMaxRowCount(clientAcc.getCount(Client.class));
            pb.setData(clientAcc.getListByPage(Client.class,pageNo,pb.getRowsPerPage()));
            return pb;
        }

        @Override
        public String getClientName(int id) {
            return clientAcc.getClientName(id);
        }

        @Override
        public Client findById(int id) {
            return clientAcc.getObj(Client.class,id);
        }
}
