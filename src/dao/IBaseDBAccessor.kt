package dao

import org.hibernate.Session
import org.hibernate.SessionFactory

/**
 * Created by ymcvalu on 2017/5/4.
 */
/**
 * 公共接口，所有dao的接口都应该继承该接口
 */
interface IBaseDBAccessor<T>{
    var sessionFac:SessionFactory?
    fun getSession():Session
    infix fun insert(t:T)
    fun delete(id:Int,clazz:Class<T>)
    infix fun delete(t:T)
    fun getCount(clazz:Class<T>):Int
    fun update(t:T)
    fun getListByPage(clazz:Class<T>,pageNo:Int,rows:Int):List<T>
    fun getObj(clazz:Class<T>,id:Int):T
}