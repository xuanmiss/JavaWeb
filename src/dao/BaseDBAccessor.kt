package dao

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.Resource

/**
 * Created by ymcvalu on 2017/5/4.
 */

/**
 * 所有dao都应继承该类
 */
open class BaseDBAccessor<T> : IBaseDBAccessor<T>{
    //自动注入session工厂
    @Autowired
    override var sessionFac: SessionFactory? =null

    //获取session
    override fun getSession(): Session=sessionFac!!.currentSession

    /**
     * 插入对象
     * @param t 要插入对象
     * @return void
     */
    override fun insert(t: T) {
        getSession()!!.saveOrUpdate(t)
    }

    /**
     * 删除指定类的指定id的记录
     * @param id 要删除的记录主键
     * @param clazz 记录对应的entity.class
     * @return void
     */

    override fun delete(id: Int, clazz: Class<T>):Boolean {
        delete(getObj(clazz,id))
        getSession().clear()
        return getObj(clazz,id)==null
    }

    /**
     * 删除指定对象记录
     * @param t 要删除的对象
     * @return void
     */
    override fun delete(t: T) {
        getSession().delete(t)
    }

    /**
     * 获取指定类型的记录数
     * @param clazz 指定类型
     * @return 记录数
     */
    override fun getCount(clazz: Class<T>): Int {
        return (getSession().createQuery("select count(*) from ${clazz.simpleName}")
                .uniqueResult() as Long).toInt()

    }

    /**
     * 更新指定对象
     * @param t 要更新的记录
     * @return void
     */
    override fun update(t: T) {
       getSession().update(t)
    }

    /**
     * 分页查找
     * @param clazz 记录类型
     * @param pageNo 页号
     * @param rows 每页行数
     * @return 返回list
     */
    override fun getListByPage(clazz: Class<T>, pageNo: Int, rows: Int): List<T>
            = getSession().createQuery("from ${clazz.simpleName}")
            .setFirstResult((pageNo-1)*rows)
            .setMaxResults(rows)
            .list() as List<T>

    /**
     * 获取指定记录
     * @param clazz 指定类型
     * @param id 指定id
     * @return 返回记录对象
     */
    override fun getObj(clazz: Class<T>, id: Int): T = getSession().get(clazz,id) as T

}