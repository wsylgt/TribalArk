<%--
  DESCRIBE: 设置警戒/标准库存模态框画面

  Copyright 2016-2016
  VERSION : 1.0
  DATE    : 2016-06-15
  AUTHOR  : 金成明
  HISTORY : 2016-06-15 begin
--%>
<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="tages" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ud" uri="user-defined" %>

<%-- 参数 --%>
<c:set var="supplierModalBasePath" value='${pageContext.request.getContextPath()}' />

<%-- 总页码 --%>
<input type="hidden" id="supplierModalBasePath" value="${supplierModalBasePath}"/>





<div class="modal fade" id="btnSetStockNumModal" tabindex="-1" role="dialog" aria-labelledby="setStockNumModalLabel" style="z-index:1049;">
  <div class="modal-dialog" role="document" style="width: 40%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="setStockNumModalLabel">设置警戒/标准库存</h4>
      </div>
      <div class="modal-body">
        <div class="row">
            <div class="col-lg-12">
                <div class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <div class="col-lg-12" style="padding-left: 0px;">
                                        <span>※ 警戒库存数：库存数小于等于该值时，库存信息报警。<br/>※ 标准库存数：库存数应该达到的数值。
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="alert alert-danger alert-dismissible sum-err-msg <c:if test="${status == null || status.code eq '0'}">hidden</c:if>" role="alert">
                                    <p>${status.message}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="panel-body">
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="storehouseNameForStock" >仓库</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="storehouseNameForStock" name="storehouseNameForStock" value="${conditionInfo.storehouseName}" readonly="readonly" tabindex="104">
                                            <input type="hidden" id="storehouseIdForStock" name="storehouseIdForStock" value="${conditionInfo.storehouseId}">
                                            <span class="input-group-addon" name="clearStorehouseInfo">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </span>
                                            <span class="input-group-btn">
                                                <ud:requestAuthority authorityKey="sm_instoremanage_instoreorderlist_select_storehouse_button">
                                                    <button type="button" is-disabled class="btn btn-primary btn-sm" id="btnSelectStoreHouse" data-toggle="modal" data-target="#selectStorehouseForStock" tabindex="106">选择</button>
                                                </ud:requestAuthority>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="supplierNoModal" style="padding-left: 0px;">设置范围</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="radio" name="rangeSetting" value="全部货品" checked="checked" />全部货品 
                                        <input type="radio" name="rangeSetting" value="单个货品" />单个货品
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="storehouseName">货品</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="productNameOnModal" name="productNameOnModal" value="${conditionInfo.storehouseName}" readonly="readonly" tabindex="104">
                                            <input type="hidden" id="productIdOnModal" name="productIdOnModal" value="${conditionInfo.storehouseId}">
                                            <span class="input-group-addon" name="clearProductInfo">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </span>
                                            <span class="input-group-btn">
                                                <ud:requestAuthority authorityKey="sm_instoremanage_instoreorderlist_select_storehouse_button">
                                                    <button type="button" is-disabled class="btn btn-primary btn-sm" id="btnSelectProduct" data-toggle="modal" data-target="#selectProductModal" tabindex="106" disabled="disabled">选择</button>
                                                </ud:requestAuthority>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="warningStockNum" style="padding-left: 0px;">警戒库存数</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="warningStockNum" name="warningStockNum" value="" tabindex="200">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="standardStockNum" style="padding-left: 0px;">标准库存数</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="standardStockNum" name="standardStockNum" value="" tabindex="200">
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <div class="panel-footer">
                        <div class="row text-center">
                        <button id="btnSaveModal" type="button" class="btn btn-primary btn-sm" data-dismiss="modal">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
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

<tages:selectstorehouseforstockset storehouseDeleteFlagModalForStock="" 
    setStorehouseIdControlIdForStock="storehouseIdForStock" 
    setStorehouseNameControlIdForStock="storehouseNameForStock"
    setStorehouseAddressControlIdForStock=""
    setStorehouseContactPersonNameControlIdForStock=""
    setStorehouseContactMobilePhoneNoControlIdForStock=""
    setStorehouseContactFixedPhoneNoControlIdForStock=""
    setStorehouseOwnershipTypeNameControlIdForStock=""
    setStorehouseOwnershipCompanyNameControlIdForStock=""
    modalId="selectStorehouseForStock"
    />

<!-- 货品信息回填jsp页面 -->
<tages:selectproductbystorehouseid setProductNoControlId="productIdOnModal" 
    setPruductNameControlId="productNameOnModal"
    setSpecificationNameControlId="warningStockNum" 
    setPruductBrandNameControlId="standardStockNum"
    setPruductBarcodeControlId="" 
    setPruductUnitCodeNameControlId=""
    setProductTransStoWayNameControlId="" 
    setPruductStockNumControlId=""
    setPruductLockedStockNormalNumControlId=""
    setPruductOnWayNumControlId="" 
    setPruductSupplierNameControlId="" />

<script src="${supplierModalBasePath}/resource/js/sm/inventorymanage/inventory-setting.js"></script>

