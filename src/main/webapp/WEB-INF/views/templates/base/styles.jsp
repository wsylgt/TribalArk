<%-- 
  DESCRIBE  : 项目整体CSS引用
  VERSION   : 1.0
  DATE      : 2016/4/16
  AUTHOR    : kris
  HISTORY   : 2016/4/16 begin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}' />
<!--icheck-->
<link href="${basePath}/resource/js/iCheck/skins/minimal/minimal.css" rel="stylesheet">
<link href="${basePath}/resource/js/iCheck/skins/square/square.css" rel="stylesheet">
<link href="${basePath}/resource/js/iCheck/skins/square/red.css" rel="stylesheet">
<link href="${basePath}/resource/js/iCheck/skins/square/blue.css" rel="stylesheet">

<!--dashboard calendar-->
<link href="${basePath}/resource/css/clndr.css" rel="stylesheet">

<!--Morris Chart CSS -->
<link rel="stylesheet" href="${basePath}/resource/js/morris-chart/morris.css">

<!--common-->
<link href="${basePath}/resource/css/style.css" rel="stylesheet">
<link href="${basePath}/resource/css/style-responsive.css" rel="stylesheet">