<%--
  Created by IntelliJ IDEA.
  User: Kris2
  Date: 2016/8/24
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value='${pageContext.request.getContextPath()}' />

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">后台用户管理</h1>
    <ol class="breadcrumb">
      <li>用户管理</li>
      <li class="active">后台用户管理</li>
    </ol>
  </div>
</div>
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-body">
        <form:form class="form-inline" id="form" modelAttribute="userModel" action="${basePath}/sys/usermanage">
          <!-- 隐藏域,项目路径 -->
          <input type="hidden" id="basePath" value="${basePath}">
          <div class="form-group form-group-sm">
            <label for="employeeNo"><b>员工号：</b></label>
            <input type="text" class="form-control" id="employeeNo" name="employeeNo" value="${employeeNo}" placeholder="客户ID">
          </div>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="form-group form-group-sm">
            <label for="userName"><b>用户名：</b></label>
            <input type="text" class="form-control" id="userName" name="userName" value="${userName}" placeholder="客户名">
          </div>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="form-group form-group-sm">
            <label for="roleId"><b>角色：</b></label>
            <select class="form-control text-center" id="roleId" name="roleId">
              <option value="0" selected="selected">全部</option>
              <c:forEach items="${roleModelList}" var="roleModel">
                <option value="${roleModel.roleId}" <c:if test="${roleId == roleModel.roleId}">selected="selected"</c:if>>
                    ${roleModel.roleName}
                </option>
              </c:forEach>
            </select>
          </div>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="form-group form-group-sm">
            <label for="isDelete"><b>是否删除：</b></label>
            <select class="form-control text-center" id="isDelete" name="isDelete">
              <option value="0" selected="selected">否</option>
              <option value="1" <c:if test="${isDelete == 1}">selected="selected"</c:if>>是</option>
            </select>
          </div>&nbsp;&nbsp;&nbsp;&nbsp;
          <ud:requestAuthority authorityKey="um_usermanage_searchuser_button">
            <button type="submit" is-disabled class="btn btn-primary btn-sm">搜索</button>
          </ud:requestAuthority>
          <ud:requestAuthority authorityKey="um_usermanage_adduserview_link">
            <a class="btn btn-primary btn-sm pull-right is-disabled" href="${basePath}/um/usermanage/adduserview">添加用户
              <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            </a>
          </ud:requestAuthority>
          <hr/>
          <div class="table-responsive">
            <table class="table table-bordered table-condensed table-striped-extension table-hover-extension">
              <thead>
              <tr class="emall">
                <th class="text-center">员工号</th>
                <th class="text-center">用户名</th>
                <th class="text-center">联系电话</th>
                <th class="text-center">状态</th>
                <th class="text-center">员工性质</th>
                <th class="text-center">所属角色</th>
                <th class="text-center">加入时间</th>
                <th class="text-center">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${userModel.page.content}" var="userModel">
                <tr class="text-center">
                  <td>${userModel.employeeNo}</td>
                  <td>${userModel.userName}</td>
                  <td>${userModel.cellphoneNo}</td>
                  <td>
                    <c:forEach items="${userStatus.codeMasterList}" var="userStatus">
                      <c:if test="${userStatus.key == userModel.userStatusCodeId}">
                        <b>${userStatus.value}</b>
                      </c:if>
                    </c:forEach>
                  </td>
                  <td>
                    <c:forEach items="${userProperty.codeMasterList}" var="userProperty">
                      <c:if test="${userProperty.key == userModel.userPropertyCodeId}">
                        ${userProperty.value}
                      </c:if>
                    </c:forEach>
                  </td>
                  <td>
                    <c:forEach items="${roleModelList}" var="roleModel">
                      <c:forEach items="${userModel.roleIdSet}" var="roleId">
                        <c:if test="${roleModel.roleId == roleId}">
                          &#60;${roleModel.roleName}&#62;
                        </c:if>
                      </c:forEach>
                    </c:forEach>
                  </td>
                  <td>
                    <fmt:formatDate value="${userModel.createTime}" pattern="yyyy-MM-dd HH:mm:ss" var="createTime"/>
                      ${createTime}
                  </td>
                  <td>
                    <c:if test="${userModel.userStatusCodeId == 001}">
                      <ud:requestAuthority authorityKey="um_usermanage_recoveryaccount_button">
                        <c:if test="${userModel.isDelete == 0}">
                          <button type="button" is-disabled class="btn btn-link btn-xs" onclick="fnRecoveryAccount(${userModel.userId})">恢复</button>
                        </c:if>
                      </ud:requestAuthority>
                    </c:if>
                    <c:if test="${userModel.userStatusCodeId == 002}">
                      <ud:requestAuthority authorityKey="um_usermanage_freezeaccount_button">
                        <c:if test="${userModel.isDelete == 0}">
                          <button type="button" is-disabled class="btn btn-link btn-xs" onclick="fnFreezeAccount(${userModel.userId})">冻结</button>
                        </c:if>
                      </ud:requestAuthority>
                    </c:if>
                    <ud:requestAuthority authorityKey="um_useroperationlog_index_link">
                      <a type="button" class="btn btn-link btn-xs is-disabled"
                         href="${basePath}/um/useroperationlog/index?userName=${userModel.userName}">查看日志</a>
                    </ud:requestAuthority>
                    <ud:requestAuthority authorityKey="um_usermanage_userdetailview_link">
                      <a type="button" class="btn btn-link btn-xs is-disabled"
                         href="${basePath}/um/usermanage/userdetailview?userId=${userModel.userId}">详细</a>
                    </ud:requestAuthority>
                    <ud:requestAuthority authorityKey="um_usermanage_deleteuser_button">
                      <c:if test="${userModel.isDelete == 0}">
                        <button type="button" is-disabled class="btn btn-link btn-xs" onclick="fnDeleteUser(${userModel.userId})">删除</button>
                      </c:if>
                    </ud:requestAuthority>
                    <ud:requestAuthority authorityKey="um_usermanage_recoveryuser_button">
                      <c:if test="${userModel.isDelete == 1}">
                        <button type="button" is-disabled class="btn btn-link btn-xs" onclick="fnRecoveryUser(${userModel.userId})">恢复</button>
                      </c:if>
                    </ud:requestAuthority>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
          <tages:pagination page="${userModel.page}" eventName="/index" showPageCnt="5"/>
        </form:form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="${basePath}/resource/js/um/usermanage/user-manage-list.js"></script>