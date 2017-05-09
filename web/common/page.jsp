<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page  pageEncoding="utf-8"%>
<script>
function gotoPage(pagenum){
  document.pageForm.pageNo.value = pagenum;
  document.pageForm.submit();
  return ;
}
</script>

<!--使用分页功能，必须在action内提供pageBean-->
<form action="/fund/select.action" method="post" name="pageForm">
    第<s:property value="pageBean.curPage"/>页
    共<s:property value="pageBean.maxPage"/>页
    <BR />
    <s:if test="pageBean.curPage==1">
        "首页 上一页"
    </s:if>
    <s:else>
        <a href="javascript:gotoPage(1)">首页</A>
        <a href="javascript:gotoPage(<s:property value="pageBean.curPage-1"/> )">上一页</a>
    </s:else>
    <s:if test="pageBean.curPage==pageBean.maxPage">
        下一页 尾页
    </s:if>
    <s:else>
        <a href="javascript:gotoPage(<s:property value="pageBean.curPage+1"/>)">下一页</a>
        <a href="javascript:gotoPage(<s:property value="pageBean.maxPage"/>)">尾页</a>
    </s:else>
    转到第<input type="text" name="pageNo" style="width:50px;"/>页
    <input type="submit" value="提交">
</form>

 