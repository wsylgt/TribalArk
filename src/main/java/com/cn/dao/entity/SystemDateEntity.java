package com.cn.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Kris2 on 2016/8/25.
 */
@Entity
public class SystemDateEntity {
    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 时间 */
    @Id
    private Date systemDate;
}
