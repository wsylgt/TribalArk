/** 
 * 编辑各编号共通方法类
 * <p>编辑各订单编号<br>
 * Copyright 2016-2016
 */
package com.emall.base.component;

import com.emall.util.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.emall.content.Constant;
import com.emall.util.StringUtil;

import java.util.Date;

/**
 * 编辑各编号共通方法类
 * <p>
 * 编辑各编号<br>
 * 
 * @author 金成明
 * @create Date 2016-05-17 Ver 1.0
 */
@Component
public class CodeNoEditManage {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(CodeNoEditManage.class);

    /**
     * 编辑采购订单编号
     * <p>
     * 前缀2位[PO]+系统日期6位[yyMMdd]+采购订单ID10位<br>
     * 
     * @param purOrderId
     *            采购订单ID
     * @param sysDate
     *            系统日期6位[yyMMdd]
     * @return 采购订单编号
     */
    public String editPurOrderNo(String purOrderId, String sysDate) {

        // 开始日志
        logger.debug("editPurOrderNo：编辑采购订单编号的拼接-----开始-----");

        // 采购订单编号
        StringBuilder sbPurOrderNo = new StringBuilder();

        // 设定采购订单编号前缀
        sbPurOrderNo.append(Constant.PUR_ORDER_NO_PRE);

        // 设定系统日期
        sbPurOrderNo.append(sysDate);

        // 采购订单ID的长度大于10的时候
        if (purOrderId.length() > 10) {
            sbPurOrderNo.append(purOrderId.substring(purOrderId.length() - 10, purOrderId.length()));
        } else {
            sbPurOrderNo.append(StringUtil.leftPadding(purOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editPurOrderNo：编辑采购订单编号的拼接-----结束-----");
        return sbPurOrderNo.toString();
    }

    /**
     * 编辑入库单编号
     * <p>
     * 前缀2位[SI]+系统日期6位[yyMMdd]+入库单ID10位<br>
     * 
     * @param inStoreOrderId
     *            入库单ID
     * @param sysDate
     *            系统日期6位[yyMMdd]
     * @return 入库单编号
     */
    public String editInStoreOrderNo(String inStoreOrderId, String sysDate) {

        // 开始日志
        logger.debug("editInStoreOrderNo：编辑入库单编号的拼接-----开始-----");

        // 入库单编号
        StringBuilder sbInStoreOrderNo = new StringBuilder();

        // 设定入库单编号前缀
        sbInStoreOrderNo.append(Constant.IN_STORE_ORDER_NO_PRE);

        // 设定系统日期
        sbInStoreOrderNo.append(sysDate);

        // 入库单ID的长度大于10的时候
        if (inStoreOrderId.length() > 10) {
            sbInStoreOrderNo.append(inStoreOrderId.substring(inStoreOrderId.length() - 10, inStoreOrderId.length()));
        } else {
            sbInStoreOrderNo.append(StringUtil.leftPadding(inStoreOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editInStoreOrderNo：编辑入库单编号的拼接-----结束-----");
        return sbInStoreOrderNo.toString();
    }

    /**
     * 编辑出库单编号
     * <p>
     * 前缀2位[SO]+系统日期6位[yyMMdd]+出库单ID10位<br>
     * 
     * @param outStoreOrderId
     *            出库单ID
     * @param sysDate
     *            系统日期6位[yyMMdd]
     * @return 出库单编号
     */
    public String editOutStoreOrderNo(String outStoreOrderId, String sysDate) {

        // 开始日志
        logger.debug("editOutStoreOrderNo：编辑出库单编号的拼接-----开始-----");

        // 出库单编号
        StringBuilder sbOutStoreOrderNo = new StringBuilder();

        // 设定出库单编号前缀
        sbOutStoreOrderNo.append(Constant.OUT_STORE_ORDER_NO_PRE);

        // 设定系统日期
        sbOutStoreOrderNo.append(sysDate);

        // 出库单ID的长度大于10的时候
        if (outStoreOrderId.length() > 10) {
            sbOutStoreOrderNo
                    .append(outStoreOrderId.substring(outStoreOrderId.length() - 10, outStoreOrderId.length()));
        } else {
            sbOutStoreOrderNo.append(StringUtil.leftPadding(outStoreOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editOutStoreOrderNo：编辑出库单编号的拼接-----结束-----");
        return sbOutStoreOrderNo.toString();
    }

    /**
     * 编辑调拨单编号
     * <p>
     * 前缀2位[AO]+系统日期6位[yyMMdd]+调拨单ID10位<br>
     * 
     * @param allocateOrderId
     *            调拨单ID
     * @param sysDate
     *            系统日期6位[yyMMdd]
     * @return 调拨单编号
     */
    public String editAllocateOrderNo(String allocateOrderId, String sysDate) {

        // 开始日志
        logger.debug("editAllocateOrderNo：编辑调拨单编号的拼接-----开始-----");

        // 调拨单编号
        StringBuilder sbAllocateOrderNo = new StringBuilder();

        // 设定调拨单编号前缀
        sbAllocateOrderNo.append(Constant.ALLOCATE_ORDER_NO_PRE);

        // 设定系统日期
        sbAllocateOrderNo.append(sysDate);

        // 调拨单ID的长度大于10的时候
        if (allocateOrderId.length() > 10) {
            sbAllocateOrderNo
                    .append(allocateOrderId.substring(allocateOrderId.length() - 10, allocateOrderId.length()));
        } else {
            sbAllocateOrderNo.append(StringUtil.leftPadding(allocateOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editAllocateOrderNo：编辑调拨单编号的拼接-----结束-----");
        return sbAllocateOrderNo.toString();
    }

    /**
     * 编辑盘点单编号
     * <p>
     * 前缀2位[IC]+盘点方式1位[1/2]+系统日期6位[yyMMdd]+盘点单ID10位<br>
     * 
     * @param inventoryCheckId
     *            盘点单ID
     * @param inventoryCheckWayCode
     *            盘点方式
     * @param sysDate
     *            系统日期6位[yyMMdd]
     * @return 盘点单编号
     */
    public String editInventoryCheckNo(String inventoryCheckId, String inventoryCheckWayCode, String sysDate) {

        // 开始日志
        logger.debug("editInventoryCheckNo：编辑盘点单编号的拼接-----开始-----");

        // 盘点单编号
        StringBuilder sbInventoryCheckNo = new StringBuilder();

        // 设定盘点单编号前缀
        sbInventoryCheckNo.append(Constant.INVENTORY_CHECK_NO_PRE);

        // 日常盘点的时候
        if (Constant.INVENTORY_CHECK_WAY_CODE_DAILY.equals(inventoryCheckWayCode)) {
            sbInventoryCheckNo.append(Constant.INVENTORY_CHECK_NO_WAY_DAILY);
        } else {
            sbInventoryCheckNo.append(Constant.INVENTORY_CHECK_NO_WAY_REGULAR);
        }

        // 设定系统日期
        sbInventoryCheckNo.append(sysDate);

        // 盘点单ID的长度大于10的时候
        if (inventoryCheckId.length() > 10) {
            sbInventoryCheckNo
                    .append(inventoryCheckId.substring(inventoryCheckId.length() - 10, inventoryCheckId.length()));
        } else {
            sbInventoryCheckNo.append(StringUtil.leftPadding(inventoryCheckId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editInventoryCheckNo：编辑盘点单编号的拼接-----结束-----");
        return sbInventoryCheckNo.toString();
    }

    /**
     * 编辑销售订单编号
     * <p>
     * 前缀3位[COM]+系统日期6位[yyMMdd]+用户区分1位[0,1]+订单区分1位[0,1]+订单id9位<br>
     * 前缀3位[COM]：customer order manage的缩写 系统日期6位[yyMMdd]：系统年的后两位+系统月+系统日
     * 客户类型1位[1，2]：1：普通客户 2：大客户 订单区分1位[0，1]：0：主订单 1：子订单 订单ID9位：订单ID的后9位
     * 前补0，大于9位，取订单id后9位
     * </p>
     * 
     * @param salesOrderId
     *            销售订单ID
     * @param sysDate
     *            系统日期
     * @return 销售订单编号
     */
    public String editSalesOrderNo(Long salesOrderId, Date sysDate, String customerType, String salesOrderType) {
        // 开始日志
        logger.debug("editInventoryCheckNo：编辑盘点单编号的拼接");
        // 销售订单编号
        StringBuilder salesOrderNo = new StringBuilder();
        // 前缀3位[COM]：customer order manage的缩写
        salesOrderNo.append(Constant.SALES_ORDER_NO_PRE);
        // 系统日期6位[yyMMdd]：系统年的后两位+系统月+系统日
        salesOrderNo.append(DateFormatUtils.formatDate(sysDate, DateFormatUtils.FORMAT_YYMMDD));
        // 用户区分1位[1，2，3]：1：注册会员，2：充值的客户会员，3：大客户
        salesOrderNo.append(customerType);
        // 订单区分1位[0，1]：0：主订单 1：子订单
        salesOrderNo.append(salesOrderType);
        // 订单ID9位：订单ID的后9位 前补0，大于9位，取订单id后9位
        String no = StringUtil.leftPadding(salesOrderId.toString(), 9, Constant.STRING_0);
        no = no.substring(no.length() - 9);
        salesOrderNo.append(no);

        return salesOrderNo.toString();
    }

    /**
     * 编辑交易流水单编号
     * <p>
     * 前缀2位[PB]+系统日期6位[yyMMdd]+交易流水ID10位<br/>
     * @param payBillSnId 交易流水ID
     * @param sysDate 系统日期
     * @return 交易流水单编号
     */
    public String editPayBillSn(String payBillSnId, String sysDate) {
        logger.debug("editPayBillSn:编辑交易流水单编号的拼接");
        // 交易流水单编号
        StringBuilder payBillSn = new StringBuilder();
        // 前缀
        payBillSn.append(Constant.PAY_BILL_SN_PRE);
        // 系统日期
        payBillSn.append(sysDate);
        // 交易流水ID10位
        if (payBillSnId.length() > 10) {
            // 长度大于10
            payBillSn.append(payBillSnId.substring(payBillSnId.length() - 10, payBillSnId.length()));
        } else {
            payBillSn.append(StringUtil.leftPadding(payBillSnId, 10, Constant.STRING_0));
        }
        return payBillSn.toString();
    }

    /**
     * 编辑账户流水编号
     * <p>前缀2位[PA]+年月日6位+客户类型[1,2]+变动方式1位[1/2]+序号10位
     * 客户类型[1，2]：1：普通客户 2：大客户 
     * 变动方式[1]：充值;变动方式[2]：订单支付<br/>
     * @param seqId 交易变动方式ID
     * @param payAccountId 账户流水ID
     * @param sysDate 系统日期
     * @return 账户流水编号
     */
    public String editPayAccountBillSn(String paySeqCheckId, String payAccountId, String sysDate, String customerType) {
        logger.debug("editPayAccountBillSn:编辑账户流水编号的拼接");
        // 账户流水编号
        StringBuilder payAccountSn = new StringBuilder();
        // 前缀
        payAccountSn.append(Constant.PAY_ACCOUNT_BILL_SN_PRE);
        // 系统日期
        payAccountSn.append(sysDate);
        // 用户区分1位[1，2，3]：1：注册会员，2：充值的客户会员，3：大客户
        payAccountSn.append(customerType);
        // 变动方式
        if (Constant.CODE_ID_SEQ_FLAG_RECHANGE.equals(paySeqCheckId)) {
            payAccountSn.append(Constant.PAY_ACCOUNT_BILL_SN_RECHANGE);
        } else {
            payAccountSn.append(Constant.PAY_ACCOUNT_BILL_SN_DEFRAY);
        }
        // 账户流水ID
        if (payAccountId.length() > 9) {
            // 长度大于9
            payAccountSn.append(payAccountId.substring(payAccountId.length() - 9, payAccountId.length()));
        } else {
            payAccountSn.append(StringUtil.leftPadding(payAccountId, 9, Constant.STRING_0));
        }
        return payAccountSn.toString();
    }

    /**
     * 生成货品编号
     * 
     * @param productId 货品ID
     * @param productTypeCodeId 货品类型编码ID
     * @return
     */
    public String editProductNo(Long productId, String productTypeCodeId) {

        // 货品类型
        String productCategory = null;

        // 实物
        if (Constant.PRODUCT_CATEGORY_CODE_PHYSICAL.equals(productTypeCodeId)) {
            productCategory = "1";
            // 虚拟
        } else {
            productCategory = "2";
        }

        String subProductId = String.format("%011d", productId);
        subProductId = subProductId.substring(4, 11);

        // 前缀1位[P]+货品类型1位[1/2]+货品ID后7位
        String productNo = "P" + productCategory + subProductId;

        return productNo;
    }

    /**
     * 编辑商品编号
     * 
     * @param goodsId 商品ID
     * @param goodsTypeCodeId 商品类型编码ID
     * @return
     */
    public String editGoodsNo(Long goodsId, String goodsTypeCodeId) {

        // 商品类型
        String goodsType = null;

        // 普通商品
        if (Constant.GOODS_TYPE_CODE_NORMAL.equals(goodsTypeCodeId)) {
            goodsType = "0";
            // 组合商品
        } else {
            goodsType = "1";
        }

        String subGoodsId = String.format("%011d", goodsId);
        subGoodsId = subGoodsId.substring(4, 11);

        // 前缀1位[G]+商品类型1位[0/1]+商品ID后7位
        String goodsNo = "G" + goodsType + subGoodsId;

        return goodsNo;
    }

    /**
     * 编辑发货单编号
     * <p>前缀2位[DO]+系统日期6位[yyMMdd]+发货单ID10位<br>
     * 前缀2位[DO]：delivery order的缩写
     * 系统日期6位[yyMMdd]：系统年的后两位+系统月+系统日
     * 发货单ID10位：10位的发货单ID顺序连番   前补0
     * @param deliveryOrderId 发货单ID
     * @param sysDate 系统日期
     * @return 发货单编号
     */
    public String editDeliveryOrderNo(Long deliveryOrderId, Date sysDate) {
        // 开始日志
        logger.debug("editDeliveryOrderNo：编辑发货单编号的拼接");
        // 销售订单编号
        StringBuilder deliveryOrderNo = new StringBuilder();
        // 前缀3位[COM]：customer order manage的缩写
        deliveryOrderNo.append(Constant.DELIVERY_ORDER_NO_PRE);
        // 系统日期6位[yyMMdd]：系统年的后两位+系统月+系统日
        deliveryOrderNo.append(DateFormatUtils.formatDate(sysDate, DateFormatUtils.FORMAT_YYMMDD));
        // 发货单ID10位：10位的发货单ID顺序连番 前补0
        String no = StringUtil.leftPadding(deliveryOrderId.toString(), 10, Constant.STRING_0);
        no = no.substring(no.length() - 10);
        deliveryOrderNo.append(no);

        return deliveryOrderNo.toString();
    }

    /**
     * 退货单编号
     * <p>
     * 前缀3位[ROM]+系统日期6位[yyMMdd]+用户区分1位[0,1]+订单区分1位[0,1]+订单id9位<br>
     * 前缀3位[ROM]：return order manage的缩写 系统日期6位[yyMMdd]：系统年的后两位+系统月+系统日
     * 客户类型1位[1，2]：1：普通客户 2：大客户 订单区分1位[0，1]：0：主订单 1：子订单 订单ID9位：订单ID的后9位
     * 前补0，大于9位，取订单id后9位
     * </p>
     * 
     * @param salesOrderId
     *            销售订单ID
     * @param sysDate
     *            系统日期
     * @return 销售订单编号
     */
    public String editReturnOrderNo(Long returnOrderId, Date sysDate, String customerType, String salesOrderType) {
        // 开始日志
        logger.debug("editInventoryCheckNo：编辑盘点单编号的拼接");
        // 销售订单编号
        StringBuilder salesOrderNo = new StringBuilder();
        // 前缀3位[ROM]：return order manage的缩写
        salesOrderNo.append(Constant.RETURN_ORDER_NO_PRE);
        // 系统日期6位[yyMMdd]：系统年的后两位+系统月+系统日
        salesOrderNo.append(DateFormatUtils.formatDate(sysDate, DateFormatUtils.FORMAT_YYMMDD));
        // 用户区分1位[1，2，3]：1：注册会员，2：充值的客户会员，3：大客户
        salesOrderNo.append(customerType);
        // 订单区分1位[0，1]：0：主订单 1：子订单
        salesOrderNo.append(salesOrderType);
        // 订单ID9位：订单ID的后9位 前补0，大于9位，取订单id后9位
        String no = StringUtil.leftPadding(returnOrderId.toString(), 9, Constant.STRING_0);
        no = no.substring(no.length() - 9);
        salesOrderNo.append(no);

        return salesOrderNo.toString();
    }

    /**
     * 编辑收货单编号
     * <p>前缀2位[RO]+系统日期6位[yyMMdd]+收货单ID10位<br>
     * 
     * @param receivingOrderId 收货单ID
     * @param sysDate 系统日期6位[yyMMdd]
     * @return 收货单编号
     */
    public String editReceivingOrderNo(String receivingOrderId, String sysDate) {

        // 开始日志
        logger.debug("editReceivingOrderNo：编辑收货单编号的拼接-----开始-----");

        // 收货单编号
        StringBuilder sbReceivingOrderNo = new StringBuilder();

        // 设定收货单编号前缀
        sbReceivingOrderNo.append(Constant.RECEIVING_ORDER_NO_PRE);

        // 设定系统日期
        sbReceivingOrderNo.append(sysDate);

        // 收货单ID的长度大于10的时候
        if (receivingOrderId.length() > 10) {
            sbReceivingOrderNo
                    .append(receivingOrderId.substring(receivingOrderId.length() - 10, receivingOrderId.length()));
        } else {
            sbReceivingOrderNo.append(StringUtil.leftPadding(receivingOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editAllocateOrderNo：编辑收货单编号的拼接-----结束-----");
        return sbReceivingOrderNo.toString();
    }

    /**
     * 编辑货品批号
     * <p>货品编号+生产日期6位[yyMMdd]+采购订单ID10位<br>
     * @param productNo 货品编号
     * @param productDate 生产日期6位[yyMMdd]
     * @return 货品批号
     */
    public String editProductLotNo(String productNo, String produceDate, String purOrderId) {

        // 开始日志
        logger.debug("editProductLotNo：编辑货品批号的拼接-----开始-----");

        // 货品批号
        StringBuilder sbProductLotNo = new StringBuilder();

        // 设定货品批号——货品编号
        if (productNo.length() > 9) {
            sbProductLotNo.append(productNo.substring(productNo.length() - 9, productNo.length()));
        } else {
            sbProductLotNo.append(StringUtil.leftPadding(productNo, 9, Constant.STRING_0));
        }

        // 设定货品批号——系统日期
        sbProductLotNo.append(produceDate);

        // 设定货品批号——采购订单ID
        if (purOrderId.length() > 10) {
            sbProductLotNo.append(purOrderId.substring(purOrderId.length() - 10, purOrderId.length()));
        } else {
            sbProductLotNo.append(StringUtil.leftPadding(purOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editProductLotNo：编编辑货品批号的拼接-----结束-----");
        return sbProductLotNo.toString();
    }

    /**
     * 编辑供应商编号
     * <p>前缀1位[S]+供应商类型1位[1/2/3]+供应商ID6位<br>
     * @param supplierId 供应商ID
     * @param sysDate 系统日期6位[yyMMdd]
     * @return 采购订单编号
     */
    public String editSupplierNo(String supplierId, String supplierTypeCodeId) {

        // 开始日志
        logger.debug("editSupplierNo：编辑采购订单编号的拼接-----开始-----");

        // 供应商编号
        StringBuilder sbSupplierNo = new StringBuilder();

        // 设定采购订单编号前缀
        sbSupplierNo.append(Constant.PUR_SUPPLIER_NO_PRE);

        // 设定供应商类型
        if (supplierTypeCodeId.length() > 1) {
            sbSupplierNo
                    .append(supplierTypeCodeId.substring(supplierTypeCodeId.length() - 1, supplierTypeCodeId.length()));
        } else {
            sbSupplierNo.append(StringUtil.leftPadding(supplierTypeCodeId, 1, Constant.STRING_0));
        }

        // 采购订单ID的长度大于10的时候
        if (supplierId.length() > 6) {
            sbSupplierNo.append(supplierId.substring(supplierId.length() - 6, supplierId.length()));
        } else {
            sbSupplierNo.append(StringUtil.leftPadding(supplierId, 6, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editSupplierNo：编辑供应商编号的拼接-----结束-----");
        return sbSupplierNo.toString();
    }

    /**
     * 编辑退款流水编号
     * <p>系统日期8位[yyyyMMdd]+退款流水标识3位[REF]+退款流水ID9位</p>
     * @param refNoId  退款流水ID
     * @param sysDate 系统日期
     * @return
     */
    public String editPayRefundOrderNo(String refNoId, String sysDate) {
        logger.debug("editRefundOrderNo:编辑款流水编号");
        // 退款流水编号
        StringBuilder refNo = new StringBuilder();
        // 系统日期
        refNo.append(sysDate);
        // 退款流水标识
        refNo.append(Constant.REFUND_ORDER_NO_PRE);
        // 退款流水ID9位
        if (refNoId.length() > 9) {
            // 长度大于9
            refNo.append(refNoId.substring(refNoId.length() - 9, refNoId.length()));
        } else {
            refNo.append(StringUtil.leftPadding(refNoId, 9, Constant.STRING_0));
        }
        return refNo.toString();
    }
    
    /**
     * 编辑采购退货单编号
     * @param sysDate
     * @param returnOrderId
     * @return
     */
    public String editReturnOrderNo(String sysDate, String returnOrderId) {

        // 开始日志
        logger.debug("editReturnOrderNo：编辑采购退货单编号的拼接-----开始-----");

        // 采购退货单编号
        StringBuilder sbReturnOrderNo = new StringBuilder();

        // 设定采购退货单编号前缀
        sbReturnOrderNo.append(Constant.PUR_RETURN_ORDER_NO_PRE);

        // 设定系统日期
        sbReturnOrderNo.append(sysDate);

        // 采购退货单ID的长度大于10的时候
        if (returnOrderId.length() > 10) {
            sbReturnOrderNo.append(returnOrderId.substring(returnOrderId.length() - 10, returnOrderId.length()));
        } else {
            sbReturnOrderNo.append(StringUtil.leftPadding(returnOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editSupplierNo：编辑供应商编号的拼接-----结束-----");
        return sbReturnOrderNo.toString();
    }
    
    /**
     * 编辑仓库编号
     * <p> 前缀2位[SH]+仓库类型1位[1/2]+仓库归属类型1位[1/2/3]+仓库ID6位<br>
     * @param storehouseId 仓库ID
     * @param storehouseTypeCode 仓库类型
     * @param ownershipTypeCode 仓库归属类型
     * @return 仓库编号
     */
    public String editStorehouseNo(String storehouseId, String storehouseTypeCode, String ownershipTypeCode) {

        // 开始日志
        logger.debug("editStorehouseNo：编辑仓库编号-----开始-----");

        // 仓库编号
        StringBuilder sbStorehouseNo = new StringBuilder();

        // 设定仓库编号前缀
        sbStorehouseNo.append(Constant.STOREHOUSE_NO_PRE);

        // 冷冻仓的时候
        if (Constant.STOREHOUSE_TYPE_FREEZING.equals(storehouseTypeCode)) {
            sbStorehouseNo.append(Constant.STOREHOUSE_NO_TYPE_FREEZING);
        } else {
            sbStorehouseNo.append(Constant.STOREHOUSE_NO_TYPE_ORDINARY);
        }
        
        // 自有仓库的时候
        if (Constant.STOREHOUSE_OWNERSHIP_TYPE_OWN.equals(ownershipTypeCode)) {
            sbStorehouseNo.append(Constant.STOREHOUSE_NO_OWNERSHIP_OWN);
            
        // 供应商仓库的时候
        } else if (Constant.STOREHOUSE_OWNERSHIP_TYPE_SUPPLIER.equals(ownershipTypeCode)) {
            sbStorehouseNo.append(Constant.STOREHOUSE_NO_OWNERSHIP_SUPPLIER);
        } else {
            sbStorehouseNo.append(Constant.STOREHOUSE_NO_OWNERSHIP_LOGISTICS);
        }

        // 仓库ID的长度大于6的时候
        if (storehouseId.length() > 6) {
            sbStorehouseNo.append(
                storehouseId.substring(storehouseId.length() - 6, storehouseId.length()));
        } else {
            sbStorehouseNo.append(
                StringUtil.leftPadding(storehouseId, 6, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editStorehouseNo：编辑仓库编号-----结束-----");
        return sbStorehouseNo.toString();
    }

    /**
     * 编辑采购需求单编号
     * <p>
     * 前缀3位[PRO]+系统日期6位[yyMMdd]+采购需求单ID10位<br>
     * 
     * @param purRequireOrderId
     *            采购需求单ID
     * @param sysDate
     *            系统日期6位[yyMMdd]
     * @return 采购需求单编号
     */
    public String editPurRequireOrderNo(String purRequireOrderId, String sysDate) {

        // 开始日志
        logger.debug("editPurRequireOrderNo：编辑采购需求单编号的拼接-----开始-----");

        // 采购需求单编号
        StringBuilder sbPurRequireOrderNo = new StringBuilder();

        // 设定采购需求单编号前缀
        sbPurRequireOrderNo.append(Constant.PUR_REQUIRE_ORDER_NO);

        // 设定系统日期
        sbPurRequireOrderNo.append(sysDate);

        // 出库单ID的长度大于10的时候
        if (sbPurRequireOrderNo.length() > 10) {
        	sbPurRequireOrderNo
                    .append(purRequireOrderId.substring(purRequireOrderId.length() - 10, purRequireOrderId.length()));
        } else {
        	sbPurRequireOrderNo.append(StringUtil.leftPadding(purRequireOrderId, 10, Constant.STRING_0));
        }

        // 结束日志
        logger.debug("editOutStoreOrderNo：编辑出库单编号的拼接-----结束-----");
        return sbPurRequireOrderNo.toString();
    }
}
