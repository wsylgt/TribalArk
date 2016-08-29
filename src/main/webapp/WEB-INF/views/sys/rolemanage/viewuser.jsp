<%--
  DESCRIBE: 角色管理->查看用户页面

  Copyright 2016-2016 .
  VERSION : 1.0
  DATE  : 2016/05/16
  AUTHOR  : 王成龙
  HISTORY : 2016/05/16 begin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ud" uri="user-defined" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}'/>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header"><b>查看用户</b></h1>
    <ol class="breadcrumb">
      <li><b>用户管理</b></li>
      <li>
        <a href="${basePath}/um/rolemanage"><b>角色管理</b></a>
      </li>
      <li class="active">
        查看用户
      </li>
    </ol>
  </div>
</div>
<div class="row">
  <div class="col-lg-12">

    <div class="panel panel-default">
      <div class="panel-heading">
        <div class="row">
          <div class="col-md-2">属于角色【${roleInfo.roleName}】的用户列表</div>
          <input type="hidden" id="basePath" name="basePath" value="${basePath}"/>
          <input type="hidden" id="roleName" name="roleName" value="${roleInfo.roleName}"/>
          <div class="col-md-8">
            <form:form class="form-inline" id="form" modelAttribute="userModel"
                   action="${basePath}/um/rolemanage/searchuser">
              <input type="hidden" id="roleId" name="roleId" value="${roleInfo.roleId}"/>
              <div class="form-group form-group-sm">
                <label for="employeeNo">员工号：</label>
                <input type="text" class="form-control" id="employeeNo" name="employeeNo"
                     value="${employeeNo}" placeholder="员工号">&nbsp;&nbsp;
                <label for="userName">用户名：</label>
                <input type="text" class="form-control" id="userName" name="userName"
                     value="${userName}" placeholder="用户名">&nbsp;&nbsp;
                <ud:requestAuthority authorityKey="um_rolemanage_searchuser_button">
                  <button type="submit" is-disabled class="btn btn-primary btn-sm">搜&nbsp;&nbsp;索
                  </button>
                </ud:requestAuthority>
              </div>
            </form:form>
          </div>
          <div class="col-md-2 text-right">
            <a type="button" class="btn btn-primary btn-sm"
               href="${basePath}/um/rolemanage">返&nbsp;&nbsp;回</a>
          </div>
        </div>
      </div>
      <div class="panel-body">
        <div class="table-responsive">
          <table class="table table-bordered table-condensed table-hover-extension table-striped-extension">
            <thead>
            <tr class="emall">
              <th class="text-center">员工号</th>
              <th class="text-center">用户名</th>
              <th class="text-center">用户状态</th>
              <th class="text-center">员工性质</th>
              <th class="text-center">所属角色</th>
              <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
              <tr>
                <td class="text-center">${user.employeeNo}</td>
                <td class="text-center">${user.userName}</td>
                <td class="text-center">${user.userStatusName}</td>
                <td class="text-center">${user.userPropertyName}</td>
                <td class="text-center">${roleInfo.roleName}</td>
                <td class="text-center">
                  <ud:requestAuthority authorityKey="um_rolemanage_deleteuser_button">
                    <button type="button" class="btn btn-link btn-xs" is-disabled
                        onclick="fnDeleteUser(${user.userId});">删除
                    </button>
                  </ud:requestAuthority>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="${basePath}/resource/js/um/rolemanage/role-manage-delete-user.js"></script>
