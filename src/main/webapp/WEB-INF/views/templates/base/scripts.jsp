<%-- 
  DESCRIBE  : 项目整体JS引用
  VERSION   : 1.0
  DATE      : 2016/4/16
  AUTHOR    : kris
  HISTORY   : 2016/4/16 begin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 常量引用 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:include page="constant.jsp" /> --%>
<c:set var="basePath" value='${pageContext.request.getContextPath()}' />

<!-- jQuery -->
<script src="${basePath}/resource/plugin/jquery/1.12.3/jquery-1.12.3.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${basePath}/resource/plugin/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${basePath}/resource/plugin/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<%-- 验证的国际化支持	 --%>
<script src="${basePath}/resource/plugin/bootstrapvalidator/js/language/zh_CN.js"></script>


<!-- Metis Menu Plugin JavaScript -->
<script src="${basePath}/resource/plugin/metisMenu/1.1.3/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${basePath}/resource/plugin/sb-admin/js/sb-admin-2.min.js"></script>

<script src="${basePath}/resource/js/global.js"></script>
<script src="${basePath}/resource/js/common-message.js"></script>