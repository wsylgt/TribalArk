<%--
  Created by IntelliJ IDEA.
  User: Kris2
  Date: 2016/8/24
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 常量引用 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:include page="constant.jsp" /> --%>
<c:set var="basePath" value='${pageContext.request.getContextPath()}'/>

<div class="row">
  <form role="form" class="form-signin" action="${basePath}/j_spring_security_check" method="post">
    <div class="form-signin-heading text-center">
      <h1 class="sign-title">登&nbsp;录</h1>
      <img src="${basePath}/resource/images/login-logo.png" alt=""/>
    </div>
    <div class="login-wrap">
      <input type="text" class="form-control" placeholder="User Name" name="username" autofocus>
      <input type="password" class="form-control" placeholder="Password" name="password">

      <button class="btn btn-lg btn-login btn-block" type="submit">
        <i class="fa fa-check"></i>
      </button>

      <div class="registration">
        没有账号吗?&nbsp;请联系管理人员。
      </div>
      <label class="checkbox">
        <input type="checkbox" name="_spring_security_remember_me" id="remember_me" value="remember-me"> Remember me
        <span class="pull-right">
          <a data-toggle="modal" href="#myModal"> 记不起密码了吗?</a>
        </span>
      </label>

    </div>

    <!-- Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal"
         class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title"> 记不起密码了吗 ?</h4>
          </div>
          <div class="modal-body">
            <p>Enter your e-mail address below to reset your password.</p>
            <input type="text" name="email" placeholder="Email" autocomplete="off"
                   class="form-control placeholder-no-fix">
          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
            <button class="btn btn-primary" type="button">Submit</button>
          </div>
        </div>
      </div>
    </div>
    <!-- modal -->

  </form>
</div>

