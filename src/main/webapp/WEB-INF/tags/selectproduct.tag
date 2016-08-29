<%--
  DESCRIBE: 货品信息选择列表模态框画面

  Copyright 2016-2016
  VERSION : 1.0
  DATE    : 2016/05/10
  AUTHOR  : 金成明
  HISTORY : 2016/05/10 begin
--%>
<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 参数 --%>
<%@attribute name="setProductNoControlId" required="true" type="java.lang.String" %><!-- 货品编号 -->
<%@attribute name="setPruductNameControlId" required="true" type="java.lang.String" %><!-- 货品名称 -->
<%@attribute name="setSpecificationNameControlId" required="false" type="java.lang.String" %><!-- 规格 TODO -->
<%@attribute name="setPruductBrandNameControlId" required="false" type="java.lang.String" %><!-- 品牌 TODO -->
<%@attribute name="setPruductBarcodeControlId" required="false" type="java.lang.String" %><!-- 条形码 -->
<%@attribute name="setPruductUnitCodeNameControlId" required="false" type="java.lang.String" %><!-- 计量单位 TODO -->
<%@attribute name="setProductTransStoWayNameControlId" required="false" type="java.lang.String" %><!-- 运输存储方式 -->
<%@attribute name="setPruductStockNumControlId" required="false" type="java.lang.String" %><!-- 库存 TODO -->
<%@attribute name="setPruductLockedStockNormalNumControlId" required="false" type="java.lang.String" %><!-- 锁仓库存 TODO -->
<%@attribute name="setPruductOnWayNumControlId" required="false" type="java.lang.String" %><!-- 在途库存 TODO -->
<%@attribute name="setPruductSupplierNameControlId" required="false" type="java.lang.String" %><!-- 供应商 TODO -->
<c:set var="productModalBasePath" value='${pageContext.request.getContextPath()}' />

<%-- 总页码 --%>
<input type="hidden" id="setProductNoControlId" value="${setProductNoControlId}"/>
<input type="hidden" id="setPruductNameControlId" value="${setPruductNameControlId}"/>
<input type="hidden" id="setSpecificationNameControlId" value="${setSpecificationNameControlId}"/>
<input type="hidden" id="setPruductBrandNameControlId" value="${setPruductBrandNameControlId}"/>
<input type="hidden" id="setPruductBarcodeControlId" value="${setPruductBarcodeControlId}"/>
<input type="hidden" id="setPruductUnitCodeNameControlId" value="${setPruductUnitCodeNameControlId}"/>
<input type="hidden" id="setProductTransStoWayNameControlId" value="${setProductTransStoWayNameControlId}"/>
<input type="hidden" id="setPruductStockNumControlId" value="${setPruductStockNumControlId}"/>
<input type="hidden" id="setPruductLockedStockNormalNumControlId" value="${setPruductLockedStockNormalNumControlId}"/>
<input type="hidden" id="setPruductOnWayNumControlId" value="${setPruductOnWayNumControlId}"/>
<input type="hidden" id="setPruductSupplierNameControlId" value="${setPruductSupplierNameControlId}"/>
<input type="hidden" id="productModalBasePath" value="${productModalBasePath}"/>

<div class="modal fade" id="selectProductModal" tabindex="-1" role="dialog" aria-labelledby="selectProductModalLabel">
  <div class="modal-dialog" role="document" style="width: 70%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="selectProductModalLabel">选择货品</h4>
      </div>
      <div class="modal-body">
        <div class="row">
            <div class="col-lg-12">
                <div class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row" style="margin-bottom: -10px;">
                            <div class="col-lg-3">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="productNoModal" style="padding-left: 0px;">货品编号：</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="productNoModal" name="productNoModal" value="" maxlength="20" tabindex="200">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="productNameModal" style="padding-left: 0px;">货品名称：</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="productNameModal" name="productNameModal" value="" maxlength="40" tabindex="210">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="form-group form-group-sm">
                                    <label class="col-lg-3 control-label" for="pruductBarcodeModal" style="padding-left: 0px;">条形码：</label>
                                    <div class="col-lg-9" style="padding-left: 0px;">
                                        <input type="text" class="form-control" id="pruductBarcodeModal" name="pruductBarcodeModal" value="" maxlength="40" tabindex="210">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-primary btn-sm" id="btnSearchProductInfo" tabindex="220">查询</button>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive" style="max-height:400px; overflow-y:auto;">
                            <table Id="productTable" class="table table-bordered table-condensed table-striped-extension table-hover-extension">
                                <thead>
                                    <tr class="emall">
                                        <th class="text-center">选择</th>
                                        <th class="text-center">货品编号</th>
                                        <th class="text-center">货品名称</th>
                                        <th class="text-center">规格</th>
                                        <th class="text-center">品牌</th>
                                        <th class="text-center">条形码</th>
                                        <th class="text-center">计量单位</th>
                                        <th class="text-center">运输存储方式</th>
                                        <th class="text-center">库存</th>
                                        <th class="text-center">锁仓库存</th>
                                        <th class="text-center">在途库存</th>
                                        <th class="text-center">供应商</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="row text-center">
                        <button id="btnSelectProductModal" type="button" class="btn btn-primary btn-sm" data-dismiss="modal">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>
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

<script src="${productModalBasePath}/resource/js/gm/product/select-product.js"></script>

