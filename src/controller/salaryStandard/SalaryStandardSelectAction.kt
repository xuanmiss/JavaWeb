package controller.salaryStandard

import com.opensymphony.xwork2.ActionSupport
import entity.SalaryStandard
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import service.salaryStandard.ISalaryStandardHandleSvc
import util.PageBean

/**
 * Created by Administrator on 2017/5/14/014.
 */
@Controller("selectSalaryStandard")
@Scope("prototype")
open class SalaryStandardSelectAction: ActionSupport() {
    @Autowired
    private lateinit var salaryStandardSvc: ISalaryStandardHandleSvc
    open var pageBean: PageBean<SalaryStandard>?=null
    open var pageNo:Int=1
    override fun execute(): String {
        pageBean=salaryStandardSvc.getListByPage(pageNo)
        return SUCCESS
    }
}