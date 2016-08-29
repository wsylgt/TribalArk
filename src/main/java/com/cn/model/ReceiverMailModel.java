package com.cn.model;

import java.io.Serializable;

/**
 * 收件人model
 * <p>收件人model<br>
 * @author 王国栋
 * @version 1.0 2016/5/27
 */
public class ReceiverMailModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 收件人 */
    private String receiver;

    /** 主题 */
    private String theme;

    /** 邮件内容 */
    private String mailContent;

    /**
     * 接受者的取得
     * @return 接受者
     */
    public String getReceiver() {
        return this.receiver;
    }

    /**
     * 接受者的设定
     * @param receiver 接受者
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 主题的取得
     * @return 主题
     */
    public String getTheme() {
        return this.theme;
    }

    /**
     * 主题的设定
     * @param theme 主题
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 邮件内容的取得
     * @return 邮件内容
     */
    public String getMailContent() {
        return this.mailContent;
    }

    /**
     * 邮件内容的设定
     * @param mailContent 邮件内容
     */
    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    /**
     * 无参构造方法
     */
    public ReceiverMailModel() {

    }

    /**
     * 有参构造方法
     */
    public ReceiverMailModel(String receiver, String theme, String mailContent) {
        super();
        this.receiver = receiver;
        this.theme = theme;
        this.mailContent = mailContent;
    }

}
