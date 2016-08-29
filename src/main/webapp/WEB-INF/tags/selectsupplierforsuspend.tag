<%--
  DESCRIBE: 供应商信息选择列表模态框画面[采购订单列表-已挂起标签页]

  Copyright 2016-2016
  VERSION : 1.0
  DATE    : 2016/05/28
  AUTHOR  : 金成明
  HISTORY : 2016/05/28 begin
--%>
<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 参数 --%>
<%@attribute name="supplierDeleteFlagModalForSuspend" required="false" type="java.lang.String" %>
<%@attribute name="supplierIdControlIdForSuspend" required="true" type="java.lang.String" %>
<%@attribute name="supplierNameControlIdForSuspend" required="true" type="java.lang.String" %>
<%@attribute name="supplierContactPersonNameControlIdForSuspend" required="false" type="java.lang.String" %>
<%@attribute name="supplierContactMobilePhoneNoControlIdForSuspend" required="false" type="java.lang.String" %>
<%@attribute name="supplierContactFixedPhoneNoControlIdForSuspend" required="false" type="java.lang.String" %>
<c:set var="supplierModalBasePath" value='${pageContext.request.getContextPath()}' />

<%-- 总页码 --%>
<input type="hidden" id="supplierDeleteFlagModalForSuspendForSuspend" value="${supplierDeleteFlagModal}"/>
<input type="hidden" id="supplierIdControlIdForSuspend" value="${supplierIdControlIdForSuspend}"/>
<input type="hidden" id="supplierNameControlIdForSuspend" value="${supplierNameControlIdForSuspend}"/>
<input type="hidden" id="supplierContactPersonNameControlIdForSuspend" value="${supplierContactPersonNameControlIdForSuspend}"/>
<input type="hidden" id="supplierContactMobilePhoneNoControlIdForSuspend" value="${supplierContactMobilePhoneNoControlIdForSuspend}"/>
<input type="hidden" id="supplierContactFixedPhoneNoControlIdForSuspend" value="${supplierContactFixedPhoneNoControlIdForSuspend}"/>
<input type="hidden" id="supplierModalBasePath" value="${supplierModalBasePath}"/>

<div class="modal fade" id="selectSupplierModalForSuspend" tabindex="-1" role="dialog" aria-labelledby="selectSupplierModalLabel">
  <div class="modal-dialog" role="document" style="width: 70%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="selectSupplierModalLabel">选择供应商</h4>
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
                                    <label class="col-lg-3 control-label" for="supplierNoModal" style="padding-left: 0px;">供应商编号：</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="supplierNoModalForSuspend" name="supplierNoModal" value="" maxlength="20" tabindex="200">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="supplierNameModal" style="padding-left: 0px;">供应商名称：</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="supplierNameModalForSuspend" name="supplierNameModal" value="" maxlength="40" tabindex="210">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-primary btn-sm" id="btnSearchSupplierInfoForSuspend" tabindex="220">查询</button>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive" style="max-height:400px; overflow-y:auto;">
                            <table Id="supplierTableForSuspend" class="table table-bordered table-condensed table-striped-extension table-hover-extension">
                                <thead>
                                    <tr class="emall">
                                        <th class="text-center select-rdo-modal-width">选择</th>
                                        <th class="text-center storehouse-no-modal-width">供应商编号</th>
                                        <th class="text-center storehouse-name-modal-width">供应商名称</th>
                                        <th class="text-center delete-flag-name-modal-width">供应商类型</th>
                                        <th class="text-center storehouse-type-name-modal-width">供应商结算类型</th>
                                        <th class="text-center ownership-type-name-modal-width">供应商状态</th>
                                        <th class="text-center">法人姓名</th>
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
                        <button id="btnSelectSupplierModalForSuspend" type="button" class="btn btn-primary btn-sm" data-dismiss="modal">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>
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

<script src="${supplierModalBasePath}/resource/js/pur/supplier/select-supplier-for-suspend.js"></script>

