package com.emall.base.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户登录Model
 * <p>客户登录Model</p>
 * @author 刘广飞
 * @version 1.0 2016/4/22
 */
public class GoodInfoModel implements Serializable{

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    @NotNull
    @Digits(integer=11, fraction=0)
    @Range(min = 1, max = 99999999999L)
    private Long goodsId;

    /** 商品编码 */
    private String goodsNo;

    /** 商品名称 */
    private String goodsName;

    /** 品牌ID */
    private Long brandId;

    /** 品牌名称 */
    private String brandName;

    /** 商品类型编码组ID */
    private String goodsTypeGroupId;

    /** 商品类型编码ID */
    private String goodsTypeCodeId;

    /** 商品类型名称 */
    private String goodsTypeName;

    /** 商品类别编码组ID */
    private String goodsCategoryGroupId;

    /** 商品类别编码ID */
    private String goodsCategoryCodeId;

    /** 商品类别名称 */
    private String goodsCategoryName;

    /** 最小购买数量 */
    private long minBuyNum;

    /** 包装清单 */
    private String packageList;

    /** 上下架状态 */
    private String onOffSaleState;

    /** 逻辑删除标识 */
    private String deleteFlag;

    /** 出售价格 */
    @NotNull
    @Digits(integer=10, fraction=2)
    private BigDecimal salePrice;

    /** 缩略图片url */
    private String galleryThumbImgUrl;

    /** 实际图片url */
    private String galleryImgUrl;

    /** 图片说明信息 */
    private String galleryImgDesc;

    /** 货品ID */
    private Long productId;

    /** 货品编号 */
    private String productNo;

    /** 货品名称 */
    private String productName;

    /** 规格选择串名称 */
    private String specificationName;

    /** 商品购买数量 */
    @NotNull
    @Digits(integer=11, fraction=0)
    @Range(min = 1, max = 99999999999L)
    private Long goodBuyCount;

    /** 促销活动ID */
    private int promotionProgramId;

    /** 促销活动ID */
    private String promotionProgramName;

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGoodsTypeGroupId() {
        return goodsTypeGroupId;
    }

    public void setGoodsTypeGroupId(String goodsTypeGroupId) {
        this.goodsTypeGroupId = goodsTypeGroupId;
    }

    public String getGoodsTypeCodeId() {
        return goodsTypeCodeId;
    }

    public void setGoodsTypeCodeId(String goodsTypeCodeId) {
        this.goodsTypeCodeId = goodsTypeCodeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public String getGoodsCategoryGroupId() {
        return goodsCategoryGroupId;
    }

    public void setGoodsCategoryGroupId(String goodsCategoryGroupId) {
        this.goodsCategoryGroupId = goodsCategoryGroupId;
    }

    public String getGoodsCategoryCodeId() {
        return goodsCategoryCodeId;
    }

    public void setGoodsCategoryCodeId(String goodsCategoryCodeId) {
        this.goodsCategoryCodeId = goodsCategoryCodeId;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName) {
        this.goodsCategoryName = goodsCategoryName;
    }

    public long getMinBuyNum() {
        return minBuyNum;
    }

    public void setMinBuyNum(long minBuyNum) {
        this.minBuyNum = minBuyNum;
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList;
    }

    public String getOnOffSaleState() {
        return onOffSaleState;
    }

    public void setOnOffSaleState(String onOffSaleState) {
        this.onOffSaleState = onOffSaleState;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getGalleryThumbImgUrl() {
        return galleryThumbImgUrl;
    }

    public void setGalleryThumbImgUrl(String galleryThumbImgUrl) {
        this.galleryThumbImgUrl = galleryThumbImgUrl;
    }

    public String getGalleryImgUrl() {
        return galleryImgUrl;
    }

    public void setGalleryImgUrl(String galleryImgUrl) {
        this.galleryImgUrl = galleryImgUrl;
    }

    public String getGalleryImgDesc() {
        return galleryImgDesc;
    }

    public void setGalleryImgDesc(String galleryImgDesc) {
        this.galleryImgDesc = galleryImgDesc;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public Long getGoodBuyCount() {
        return goodBuyCount;
    }

    public void setGoodBuyCount(Long goodBuyCount) {
        this.goodBuyCount = goodBuyCount;
    }

    public int getPromotionProgramId() {
        return promotionProgramId;
    }

    public void setPromotionProgramId(int promotionProgramId) {
        this.promotionProgramId = promotionProgramId;
    }

    public String getPromotionProgramName() {
        return promotionProgramName;
    }

    public void setPromotionProgramName(String promotionProgramName) {
        this.promotionProgramName = promotionProgramName;
    }
}
