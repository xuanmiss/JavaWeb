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

    var curPage:Int=0
        set(pageNo){
            if(pageNo<1)
                field=1
            else
                field=pageNo
        }

    var maxPage:Int=0
        private set(value){field=value}

    var maxRowCount=0
        set(count){
            maxPage=count/rowsPerPage
            if(count%rowsPerPage>0)
                maxPage++
            if(curPage>maxPage)
                curPage=maxPage
            field=count
        }

    val rowsPerPage=10

    lateinit var data:List<T>
}