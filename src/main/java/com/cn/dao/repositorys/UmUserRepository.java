/** 
 * 用户表Dao接口
 * <p>用户表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.UmUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 用户表Dao接口
 * <p>用户表Dao接口</p>
 * @author 王成龙
 * @version 1.0 2016/4/23
 */
@Repository
public interface UmUserRepository extends IBaseRepository<UmUserEntity, Long> {

    /**
     * 根据账号查询对象UmUserEntity
     * @param userName 账号
     * @return 对象UmUserEntity
     */
    public UmUserEntity findByUserName(String userName);

    /**
     * 根据账号和密码查询对象UmUserEntity
     * @param username 账号
     * @param password 密码
     * @return 对象UmUserEntity
     */
    public UmUserEntity findByUserNameAndPassword(String username, String password);

    /**
     * 根据用户Id，查询用户信息
     * @param userIds
     * @return
     */
    public List<UmUserEntity> findByUserIdIn(Collection<Long> userIds);

    /**
     * 根据员工号、用户名，都使用模糊查询
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @return umUserEntityList
     */
    public List<UmUserEntity> findByEmployeeNoLikeOrUserNameLike(String employeeNo,
                                                                 String userName);

    /**
     * 根据员工号查询客户
     * @param employeeNo: 员工号
     * @return UmUserEntity
     */
    public UmUserEntity findByEmployeeNo(String employeeNo);

    /**
     * 根据手机号查询客户
     * @param cellphoneNo: 手机号
     * @return UmUserEntity
     */
    public UmUserEntity findByCellphoneNo(String cellphoneNo);


    /**
     * 根据用户Id查询用户
     * @param userId: 用户Id
     * @return umUserEntity
     */
    public UmUserEntity findByUserId(Long userId);

    /**
     * 根据条件搜索后台客户信息并分页
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @param userIdList: 用户ID集合
     * @param isDetele: 是否删除,0: 否   1: 是
     * @param pageable: Pageable对象
     * @return Page
     */
    public Page<UmUserEntity> searchByEmployeeNoAndUserNameAndUserId(String employeeNo, String userName,
                                                                     List<Long> userIdList, String isDetele, Pageable pageable);
}
