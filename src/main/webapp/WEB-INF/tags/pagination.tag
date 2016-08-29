<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 分页的Page --%>
<%@attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@attribute name="eventName" required="true" type="java.lang.String" %>
<%@attribute name="showPageCnt" required="true" type="java.lang.Integer" %>
<%@attribute name="callBackFunction" required="false" type="java.lang.String" %>

<%-- 总页码 --%>
<c:set var="totalPages" value="${page.totalPages}" />
<%-- 当前页 --%>
<c:set var="pagenum" value="${page.number + 1 }" />
<%-- 表示页码索引件数 --%>
<c:set var="showPageCnt" value="${showPageCnt}" />

<%-- 当前页码大于总页码的时候 --%>
<c:if test="${pagenum gt totalPages}">
    <c:set var="pagenum" value="${totalPages}" />
</c:if>

<%-- 表示页码索引件数 --%>
<c:set var="midPage" value="${Integer.valueOf(showPageCnt / 2)}" />
<%-- 余数 --%>
<c:set var="midMod" value="${showPageCnt mod 2}" />
<c:if test="${midMod ne 0}">
    <c:set var="midPage" value="${midPage + 1}" />
</c:if>

<%-- 前置页码件数 --%>
<c:set var="beforePageCount" value="${midPage - 1}" />
<%-- 后置页码件数 --%>
<c:set var="afterPageCount" value="${showPageCnt - midPage}" />

<%-- 开始页码 --%>
<c:set var="begin" value="${1}" />
<%-- 结束页码 --%>
<c:set var="end" value="${1}" />

<%-- 当前页码小于等于中间页码的时候 --%>
<c:if test="${pagenum le midPage}" >
    <%-- 总页码小于等于示页码索引件数的时候 --%>
    <c:if test="${totalPages le showPageCnt}" >
        <%-- 结束页码 --%>
        <c:set var="end" value="${totalPages}" />
    </c:if>
    <%-- 总页码大于示页码索引件数的时候 --%>
    <c:if test="${totalPages gt showPageCnt}" >
        <%-- 结束页码 --%>
        <c:set var="end" value="${showPageCnt}" />
    </c:if>
</c:if>
<%-- 当前页码小于等于中间页码的时候 --%>
<c:if test="${pagenum gt midPage}" >
    <%-- 后置实际页数 --%>
    <c:set var="afterRealPage" value="${totalPages - pagenum}" />
    <%-- 后置实际页数 大于等于 后置页码件数 --%>
    <c:if test="${afterRealPage ge afterPageCount}" >
        <%-- 开始页码 --%>
        <c:set var="begin" value="${pagenum - beforePageCount}" />
        <%-- 结束页码 --%>
        <c:set var="end" value="${pagenum + afterPageCount}" />
    </c:if>
    <%-- 后置实际页数 小于 后置页码件数 --%>
    <c:if test="${afterRealPage lt afterPageCount}" >
        <%-- 开始页码 --%>
        <c:set var="begin" value="${pagenum - beforePageCount - (afterPageCount - afterRealPage)}" />
        <%-- 结束页码 --%>
        <c:set var="end" value="${totalPages}" />
        <%-- 开始页码小于1的时候 --%>
        <c:if test="${begin lt 1}" >
            <%-- 开始页码 --%>
            <c:set var="begin" value="${1}" />
        </c:if>
    </c:if>
</c:if>

<c:if test="${page.totalPages gt 0}">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-right">

            <nav>
                <ul class="pagination">

                    <c:if test="${page.hasPrevious() == true}">
                        <li>
                            <a href="javascript:void(0)" aria-label="首页" onclick="fnPageTurning(this, 0)">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${page.hasPrevious() != true}">
                        <li class="disabled">
                            <a href="javascript:void(0)" aria-label="首页">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach begin="${begin}" end="${end}" step="1" varStatus="idx">
                        <c:if test="${idx.index eq pagenum}">
                            <li class="active" >
                                <a href="javascript:void(0)">${idx.index}<span class="sr-only">(current)</span></a>
                            </li>
                        </c:if>
                        <c:if test="${idx.index ne pagenum}">
                            <li>
                                <a href="javascript:void(0)" onclick="fnPageTurning(this,${idx.index - 1 })">${idx.index}</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${page.hasNext() == true}">
                        <li>
                            <a href="javascript:void(0)" aria-label="末页"  onclick="fnPageTurning(this,${totalPages - 1})">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${page.hasNext() != true}">
                        <li class="disabled">
                            <a href="javascript:void(0)" aria-label="末页">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><span>共${page.totalElements}件 / 共${totalPages}页</span></li>
                </ul>
            </nav>
        </div>
    </div>

    <script type="text/javascript">
        var fnPageTurning = function (propLabel, pageNumber) {

            // 回调函数
            var callBackFunction = "${callBackFunction}";
            
            // 有回调函数的时候
            if (callBackFunction) {
                
                // 执行回调函数
                var returnValue = eval(callBackFunction);
                
                // 回调函数返回值是false的时候
                if (!returnValue) {
                    return;
                }
            }
            
            var eventName = "${eventName}";
            var form = $(propLabel).parents("form");
            var url = form.attr("action");
            /* url包含？的舍弃？之后的参数*/
            if(url.indexOf("?") != -1){
            	url = url.substring(0,url.indexOf("?"));
            	/* 若后缀以eventName？参数结尾，舍弃eventName之后的数据 */
            	if(url.indexOf(eventName) != -1){
            		url = url.substring(0,url.lastIndexOf("/")+1);
            	}
            }        
            /* 若后缀以eventName结尾表示已是正确路径 */
            if (url.indexOf(eventName) != -1 && url.indexOf(eventName) == (url.length - eventName.length)) {
                return;
            }
            /* 组合正确的action属性值：根路径/controller类路径/方法路径 */
            var toForm = url + eventName + "?pageNumber=" + pageNumber;
            /* 给action属性赋值，全路径 */
            form.attr("action", toForm);
            form.find(":submit").click();
        };

    </script>

</c:if>

