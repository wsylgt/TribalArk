<%--
  DESCRIBE: 角色管理页面

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
        <h1 class="page-header"><b>角色管理</b></h1>
        <ol class="breadcrumb">
            <li><b>用户管理</b></li>
            <li class="active">角色管理</li>
        </ol>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">

        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-6">
                        系统角色列表
                        <input type="hidden" name="basePath" id="basePath" value="${basePath}"/>
                    </div>
                    <div class="col-xs-6 text-right">
                        <ud:requestAuthority authorityKey="um_rolemanage_addrole_button">
                            <button type="button" is-disabled class="btn btn-primary btn-xs" id="addRoleButton">添加角色
                            </button>
                        </ud:requestAuthority>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-condensed table-hover-extension table-striped-extension">
                        <thead>
                        <tr class="emall">
                            <th class="text-center">角色名称</th>
                            <th class="text-center">角色标识</th>
                            <th class="text-center">所属该角色人数</th>
                            <th class="text-center">角色描述</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${roleModelList}" var="role">
                            <tr>
                                <td class="text-center">${role.roleName}</td>
                                <td class="text-center">${role.roleMark}</td>
                                <td class="text-center">${role.userCount}</td>
                                <td>${role.roleDescription}</td>
                                <td class="text-center">
                                    <ud:requestAuthority authorityKey="um_rolemanage_viewuser_link">
                                        <a type="button" class="btn btn-link btn-xs is-disabled"
                                           href="${basePath}/um/rolemanage/viewuser?roleId=${role.roleId}">查看用户
                                        </a>
                                    </ud:requestAuthority>
                                    <ud:requestAuthority authorityKey="um_rolemanage_adduser_link">
                                        <a type="button" class="btn btn-link btn-xs is-disabled"
                                           href="${basePath}/um/rolemanage/adduser?roleId=${role.roleId}">添加用户</a>
                                    </ud:requestAuthority>

                                    <%--<ud:requestAuthority authorityKey="um_rolemanage_editrole_button">--%>
                                        <%--<button type="button" class="btn btn-link btn-xs editRoleButton"--%>
                                                <%--is-disabled roleId="${role.roleId}">编辑--%>
                                        <%--</button>--%>
                                    <%--</ud:requestAuthority>--%>
                                    <%--<ud:requestAuthority authorityKey="um_rolemanage_deleterole_button">--%>
                                        <%--<button type="button" class="btn btn-link btn-xs"--%>
                                                <%--is-disabled onclick="fnDeleteRole(${role.roleId});">删除--%>
                                        <%--</button>--%>
                                    <%--</ud:requestAuthority>--%>

                                    <c:choose>
                                        <c:when test="${role.roleName eq 'editorderaccredit'}">
                                                <button type="button" class="btn btn-link btn-xs editRoleButton"
                                                        disabled roleId="${role.roleId}">编辑
                                                </button>
                                                <button type="button" class="btn btn-link btn-xs"
                                                        disabled onclick="fnDeleteRole(${role.roleId});">删除
                                                </button>
                                        </c:when>
                                        <c:otherwise>
                                            <ud:requestAuthority authorityKey="um_rolemanage_editrole_button">
                                                <button type="button" class="btn btn-link btn-xs editRoleButton"
                                                        is-disabled roleId="${role.roleId}">编辑
                                                </button>
                                            </ud:requestAuthority>
                                            <ud:requestAuthority authorityKey="um_rolemanage_deleterole_button">
                                                <button type="button" class="btn btn-link btn-xs"
                                                        is-disabled onclick="fnDeleteRole(${role.roleId});">删除
                                                </button>
                                            </ud:requestAuthority>
                                        </c:otherwise>
                                    </c:choose>

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

<!-- 添加角色模态窗口 start -->
<div class="modal fade" id="addRoleModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header modality-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">添加角色</h5>
            </div>
            <form:form id="addRoleForm" modelAttribute="roleModel"
                       action="${basePath}/um/rolemanage/addrole" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>角色名</label>
                        <div class="form-group form-group-sm">
                            <input type="text" class="form-control" name="roleName" id="roleName">
                        </div>
                        <small class="help-block validate-error-span roleName-ErrMsg" id="roleName-ErrMsg">
                            <form:errors path="roleName"/></small>
                    </div>
                    <div class="form-group">
                        <label>角色描述</label>
                        <div class="form-group form-group-sm">
                            <textarea style="resize:none;" type="text" class="form-control"
                                      name="roleDescription"></textarea>
                        </div>
                        <small class="help-block validate-error-span roleDescription-ErrMsg"
                               id="roleDescription-ErrMsg">
                            <form:errors path="roleDescription"/></small>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="addRole">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<!-- 添加角色模态窗口 end -->

<!-- 编辑角色模态窗口 start -->
<div class="modal fade" id="editRoleModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header modality-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">编辑角色信息</h5>
            </div>
            <form:form id="editRoleForm" modelAttribute="roleModel"
                       action="${basePath}/um/rolemanage/editrole" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>角色名</label>
                        <input type="hidden" name="roleId" id="editRoleId"/>
                        <div class="form-group form-group-sm">
                            <input type="text" class="form-control" name="roleName" id="editRoleName">
                        </div>
                        <small class="help-block validate-error-span roleName-ErrMsg" id="editRoleName-ErrMsg">
                            <form:errors path="roleName"/></small>
                    </div>
                    <div class="form-group">
                        <label>角色描述</label>
                        <div class="form-group form-group-sm">
                            <textarea style="resize:none;" type="text" class="form-control" name="roleDescription"
                                      id="editRoleDescription"></textarea>
                        </div>
                        <small class="help-block validate-error-span roleDescription-ErrMsg">
                            <form:errors path="roleDescription"/></small>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="editRoleSubmit">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<!-- 编辑角色模态窗口 end -->
<script src="${basePath}/resource/js/um/rolemanage/role-manage.js"></script>

