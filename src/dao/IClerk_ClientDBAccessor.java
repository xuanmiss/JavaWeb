package dao;

import entity.Clerk_Client;

/**
 * Created by ymcvalu on 2017/5/6.
 */
public interface IClerk_ClientDBAccessor extends IBaseDBAccessor<Clerk_Client> {
    /**
     * 获取指定业务员和客户的合同主键
     * @param clerk
     * @param client
     * @return 如果存在返回主键，否则返回0
     */
     int getContractKey(int clerk,int client);
}
