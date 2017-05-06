package dao;

import entity.Client;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


/**
 * Created by ymcvalu on 2017/5/6.
 */
@Repository("clientDBAcc")
@Lazy
public class ClientDBAccessor extends BaseDBAccessor<Client> implements IClientDBAccessor  {

}
