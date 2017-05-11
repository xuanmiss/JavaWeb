package util

/**
 * Created by ymcvalu on 2017/4/21.
 */
/**
 * 分页数据包装
 * curPage：当前页
 * maxRowCount：数据表中记录数
 * maxPage：总页数，由maxRowCount自动计算
 * rowsPerPage：每页记录数，固定值
 * date：填充分页数据
 */
class PageBean<T>{
    //默认初始为第一页
    var curPage:Int=1
        set(pageNo){
            //校正页数，首页为第一页
            if(pageNo<1)
                //field：属性域
                field=1
            else
                field=pageNo
        }

    var maxPage:Int=0
        private set(value){
            field=value
            //校正当前页
            if(curPage>field)
                curPage=field
        }

    var maxRowCount=0
        set(count){
            //计算总页数
            var pages=count/rowsPerPage
            if(count%rowsPerPage>0)
                pages++
            //设置总页数
            maxPage=pages
            field=count
        }

    val rowsPerPage=12

    var data:List<T>?=null
}