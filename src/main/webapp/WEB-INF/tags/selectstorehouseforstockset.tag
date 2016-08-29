<%--
  DESCRIBE: 仓库信息选择[设置警戒/标准库存]模态框画面

  Copyright 2016-2016
  VERSION : 1.0
  DATE    : 2016-06-16
  AUTHOR  : 金成明
  HISTORY : 2016-06-16 begin
--%>
<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 参数 --%>
<%@attribute name="storehouseDeleteFlagModalForStock" required="false" type="java.lang.String" %>
<%@attribute name="setStorehouseIdControlIdForStock" required="true" type="java.lang.String" %>
<%@attribute name="setStorehouseNameControlIdForStock" required="true" type="java.lang.String" %>
<%@attribute name="setStorehouseAddressControlIdForStock" required="false" type="java.lang.String" %>
<%@attribute name="setStorehouseContactPersonNameControlIdForStock" required="false" type="java.lang.String" %>
<%@attribute name="setStorehouseContactMobilePhoneNoControlIdForStock" required="false" type="java.lang.String" %>
<%@attribute name="setStorehouseContactFixedPhoneNoControlIdForStock" required="false" type="java.lang.String" %>
<%@attribute name="setStorehouseOwnershipTypeNameControlIdForStock" required="false" type="java.lang.String" %>
<%@attribute name="setStorehouseOwnershipCompanyNameControlIdForStock" required="false" type="java.lang.String" %>
<%@attribute name="modalId" required="false" type="java.lang.String" %>
<c:set var="storehouseModalBasePath" value='${pageContext.request.getContextPath()}' />
<c:if test='${modalId == null || modalId == ""}'>
    <c:set var="modalId" value="selectStorehouseModal" />
</c:if>

<%-- 总页码 --%>
<input type="hidden" id="storehouseDeleteFlagModalForStock" value="${storehouseDeleteFlagModalForStock}"/>
<input type="hidden" id="setStorehouseIdControlIdForStock" value="${setStorehouseIdControlIdForStock}"/>
<input type="hidden" id="setStorehouseNameControlIdForStock" value="${setStorehouseNameControlIdForStock}"/>
<input type="hidden" id="setStorehouseAddressControlIdForStock" value="${setStorehouseAddressControlIdForStock}"/>
<input type="hidden" id="setStorehouseContactPersonNameControlIdForStock" value="${setStorehouseContactPersonNameControlIdForStock}"/>
<input type="hidden" id="setStorehouseContactMobilePhoneNoControlIdForStock" value="${setStorehouseContactMobilePhoneNoControlIdForStock}"/>
<input type="hidden" id="setStorehouseContactFixedPhoneNoControlIdForStock" value="${setStorehouseContactFixedPhoneNoControlIdForStock}"/>
<input type="hidden" id="setStorehouseOwnershipTypeNameControlIdForStock" value="${setStorehouseOwnershipTypeNameControlIdForStock}"/>
<input type="hidden" id="setStorehouseOwnershipCompanyNameControlIdForStock" value="${setStorehouseOwnershipCompanyNameControlIdForStock}"/>
<input type="hidden" id="storehouseModalBasePathForStock" value="${storehouseModalBasePathForStock}"/>

<div class="modal fade" id="${modalId}" tabindex="-1" role="dialog" aria-labelledby="selectStorehouseModalLabel">
  <div class="modal-dialog" role="document" style="width: 70%;">
    <div class="modal-content">
      <div class="modal-header modality-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="selectStorehouseModalLabel">选择仓库</h4>
      </div>
      <div class="modal-body">
        <div class="row">
            <div class="col-lg-12">
                <div class="form-horizontal">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row" style="margin-bottom: -10px;">
                                <div class="col-lg-4">
                                    <div class="form-group form-group-sm">
                                        <label class="col-lg-3 control-label" for="storehouseNoModalForStock" style="padding-left: 0px;">仓库编号：</label>
                                        <div class="col-lg-9" style="padding-left: 0px;">
                                            <input type="text" class="form-control" id="storehouseNoModalForStock" name="storehouseNoModalForStock" value="" maxlength="20" tabindex="200">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group form-group-sm">
                                        <label class="col-lg-3 control-label" for="storehouseNameModalForStock" style="padding-left: 0px;">仓库名称：</label>
                                        <div class="col-lg-9" style="padding-left: 0px;">
                                            <input type="text" class="form-control" id="storehouseNameModalForStock" name="storehouseNameModalForStock" value="" maxlength="40" tabindex="210">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <button type="button" class="btn btn-primary btn-sm" id="btnSearchStorehouseInfoForStock" tabindex="220">查询</button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive" style="max-height:400px; overflow-y:auto;">
                                <table Id="storehouseTableForStock" class="table table-bordered table-condensed table-striped-extension table-hover-extension">
                                    <thead>
                                        <tr class="emall">
                                            <th class="text-center select-rdo-modal-width">选择</th>
                                            <th class="text-center storehouse-no-modal-width">仓库编号</th>
                                            <th class="text-center storehouse-name-modal-width">仓库名称</th>
                                            <th class="text-center delete-flag-name-modal-width">仓库状态</th>
                                            <th class="text-center storehouse-type-name-modal-width">仓库类型</th>
                                            <th class="text-center ownership-type-name-modal-width">仓库归属类型</th>
                                            <th class="text-center">仓库归属公司</th>
                                            <th class="text-center contact-person-name-modal-width">联系人姓名</th>
                                            <th class="text-center contact-mobile-phoneNo-modal-width">手机号</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="row text-center">
                                <button id="btnSelectStorehouseModalForStock" type="button" class="btn btn-primary btn-sm" data-dismiss="modal">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>
                                <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal" style="margin-left: 30px;">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>

<link href="${storehouseModalBasePath}/resource/css/sm/storehousemanage/storehouse-select.css" rel="stylesheet">
<script src="${storehouseModalBasePath}/resource/js/sm/storehousemanage/storehouse-select-for-stock.js"></script>

