<%--
  Created by IntelliJ IDEA.
  User: Kris2
  Date: 2016/8/26
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 常量引用 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:include page="constant.jsp" /> --%>
<c:set var="basePath" value='${pageContext.request.getContextPath()}' />

<div class="navbar navbar-default sidebar" role="navigation">
  <div class="sidebar-nav navbar-collapse">
    <ul class="nav" id="side-menu">
      <li class="sidebar-search">
        <div class="input-group custom-search-form">
          <input type="text" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
        </div>
        <!-- /input-group -->
      </li>
      <li>
        <a href="${basePath}/index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
      </li>

      <c:forEach items="${menuGroupList}" var="menusItem">
        <li>
          <a href="#">${menusItem.menuGroupName}<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <c:forEach items="${menusItem.menuList}" var="subMenu">
              <li>
                <c:set var="url" value="#"/>
                <c:if test="${subMenu.resourcesModel.resourceString != null
                                            && subMenu.resourcesModel.resourceString != ''}">
                  <c:set var="url" value="${basePath}${subMenu.resourcesModel.resourceString}"/>
                  <a href="${url}">${subMenu.menuName}</a>
                </c:if>
              </li>
            </c:forEach>
          </ul>
        </li>
      </c:forEach>
    </ul>
  </div>
  <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->