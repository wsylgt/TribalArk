<%--
  Created by IntelliJ IDEA.
  User: Kris2
  Date: 2016/8/25
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}'/>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="basePath" value='${pageContext.request.getContextPath()}'/>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">后台用户管理</h1>
    <ol class="breadcrumb">
      <li>后台用户管理</li>
      <li class="active"><a href="${basePath}/um/usermanage">用户管理</a></li>
      <li class="active">用户添加</li>
    </ol>
  </div>
</div>
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        <div class="row">
          <div class="col-lg-2"><h4>添加后台用户</h4></div>
          <div class="col-xs-10">
            <a class="btn btn-primary btn-sm pull-right" href="${basePath}/um/usermanage">
              <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回
            </a>
          </div>
        </div>
      </div>
      <div class="panel-body">
        <div class="panel">
          <div class="panel-body">
            <div class="div-center">
              <form:form id="addUserForm" class="form-horizontal adminex-form " modelAttribute="user" action="${basePath}/sys/usermanage/create/save" mothod="post">
                <!-- 隐藏域 -->
                <b>${status}</b>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">用户名</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名" value="${user.userName}">
                    <small class="help-block validate-error-span userName-ErrMsg"><form:errors path="userName"/></small>
                    <small class="help-block validate-error-span userName-ErrMsg" id="userName-ErrMsg"></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">登录密码</label>
                  <div class="col-lg-10">
                    <input type="password" class="form-control" name="password" placeholder="以字母开头，长度在8~20之间，只能包含字母、数字和下划线"
                           value="${user.password}">
                    <small class="help-block validate-error-span password-ErrMsg"><form:errors path="password"/></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">确认密码</label>
                  <div class="col-lg-10">
                    <input type="password" class="form-control" name="confirm_password" placeholder="以字母开头，长度在8~20之间，只能包含字母、数字和下划线"
                           value="${user.password}">
                    <small class="help-block validate-error-span confirm_password-ErrMsg"><form:errors path="confirm_password"/></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">Email地址</label>
                  <div class="col-lg-10">
                    <input type="email" class="form-control" name="email" placeholder="Email地址" value="${user.email}">
                    <small class="help-block validate-error-span email-ErrMsg"><form:errors path="email"/></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">联系电话</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="cellphoneNo" name="cellphoneNo" placeholder="联系电话" value="${user.cellphoneNo}">
                    <small class="help-block validate-error-span cellphoneNo-ErrMsg"><form:errors path="cellphoneNo"/></small>
                    <small class="help-block validate-error-span cellphoneNo-ErrMsg" id="cellphoneNo-ErrMsg"></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">QQ</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ号" value="${user.qq}">
                    <qq class="help-block validate-error-span qq-ErrMsg"><form:errors path="cellphoneNo"/></qq>
                    <small class="help-block validate-error-span qq-ErrMsg" id="qq-ErrMsg"></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">微信</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="wechat" name="wechat" placeholder="微信" value="${user.wechat}">
                    <small class="help-block validate-error-span wechat-ErrMsg"><form:errors path="wechat"/></small>
                    <small class="help-block validate-error-span wechat-ErrMsg" id="wechat-ErrMsg"></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">工号</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="employeeNo" name="employeeNo" placeholder="工号" value="${user.employeeNo}">
                    <small class="help-block validate-error-span employeeNo-ErrMsg"><form:errors path="wechat"/></small>
                    <small class="help-block validate-error-span employeeNo-ErrMsg" id="employeeNo-ErrMsg"></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">所在部门</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="department" name="department" placeholder="所在部门" value="${user.department}">
                    <small class="help-block validate-error-span department-ErrMsg"><form:errors path="department"/></small>
                    <small class="help-block validate-error-span department-ErrMsg" id="department-ErrMsg"></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">性别</label>
                  <div class="col-lg-10">
                    <small class="help-block validate-error-span password-ErrMsg"><form:errors path="password"/></small>
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">所属角色</label>
                  <div class="col-lg-10">
                  </div>
                </div>
                <div class="form-group form-group-sm">
                  <label class="col-lg-2 control-label">用户描述</label>
                  <div class="col-lg-10">
                    <textarea class="form-control" rows="3" style="resize:none;" name="userDescription"></textarea>
                    <small class="help-block validate-error-span userDescription-ErrMsg"><form:errors path="userDescription"/></small>
                  </div>
                </div>
                <br/>
                <div class="row text-right">
                  <ud:requestAuthority authorityKey="um_usermanage_saveuser_button">
                    <button type="submit" is-disabled class="btn btn-primary" >保存</button>
                  </ud:requestAuthority>
                </div>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="${basePath}/resource/js/sys/usermanage/create.js"></script>