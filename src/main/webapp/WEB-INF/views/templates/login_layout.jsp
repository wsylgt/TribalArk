<%-- 
  DESCRIBE  : 项目整体login_layout模板
  VERSION   : 1.0
  DATE      : 2016/4/16
  AUTHOR    : kris
  HISTORY   : 2016/4/16 begin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}' />
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <tiles:insertAttribute name="metas" ignore="true"/>
        <title><tiles:insertAttribute name="title" ignore="true"/></title>
        <tiles:insertAttribute name="styles" ignore="true"/>
        <tiles:insertAttribute name="scripts" ignore="true"/>
    </head>
<body>
    <div class="jumbotron">
        <div class="container">
            <tiles:insertAttribute name="container" ignore="true"/>
        </div>
    </div>
</body>
</html>