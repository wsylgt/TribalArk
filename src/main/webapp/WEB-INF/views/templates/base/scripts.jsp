<%-- 
  DESCRIBE  : 项目整体JS引用
  VERSION   : 1.0
  DATE      : 2016/4/16
  AUTHOR    : kris
  HISTORY   : 2016/4/16 begin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 常量引用 --%>
<%-- <jsp:include page="constant.jsp" /> --%>
<c:set var="basePath" value='${pageContext.request.getContextPath()}' />
<%-- jQuery文件。务必在bootstrap.min.js 之前引入 --%>
<script src="${basePath}/resource/js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->
<script src="${basePath}/resource/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${basePath}/resource/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${basePath}/resource/js/bootstrap.min.js"></script>
<script src="${basePath}/resource/js/modernizr.min.js"></script>
<script src="${basePath}/resource/js/jquery.nicescroll.js"></script>

<!--easy pie chart-->
<script src="${basePath}/resource/js/easypiechart/jquery.easypiechart.js"></script>
<script src="${basePath}/resource/js/easypiechart/easypiechart-init.js"></script>

<!--Sparkline Chart-->
<script src="${basePath}/resource/js/sparkline/jquery.sparkline.js"></script>
<script src="${basePath}/resource/js/sparkline/sparkline-init.js"></script>

<!--icheck -->
<script src="${basePath}/resource/js/iCheck/jquery.icheck.js"></script>
<script src="${basePath}/resource/js/icheck-init.js"></script>

<!-- jQuery Flot Chart-->
<script src="${basePath}/resource/js/flot-chart/jquery.flot.js"></script>
<script src="${basePath}/resource/js/flot-chart/jquery.flot.tooltip.js"></script>
<script src="${basePath}/resource/js/flot-chart/jquery.flot.resize.js"></script>


<!--Morris Chart-->
<script src="${basePath}/resource/js/morris-chart/morris.js"></script>
<script src="${basePath}/resource/js/morris-chart/raphael-min.js"></script>

<!--Calendar-->
<script src="${basePath}/resource/js/calendar/clndr.js"></script>
<script src="${basePath}/resource/js/calendar/evnt.calendar.init.js"></script>
<script src="${basePath}/resource/js/calendar/moment-2.2.1.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>

<!--common scripts for all pages-->
<script src="${basePath}/resource/js/scripts.js"></script>

<!--Dashboard Charts-->
<script src="${basePath}/resource/js/dashboard-chart-init.js"></script>

<%-- 动态form属性action改变 --%>
<script src="${basePath}/resource/js/base/global.js"></script>