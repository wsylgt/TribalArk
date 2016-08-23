<%--
  Created by IntelliJ IDEA.
  User: kris
  Date: 2016/8/23
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}'/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>500 Page</title>

  <!-- style -->
  <link href="${basePath}/resource/css/style.css" rel="stylesheet">
  <link href="${basePath}/resource/css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="${basePath}/resource/plugin/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="${basePath}/resource/plugin/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="error-page">

<section>
  <div class="container ">

    <section class="error-wrapper text-center">
      <h1><img alt="" src="${basePath}/resource/images/500-error.png"></h1>
      <h2>OOOPS!!!</h2>
      <h3>Something went wrong.</h3>
      <p class="nrml-txt">Why not try refreshing you page? Or you can <a href="#">contact our support</a> if the problem
        persists.</p>
      <a class="back-btn" href="${basePath}/index.html"> Back To Home</a>
    </section>

  </div>
</section>

<!-- Placed js at the end of the document so the pages load faster -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${basePath}/resource/plugin/jquery/1.12.3/jquery-1.12.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${basePath}/resource/plugin/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- 用于检测用户浏览器的 HTML5 与 CSS3 特性 -->
<script src="${basePath}/resource/plugin/modernizr/2.8.3/modernizr.custom.min.js"></script>


<!--common scripts for all pages-->
<!--<script src="js/scripts.js"></script>-->

</body>
</html>