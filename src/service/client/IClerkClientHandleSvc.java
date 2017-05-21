package service.client;


import entity.Clerk_Client;

/**
 * Created by miss on 2017/5/21.
 */
public interface IClerkClientHandleSvc {
    void saveClerkClient(Clerk_Client clerkclient);
    void remove(Clerk_Client clerkclient);
}
