<%-- 
  DESCRIBE  : 项目整体CSS引用
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

<!-- Bootstrap Core CSS -->
<link href="${basePath}/resource/plugin/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${basePath}/resource/plugin/metisMenu/1.1.3/css/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${basePath}/resource/plugin/sb-admin/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${basePath}/resource/plugin/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- Custom css -->
<link href="${basePath}/resource/css/style.css" rel="stylesheet" type="text/css">

<%--  bootstrapValidator验证	 --%>
<link href="${basePath}/resource/plugin/bootstrapvalidator/css/bootstrapValidator.css" rel="stylesheet" />