package service.pay

import dao.AccountDBAccessor
import entity.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by ymcvalu on 2017/5/26.
 */
@Service
class PayServer : IPayServer {
    @Autowired
    lateinit var accdb:AccountDBAccessor
    override fun pay(amount: Double) {
        var amt=accdb.getObj(Account::class.java,1)
        amt.flow+=amount
    }
}