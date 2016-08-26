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
</head>
<body class="sticky-header">

<section>

  <!-- left side start-->
  <div class="left-side sticky-left-side">
    <tiles:insertAttribute name="left-side" ignore="true"/>
  </div>
  <!-- left side end-->

  <!-- main content start-->
  <div class="main-content">

    <!-- header section start-->
    <div class="header-section">
      <tiles:insertAttribute name="header-section" ignore="true"/>
    </div>
    <!-- header section end-->

    <!-- page heading start-->
    <div class="page-heading">
      Page Tittle goes here
    </div>
    <!-- page heading end-->

    <!--body wrapper start-->
    <div class="wrapper">
      <tiles:insertAttribute name="body-contents" ignore="true"/>
    </div>
    <!--body wrapper end-->

    <!--footer section start-->
    <footer class="sticky-footer">
      <tiles:insertAttribute name="sticky-footer" ignore="true"/>
    </footer>
    <!--footer section end-->


  </div>
  <!-- main content end-->

</section>
</body>
</html>