package com.cn.dao.entity.id;

import java.io.Serializable;

/**
 * 编码信息表主键
 * <p>保存编码信息表主键的类<br>
 * @author 孙亮
 * @version 1.0 2016/5/4
 */
public class MCodeMasterPk implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 编码组ID */
    private String codeGroupId;

    /** 编码ID */
    private String codeId;

    /**
     * 空构造函数
     */
    public MCodeMasterPk() {
    }
    
    /**
     * 构造函数
     * @param codeGroupId 编码组ID
     * @param codeId 编码ID
     */
    public MCodeMasterPk(String codeGroupId, String codeId) {
        this.codeGroupId = codeGroupId;
        this.codeId = codeId;
    }

    /**
     * 编码组ID的取得
     * @return 编码组ID
     */
    public String getCodeGroupId() {
        return this.codeGroupId;
    }

    /**
     * 编码组ID的设定
     * @param codeGroupId 编码组ID
     */
    public void setCodeGroupId(String codeGroupId) {
        this.codeGroupId = codeGroupId;
    }

    /**
     * 编码ID的取得
     * @return 编码ID
     */
    public String getCodeId() {
        return this.codeId;
    }

    /**
     * 编码ID的设定
     * @param codeId 编码ID
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    /**
     * 重写hashCode方法
     * @return 返回对象的hashCode
     */
    @Override
    public int hashCode() {
        StringBuilder sbHashCode = new StringBuilder();
        sbHashCode.append(codeGroupId);
        sbHashCode.append("-");
        sbHashCode.append(codeId);
        return sbHashCode.hashCode();
    }

    /**
     * 重写equals方法
     * @return 返回是否相等
     */
    @Override
    public boolean equals(Object obj) {
        
        // 引用同一个对象的时候
        if (this == obj) {
            return true;
        }
        
        // 比较对象是null或类型不对的的事
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        // 类型转换
        MCodeMasterPk other = (MCodeMasterPk)obj;
        
        return String.valueOf(this.codeGroupId).equals(String.valueOf(other.getCodeGroupId())) && 
                String.valueOf(this.codeId).equals(String.valueOf(other.getCodeId()));
    }
    
    /**
     * 重写toString方法
     * @return 返回对象的内容
     */
    @Override
    public String toString() {

        // bean内容
        StringBuilder sbBeanContent = new StringBuilder();
        sbBeanContent.append("[");

        // 编码组ID
        sbBeanContent.append("codeGroupId=");
        sbBeanContent.append(codeGroupId);
        sbBeanContent.append(",");

        // 编码ID
        sbBeanContent.append("codeId=");
        sbBeanContent.append(codeId);

        sbBeanContent.append("]");
        return sbBeanContent.toString();
    }
}
