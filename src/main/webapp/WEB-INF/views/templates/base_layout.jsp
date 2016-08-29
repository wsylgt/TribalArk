<%-- 
  DESCRIBE  : 项目整体base_layout模板
  VERSION   : 1.0
  DATE      : 2016/4/16
  AUTHOR    : kris
  HISTORY   : 2016/4/16 begin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}'/>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <tiles:insertAttribute name="metas" ignore="true"/>
  <title><tiles:insertAttribute name="title" ignore="true"/></title>
  <tiles:insertAttribute name="styles" ignore="true"/>
  <tiles:insertAttribute name="scripts" ignore="true"/>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>
<body>
<div id="wrapper">
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <tiles:insertAttribute name="navbar-header" ignore="true"/>
    <tiles:insertAttribute name="sidebar" ignore="true"/>
  </nav>

  <div id="page-wrapper">

    <tiles:insertAttribute name="body-contents" ignore="true"/>
    <footer>
      <%-- Footer ================================================== --%>
      <tiles:insertAttribute name="footer" ignore="true"/>
    </footer>
  </div>
</div>

</body>
</html>